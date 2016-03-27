package com.raitcon.hibernate.backbean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.raitcon.hibernate.bean.Menu;
import com.raitcon.hibernate.bean.SubMenu;
import com.raitcon.hibernate.db.RolesAccionDB;
import com.raitcon.hibernate.db.SubMenuDB;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


/**
 *
 * @author Mike
 */
@ManagedBean(name="menuBean")
@SessionScoped
public class MenuBean implements Serializable {

    private static  final  long serialVersionUID=-2477612760546575078L;
    private List<Model> list;
    private List<SubMenu> listSubMenu;
   
 
    public MenuBean() {
        
       
           
       }
       @PostConstruct
       public  void init(){
           
           RolesAccionDB rolesAccion=new RolesAccionDB();
       Integer idRol=1;
       
        try {
            
        
       FacesContext facesContext = FacesContext. getCurrentInstance();
       ExternalContext externalContext = facesContext.getExternalContext();
       //Map params = externalContext.getRequestParameterMap();
       Map params = externalContext.getSessionMap();
       //idRol = new Integer(((UserBean) params.get("userBean" )).getId());
      idRol = ((Integer) params.get("idRol" )==null?1:(Integer) params.get("idRol" ));
       } catch (Exception e) {
           System.out.println("Error al capturar parametro idRole:"+e.getMessage());
        }
       System.out.println("idRole:"+idRol);
       
       List<Menu> listMenu=rolesAccion.getMenubyIdRol(idRol);
       this.list = new ArrayList<Model>();
       for(Menu o:listMenu){
           //Asignamos la cabecera
           Model m= new Model(o.getDescripcion());
           // Lista de item del menu
           List <ItemDetail> listDt=new ArrayList();
           SubMenuDB subMenu=new SubMenuDB();
          List<SubMenu> listSubMenu= subMenu.getSubMenuByIdMenu(o.getIdMenu());
          
          //Recorremos los items del menu
          for( SubMenu os: listSubMenu){
              
              ItemDetail item=new ItemDetail(os.getDescripcion(),os.getPagina());
             // System.out.println("os.getName():" +os.getName()+"," +"os.getPageName():"+os.getPageName());
              listDt.add(item);
          }
          
            m.setListDetail(listDt);
            this.list.add(m);
           
       }
        
      /* this.list = new ArrayList<Model>();
 
        //for (int i = 0; i < 5; i++) {
         //   Model m = new Model(String.valueOf(i), String.valueOf(i));
         //   this.list.add(m);
        //}
        //Simulando la carga de una base datod
        
        Model m = new Model("Control de Notas");
        // Lista de item del menu
        List <ItemDetail> listDt=new ArrayList();
        ItemDetail item=new ItemDetail("Registro de Notas","registro_alumno");
        ItemDetail item2=new ItemDetail("Registro de Nominas","templateMain.xhtml");
        ItemDetail item3=new ItemDetail("Registro de Asistencia","templateMain.xhtml");
        listDt.add(item);
        listDt.add(item2);
        listDt.add(item3);
        m.setListDetail(listDt);
        this.list.add(m);
        
        Model m2 = new Model("Matrícula");
        // Lista de item del menu
        List <ItemDetail> listDt2=new ArrayList();
        ItemDetail item11=new ItemDetail("Proceso de admision","templateMain.xhtml");
        ItemDetail item22=new ItemDetail("Registro de Matricula","templateMain.xhtml");
        ItemDetail item33=new ItemDetail("Control de pagos","templateMain.xhtml");
        listDt2.add(item11);
        listDt2.add(item22);
        listDt2.add(item33);
        m2.setListDetail(listDt2);
        this.list.add(m2);
        
        
        Model m3 = new Model("Caja");
        // Lista de item del menu
        List <ItemDetail> listDt3=new ArrayList();
        ItemDetail item111=new ItemDetail("Registro de boletas","registro_notas.xhtml");
        ItemDetail item222=new ItemDetail("Emisión de recibos","templateMain.xhtml");
        ItemDetail item333=new ItemDetail("Emisión de facturas","templateMain.xhtml");
        ItemDetail item444=new ItemDetail("Control de deudas","templateMain.xhtml");
        ItemDetail item5=new ItemDetail("Libro diario","templateMain.xhtml");
        listDt3.add(item111);
        listDt3.add(item222);
        listDt3.add(item333);
        listDt3.add(item444);
        listDt3.add(item5);
        m3.setListDetail(listDt3);
        this.list.add(m3);
        
        Model m4 = new Model("Administración del Sistema");
        // Lista de item del menu
        List <ItemDetail> listDt4=new ArrayList();
        ItemDetail item1111=new ItemDetail("Registro de usuario","templateMain.xhtml");
        ItemDetail item2222=new ItemDetail("Roles y privilegios","templateMain.xhtml");
        ItemDetail item3333=new ItemDetail("Seguridad del Sistema","templateMain.xhtml");
        listDt4.add(item1111);
        listDt4.add(item2222);
        listDt4.add(item3333);
       
        m4.setListDetail(listDt4);
        this.list.add(m4);
        
        Model m5 = new Model("Reportes ");
        // Lista de item del menu
        List <ItemDetail> listDt5=new ArrayList();
        ItemDetail item11111=new ItemDetail("Reporte Record Cuentas","templateMain.xhtml");
        ItemDetail item22222=new ItemDetail("Reporte de Notas","templateMain.xhtml");
       
        listDt5.add(item11111);
        listDt5.add(item22222);
       
       
        m5.setListDetail(listDt5);
        this.list.add(m5);*/
            
    }
 
   public List<Model> getList() {
        return list;
    }
 
    public void setList(List<Model> list) {
        this.list = list;
    }
    
     /* public void deleteAction(ActionEvent event){
       String index = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("index");
       if (index!=null && index.length()>0){
          list.remove(Integer.parseInt(index));
       }
    }*/
 
   /* public void addAction(ActionEvent event) {
       list.add(new Model(String.valueOf(list.size()), String.valueOf(list.size())));
    }*/
      
     /* public  <RolesAccion> getRolesAccion(){
          
      }*/
      
      
    /*  public List<RolesAccion> listRolesAccion(Integer idRoleAccion){
          
           RolesAccionDB rolesAccionDB=new RolesAccionDB();
        
           list=rolesAccionDB.getRolesAccionById(idRoleAccion);
          
          return list;
      }*/
      
      
       public List<Menu> listMenuByIdRol(Integer idRol){
          
           
          RolesAccionDB rolesAccion=new RolesAccionDB();
          
         List<Menu>listMenu=rolesAccion.getMenubyIdRol(idRol);
          return listMenu;
          
      
          
      }
      
      public List<SubMenu> listSubMenuByIdMenu(Integer idMenu){
          
          SubMenuDB subMenuDB=new SubMenuDB();
          
          listSubMenu= subMenuDB.getSubMenuByIdMenu(idMenu);
          return listSubMenu;
          
      
          
      }
      public  void menuAccordion(Integer idRole ){
           RolesAccionDB rolesAccion=new RolesAccionDB();
       List<Menu> listMenu=rolesAccion.getMenubyIdRol(idRole);
       this.list = new ArrayList<Model>();
       for(Menu o:listMenu){
           //Asignamos la cabecera
           Model m= new Model(o.getDescripcion());
           // Lista de item del menu
           List <ItemDetail> listDt=new ArrayList();
           SubMenuDB subMenu=new SubMenuDB();
          List<SubMenu> listSubMenu= subMenu.getSubMenuByIdMenu(o.getIdMenu());
          
          //Recorremos los items del menu
          for( SubMenu os: listSubMenu){
              
              ItemDetail item=new ItemDetail(os.getDescripcion(),os.getPagina());
              listDt.add(item);
          }
          
            m.setListDetail(listDt);
            this.list.add(m);
           
       }
      }
      
       

}
