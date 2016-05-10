package com.raitcon.hibernate.backbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/*@SessionScoped 
@ManagedBean*/
@ManagedBean(name = "dynamicPanelBean")
@ViewScoped
public class DynamicPanelBean {
    private static final long serialVersionUID = -2377612760546575178L;
    protected static Logger log = Logger.getLogger(VentaBean.class);
    private String activeTab;

    public String getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(String activeTab) {
        this.activeTab = activeTab;
    }
    
    public void activeTabPanel(){
        
       if(this.activeTab.compareTo("idTabOtros")==0) {
           System.out.println("Se activó idTabOtros");
       }else{
            System.out.println("Se activó idTabDetalle");
       }
    }
    
    
    
}
