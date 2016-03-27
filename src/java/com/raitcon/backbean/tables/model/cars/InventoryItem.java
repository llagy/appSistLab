package com.raitcon.backbean.tables.model.cars;

import java.io.Serializable;

public class InventoryItem extends InventoryVendorItem implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2052446469750935597L;
    private String vendor;
    private String ape_ma;
    private String asigna;

    public String getApe_ma() {
        return ape_ma;
    }

    public void setApe_ma(String ape_ma) {
        this.ape_ma = ape_ma;
    }

    public String getAsigna() {
        return asigna;
    }

    public void setAsigna(String asigna) {
        this.asigna = asigna;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
