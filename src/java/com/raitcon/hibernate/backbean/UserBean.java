package com.raitcon.hibernate.backbean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.raitcon.hibernate.bean.Usuario;
import com.raitcon.hibernate.db.UsuarioDB;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;


/**
 *
 * @author Mike
 */
@ManagedBean(name="userBean")
 @SessionScoped
public class UserBean implements Serializable {

   /* public List<String> autocomplete(String prefix) {

        ArrayList<String> result = new ArrayList<String>();
        result.add("England");
        result.add("France");
        result.add("Germany");
        result.add("Italy");
        result.add("Spain");

        return result;
    }*/
   private static  final  long serialVersionUID=-2177612760546575078L;
   //@Size(min=3, max=12,message="Must be between 3 and 12 chars")
    private Integer id;
    private String text;
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private String state;

    

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param user the user to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
     public String getText() {
        return text;
    }
    
    
    public String eliminarEmpleado(String idEmpleado){
       System.out.println("Eliminando usuario:"+idEmpleado);
       return null;
    }
    
    
    

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
  public String validUser() throws Exception{
  String returnString = "success";
   
  UsuarioDB usuarioDB=new UsuarioDB();
   
 Usuario user= usuarioDB.getValidateUser(getUsuario(), getPassword());
  if(user!=null){
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session = 
     (HttpSession)context.getExternalContext().getSession(true);
    
    session.setAttribute("idRol", user.getRol().getIdRol());
    session.setAttribute("userName", user.getLogin());
    setId(user.getIdusuario());
    setNombre(user.getNombre());
    setApellidos(user.getApellidos());
   }
  else{
    setText("Usuario o Password es incorrecto.");
    returnString = "failure";
  }
  
  
  return returnString;
  }

    /**
     * @return the text
     */
   
  public void logout() {
  ExternalContext ctx = 
      FacesContext.getCurrentInstance().getExternalContext();
  String ctxPath = 
      ((ServletContext) ctx.getContext()).getContextPath();

  try {
    // Usar el contexto de JSF para invalidar la sesión,
    // NO EL DE SERVLETS (nada de HttpServletRequest)
      System.out.println("Iniciar logout");
    ((HttpSession) ctx.getSession(false)).invalidate();

    // Redirección de nuevo con el contexto de JSF,
    // si se usa una HttpServletResponse fallará.
    // Sin embargo, como ya está fuera del ciclo de vida 
    // de JSF se debe usar la ruta completa -_-U
    ctx.redirect(ctxPath + "/faces/index.xhtml");
    System.out.println("logout ok!!");
  } catch (IOException ex) {
    ex.printStackTrace();
  }
}
  
}
