/**
 *
 */
package com.raitcon.backbean.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.raitcon.backbean.common.data.RandomHelper;
import com.raitcon.backbean.tables.model.cars.InventoryItem;
import com.raitcon.backbean.tables.model.cars.InventoryVendorItem;
import com.raitcon.backbean.tables.model.cars.InventoryVendorList;

@ManagedBean(name = "carsBean")
@ViewScoped
public class CarsBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3832235132261771583L;
    private static final int DECIMALS = 1;
    private static final int CLIENT_ROWS_IN_AJAX_MODE = 15;
    private static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
    private List<InventoryItem> allInventoryItems = null;
    private List<InventoryVendorList> inventoryVendorLists = null;
    private int currentCarIndex;
    private InventoryItem editedCar;
    private int page = 1;
    private int clientRows;

    public void switchAjaxLoading(ValueChangeEvent event) {
        this.clientRows = (Boolean) event.getNewValue() ? CLIENT_ROWS_IN_AJAX_MODE : 0;
    }

    public void remove() {
        allInventoryItems.remove(allInventoryItems.get(currentCarIndex));
    }

    public void store() {
        allInventoryItems.set(currentCarIndex, editedCar);
    }

    public List<SelectItem> getVendorOptions() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        result.add(new SelectItem("", ""));
        for (InventoryVendorList vendorList : getInventoryVendorLists()) {
            result.add(new SelectItem(vendorList.getVendor()));
        }
        return result;
    }

    public List<String> getAllVendors() {
        List<String> result = new ArrayList<String>();
        for (InventoryVendorList vendorList : getInventoryVendorLists()) {
            result.add(vendorList.getVendor());
        }
        return result;
    }

    public List<InventoryVendorList> getInventoryVendorLists() {
        synchronized (this) {
            if (inventoryVendorLists == null) {
                inventoryVendorLists = new ArrayList<InventoryVendorList>();
                List<InventoryItem> inventoryItems = getAllInventoryItems();

                Collections.sort(inventoryItems, new Comparator<InventoryItem>() {
                    public int compare(InventoryItem o1, InventoryItem o2) {
                        return o1.getVendor().compareTo(o2.getVendor());
                    }
                });
                Iterator<InventoryItem> iterator = inventoryItems.iterator();
                InventoryVendorList vendorList = new InventoryVendorList();
                vendorList.setVendor(inventoryItems.get(0).getVendor());
                while (iterator.hasNext()) {
                    InventoryItem item = iterator.next();
                    InventoryVendorItem newItem = new InventoryVendorItem();
                    itemToVendorItem(item, newItem);
                    if (!item.getVendor().equals(vendorList.getVendor())) {
                        inventoryVendorLists.add(vendorList);
                        vendorList = new InventoryVendorList();
                        vendorList.setVendor(item.getVendor());
                    }
                    vendorList.getVendorItems().add(newItem);
                }
                inventoryVendorLists.add(vendorList);
            }
        }
        return inventoryVendorLists;
    }

    private void itemToVendorItem(InventoryItem item, InventoryVendorItem newItem) {
        newItem.setActivity(item.getActivity());
        newItem.setChangePrice(item.getChangePrice());
        newItem.setChangeSearches(item.getChangeSearches());
        newItem.setDaysLive(item.getDaysLive());
        newItem.setExposure(item.getExposure());
        newItem.setInquiries(item.getInquiries());
        newItem.setMileage(item.getMileage());
        newItem.setMileageMarket(item.getMileageMarket());
        newItem.setModel(item.getModel());
        newItem.setPrice(item.getPrice());
        newItem.setPriceMarket(item.getPriceMarket());
        newItem.setPrinted(item.getPrinted());
        newItem.setStock(item.getStock());
        newItem.setVin(item.getVin());
    }

    public List<InventoryItem> getAllInventoryItems() {
        synchronized (this) {
            if (allInventoryItems == null) {
                allInventoryItems = new ArrayList<InventoryItem>();

                for (int k = 0; k <= 5; k++) {
                    try {
                        switch (k) {
                            case 0:
                                allInventoryItems.addAll(createCar("Carlos", "Rivera", "Campos", "Aritmética", 1));
                                allInventoryItems.addAll(createCar("Enrique", "Malibu", "Hernandez", "Geometria", 1));
                                allInventoryItems.addAll(createCar("Juan", "Tahoe", "Tataje", "Algebra", 1));

                                break;

                            case 1:
                                allInventoryItems.addAll(createCar("Roberto", "Taurus", "Gálvez", "Física", 1));
                                allInventoryItems.addAll(createCar("Frank", "Guerrero", "Ramírez", "Razonamiento Matemático", 1));

                                break;

                            case 2:
                                allInventoryItems.addAll(createCar("Ricardo", "Navarrete", "Da Silva", "Química", 1));
                                allInventoryItems.addAll(createCar("Jonathan", "Frontier", "Guerrero", "Lenguaje", 1));

                                break;

                            case 3:
                                allInventoryItems.addAll(createCar("Oscar", "Marcelo", "Leon", "Anatomía", 1));
                                allInventoryItems.addAll(createCar("Miguel", "Camry", "Hoyle", "Biología", 1));
                                allInventoryItems.addAll(createCar("Ramón", "Avalon", "Campos", "Psicología", 1));

                                break;

                            case 4:
                                allInventoryItems.addAll(createCar("Alexis", "Sierra", "Larco", "Trigonometria", 1));
                                allInventoryItems.addAll(createCar("JeanCarlo", "Yukon", "Palomino", "Historia Universal", 1));

                                break;

                            case 5:
                                allInventoryItems.addAll(createCar("Antonio", "Delgado", "Campos", "Historia Peruana", 1));
                                allInventoryItems.addAll(createCar("Luis", "Cardoso", "Campos", "Ingles", 1));

                                break;

                            default:
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return allInventoryItems;
    }

    public List<InventoryItem> createCar(String vendor, String model, String apeMa, String asigantura, int count) {
        ArrayList<InventoryItem> iiList = null;

        try {
            int arrayCount = count;
            InventoryItem[] demoInventoryItemArrays = new InventoryItem[arrayCount];

            for (int j = 0; j < demoInventoryItemArrays.length; j++) {
                InventoryItem ii = new InventoryItem();

                ii.setVendor(vendor);
                ii.setModel(model);
                ii.setApe_ma(apeMa);
                ii.setAsigna(asigantura);
                ii.setStock(RandomHelper.randomstring(6, 7));
                ii.setVin(RandomHelper.randomstring(17, 17));
                ii.setMileage(new BigDecimal(RandomHelper.rand(5000, 80000)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setMileageMarket(new BigDecimal(RandomHelper.rand(25000, 45000)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setPrice(new Integer(RandomHelper.rand(15000, 55000)));
                ii.setPriceMarket(new BigDecimal(RandomHelper.rand(15000, 55000)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setDaysLive(RandomHelper.rand(1, 90));
                ii.setChangeSearches(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setChangePrice(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setExposure(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setActivity(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setPrinted(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                ii.setInquiries(new BigDecimal(RandomHelper.rand(0, 5)).setScale(DECIMALS, ROUNDING_MODE));
                demoInventoryItemArrays[j] = ii;
            }

            iiList = new ArrayList<InventoryItem>(Arrays.asList(demoInventoryItemArrays));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return iiList;
    }

    public int getCurrentCarIndex() {
        return currentCarIndex;
    }

    public void setCurrentCarIndex(int currentCarIndex) {
        this.currentCarIndex = currentCarIndex;
    }

    public InventoryItem getEditedCar() {
        return editedCar;
    }

    public void setEditedCar(InventoryItem editedCar) {
        this.editedCar = editedCar;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getClientRows() {
        return clientRows;
    }

    public void setClientRows(int clientRows) {
        this.clientRows = clientRows;
    }
}
