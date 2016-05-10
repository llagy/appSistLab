package com.raitcon.hibernate.bean;
// Generated 09/05/2016 10:48:05 PM by Hibernate Tools 3.2.1.GA



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DtExamenInsumoId generated by hbm2java
 */
@Embeddable
public class DtExamenInsumoId  implements java.io.Serializable {


     private String codInsumo;
     private String codExamen;

    public DtExamenInsumoId() {
    }

    public DtExamenInsumoId(String codInsumo, String codExamen) {
       this.codInsumo = codInsumo;
       this.codExamen = codExamen;
    }
   

    @Column(name="cod_insumo", nullable=false, length=10)
    public String getCodInsumo() {
        return this.codInsumo;
    }
    
    public void setCodInsumo(String codInsumo) {
        this.codInsumo = codInsumo;
    }

    @Column(name="cod_examen", nullable=false, length=10)
    public String getCodExamen() {
        return this.codExamen;
    }
    
    public void setCodExamen(String codExamen) {
        this.codExamen = codExamen;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DtExamenInsumoId) ) return false;
		 DtExamenInsumoId castOther = ( DtExamenInsumoId ) other; 
         
		 return ( (this.getCodInsumo()==castOther.getCodInsumo()) || ( this.getCodInsumo()!=null && castOther.getCodInsumo()!=null && this.getCodInsumo().equals(castOther.getCodInsumo()) ) )
 && ( (this.getCodExamen()==castOther.getCodExamen()) || ( this.getCodExamen()!=null && castOther.getCodExamen()!=null && this.getCodExamen().equals(castOther.getCodExamen()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodInsumo() == null ? 0 : this.getCodInsumo().hashCode() );
         result = 37 * result + ( getCodExamen() == null ? 0 : this.getCodExamen().hashCode() );
         return result;
   }   


}


