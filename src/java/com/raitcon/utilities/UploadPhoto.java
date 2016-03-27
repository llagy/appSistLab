/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author Mike
 */
@ManagedBean(name="uploadPhoto")  
@ViewScoped 
public class UploadPhoto {
    
    private Part file1;  
    private Part file2;  
    private Part file;
    private String fileContent;
  
    // getters and setters for file1 and file2  
  
    public String upload() throws IOException { 
         System.out.println("file1:"+getFile1());
        System.out.println(getFile1().getInputStream());
        try {
             file1.write("D:\\fotos\\"+getFilename(file1));
             file2.write("D:\\fotos\\"+getFilename(file2));
        
     /*   InputStream inputStream = getFile1().getInputStream();          
        FileOutputStream outputStream = new FileOutputStream(getFilename(getFile1()));  
          
        byte[] buffer = new byte[4096];          
        int bytesRead = 0;  
        while(true) {                          
            bytesRead = inputStream.read(buffer);  
            if(bytesRead > 0) {  
                outputStream.write(buffer, 0, bytesRead);  
            }else {  
                break;  
            }                         
        }  
        outputStream.close();  
        inputStream.close(); */ 
         
        return "success";  
        } catch (Exception e) {
            return "failed"; 
        }
    }  
    
    public void upload2() {
    try {
            setFileContent(new Scanner(getFile().getInputStream())
                 .useDelimiter("\\A").next());
    } catch (IOException e) {
      e.printStackTrace();
    }
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

    /**
     * @return the file2
     */
    public Part getFile2() {
        return file2;
    }

    /**
     * @param file2 the file2 to set
     */
    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    /**
     * @return the file1
     */
    public Part getFile1() {
        return file1;
    }

    /**
     * @param file1 the file1 to set
     */
    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    /**
     * @return the fileContent
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * @param fileContent the fileContent to set
     */
    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    /**
     * @return the file
     */
    public Part getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(Part file) {
        this.file = file;
    }
    

    public void validateFile(FacesContext ctx,
                         UIComponent comp,
                         Object value) {
  List<FacesMessage> msgs = new ArrayList<FacesMessage>();
  Part file = (Part)value;
  if (file.getSize() > 10024) {
    msgs.add(new FacesMessage("file too big"));
  }
  if (!"text/plain".equals(file.getContentType())) {
    msgs.add(new FacesMessage("not a text file"));
  }
  if (!msgs.isEmpty()) {
    throw new ValidatorException(msgs);
  }
}
}
