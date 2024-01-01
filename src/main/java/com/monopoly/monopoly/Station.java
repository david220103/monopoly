package com.monopoly.monopoly;

public class Station extends Field {

    public enum StationName{
        ERDBERG, HAUPTBAHNHOF, PRATERSTERN, WESTBAHNHOF;
    }

    private StationName stationName;

    //CONSTRUCTOR
    public Station(StationName stationName, int purchasePrice, int rentPrice){
        super(purchasePrice, rentPrice);
        this.stationName = stationName;
    }

    //GETTERS & SETTERS
    public StationName getStationName() { return stationName; }
    public void setStationName(StationName stationName) { this.stationName = stationName; }
}
