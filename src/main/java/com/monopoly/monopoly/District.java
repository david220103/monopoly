package com.monopoly.monopoly;

public class District extends Field {

    public enum DistrictName{
        GO, INNERE_STADT, LEOPOLDSTADT, LANDSTRASSE, WIEDEN, MARGARETEN,
        MARIAHILF, NEUBAU, JOSEFSTADT, ALSERGRUND, FAVORITEN, SIMMERING,
        MEIDLING, HIETZING, PENZING, RUDOLFSHEIM, OTTAKRING, HERNALS,
        WAEHRING, DOEBLING, BRIGITTENAU, FLORIDSFORF, DONAUSTADT, LIESING;
    }
    private DistrictName districtName;
    private int numberOfHouses;
    private boolean hasHotel;

    //CONSTRUCTOR
    public District(DistrictName districtName){
        if(districtName == DistrictName.GO){
            this.districtName = districtName;
        }
    }
    public District(DistrictName districtName, int purchasePrice, int rentPrice){
        super(purchasePrice, rentPrice);
        this.districtName = districtName;
        this.numberOfHouses = 0;
        this.hasHotel = false;
    }

    //GETTERS & SETTERS
    public DistrictName getDistrictName() { return districtName; }
    public void setDistrictName(DistrictName districtName) { this.districtName = districtName; }
    public int getNumberOfHouses() { return numberOfHouses; }
    public void setNumberOfHouses(int numberOfHouses) { this.numberOfHouses = numberOfHouses; }
    public boolean getHasHotel() { return hasHotel; }
    public void setHasHotel(boolean hasHotel) { this.hasHotel = hasHotel; }
}
