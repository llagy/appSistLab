/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raitcon.web.session;

import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Mike
 */
public class SessionPhaseListener implements PhaseListener {
    
    private static final String homepage = "/faces/sessionExpired.xhml";
    protected static Logger log = Logger.getLogger(SessionPhaseListener.class); 
  private static  final  long serialVersionUID=-2377612760546575078L;
    @Override
    public void afterPhase(PhaseEvent event) {
        //Do anything
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        ExternalContext ext = context.getExternalContext();
        HttpSession session = (HttpSession) ext.getSession(false);
        boolean newSession = (session == null) || (session.isNew());
        boolean postback = !ext.getRequestParameterMap().isEmpty();
        boolean timedout = postback && newSession;
        System.out.println("timeout:"+timedout);
        if (timedout) {
            Application app = context.getApplication();
            ViewHandler viewHandler = app.getViewHandler();
            UIViewRoot view = viewHandler.createView(context, "/" + homepage);
            
            context.setViewRoot(view);
            context.renderResponse();
            try {
                viewHandler.renderView(context, view);
                context.responseComplete();
               //logout();
            } catch (Throwable t) {
                throw new FacesException("Session timed out", t);
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
    
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
