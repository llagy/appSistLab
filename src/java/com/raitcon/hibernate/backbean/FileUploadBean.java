/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.hibernate.backbean;

import com.raitcon.backbean.common.UploadedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 *
 * @author Guillermo Lap
 */
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
    
    
    public void listener(FileUploadEvent event) throws Exception {
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
         file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        this.files=file;
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
}
