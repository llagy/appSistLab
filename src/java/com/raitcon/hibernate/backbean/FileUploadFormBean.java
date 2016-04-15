/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;

/**
 *
 * @author Guillermo Lap
 */
@ManagedBean(name = "fileUploadFormBean")
@ViewScoped
public class FileUploadFormBean implements Serializable {
    
     private static final long serialVersionUID = -2377612760546575078L;
    protected static Logger log = Logger.getLogger(FileUploadFormBean.class); 
    
    private Part fileUpload;
    private  String fName;

    /**
     * Creates a new instance of FileUploadFormBean
     */
    public FileUploadFormBean() {
    }

    public Part getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(Part fileUpload) {
        this.fileUpload = fileUpload;
        
    }

    public String getfName() {
        fName=getFilename(this.fileUpload);
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
    
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
}
