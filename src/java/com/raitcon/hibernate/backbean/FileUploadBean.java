/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.backbean.common.UploadedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;


/**
 *
 * @author Guillermo Lap
 */
@ManagedBean(name = "fileUploadBean")
@ViewScoped

public class FileUploadBean implements Serializable {
    
  private  UploadedImage files = new UploadedImage();

 
  public void paint(OutputStream stream, UploadedImage file) throws IOException {
        stream.write(file.getData());
        stream.close();
    }
  
  
  public UploadedImage getFiles() {
        return files;
    }

    public void setFiles(UploadedImage files) {
        this.files = files;
    }
    
    
    public void listener(FileUploadEvent event){
        
        try
        {
        UploadedFile item = event.getUploadedFile();
        //System.out.println("Ingreso aqui :"+item.getName());
        //File fileAux=new File(item.getName());
        //fileAux.getName();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
       
        this.files=file;
        }catch(Exception e){
        System.out.println("Error al cargar imagen:"+e.getMessage());
        }
    
    }
    
    
    public String clearUploadData() {
        files=null;
        return null;
    }
    
    public int getSize() {
       
            return 0;
        
    }
   
    
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }
    
   /* public boolean guardarImagen(String ruta,String nombre){
	String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
	FileInputStream fis = null;
        
	PreparedStatement ps = null;
	try {
		conexion.setAutoCommit(false);
		File file = new File(ruta);
                file.
		fis = new FileInputStream(file);
		ps = conexion.prepareStatement(insert);
		ps.setBinaryStream(1,fis,(int)file.length());
		ps.setString(2, nombre);
		ps.executeUpdate();
		conexion.commit();
		return true;
	} catch (Exception ex) {
		Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
	}finally{
		try {
			ps.close();
			fis.close();
		} catch (Exception ex) {
			Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}        
	return false;
}*/
}
