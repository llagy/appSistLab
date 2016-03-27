package com.raitcon.logging;
import java.io.File;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.BasicConfigurator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

// No se emplementa la funcionalidad de firma digital
//*import com.alignet.iiidsecure.xml.dsig.util.LeerProperties;

/**
 * @version 	1.0
 * @author Fredy Huam�n
 */
public class LoadProperties extends HttpServlet {

	
    
       /**
	* @see javax.servlet.GenericServlet#void ()
	*/
    
   private static final long serialVersionUID = 1L;
    
   
   
       public void init(ServletConfig config) throws ServletException {
         

// OJO No se emplementa la funcionalidad de firma digital
      System.out.println("LoadProperties.init Inicio");
        super.init(config);	
       
        // Extrae el path donde se encuentra el contexto
        String prefix =  config.getServletContext().getRealPath("\\");
         System.setProperty ("webRoot", prefix);
        // Lee el nombre del archivo de configuraci�n de Log4J
        
        String file = config.getInitParameter("log4j-init-file");
        //String log4jLocation = config.getInitParameter("log4j-init-file");
        //if(file==null)
        //    file = getInitParameter("log4j-conf-file");
//*        String llavero = config.getInitParameter("llavero");
        
		// Revisa otra par�metro de configuraci�n que le indica
        String watch = config.getInitParameter("watch");

        // Extrae el par�metro que le indica cada que tiempo debe revisar el archivo de configuraci�n
        String timeWatch = config.getInitParameter("time-watch");
        
		System.out.println("Ruta confLog4j ="+prefix+file);
//*		System.out.println("Ruta llavero ="+prefix+llavero);

		//Carga los archivos properties para la generar la firma digital
		try {
//*			LeerProperties.init(prefix+llavero);	
		} catch (Exception e) {
			System.out.println("Exception en carga de llavero para firma");
		}        
        
        if(file == null || file.length() == 0 || !(new File(prefix+file)).isFile()){
                System.err.println("ERROR: No puede leer el archivo de configuraci�n. ");
                throw new ServletException();
        }

        // Revisa como debe realizar la configuraci�n de Log4J y llama al m�todo adecuado
        if (watch != null && watch.equalsIgnoreCase("true")) {
            if (timeWatch != null) {
                PropertyConfigurator.configureAndWatch(prefix+file,Long.parseLong(timeWatch));
            } else {
                PropertyConfigurator.configureAndWatch(prefix+file);
            }
        } else {
            PropertyConfigurator.configure(prefix+file);
        }

		System.out.println("LoadProperties.init Fin");
            
           
           /*System.out.println("Log4JInitServlet is initializing log4j");
		String log4jLocation = config.getInitParameter("log4j-init-file");

		ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
		} else {
			String webAppPath = sc.getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			File yoMamaYesThisSaysYoMama = new File(log4jProp);
			if (yoMamaYesThisSaysYoMama.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				PropertyConfigurator.configure(log4jProp);
			} else {
				System.err.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
		super.init(config);*/
           
    }


	/**
	 * @see javax.servlet.Servlet#destroy()
	 */
	public void destroy() {
		
		System.out.println("Inicio StartLog4J.destroy");	
		Logger.getRootLogger().getLoggerRepository().shutdown();		
		super.destroy();
		System.out.println("Fin StartLog4J.destroy");
	}

}
