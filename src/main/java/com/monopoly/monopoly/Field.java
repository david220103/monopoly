package com.monopoly.monopoly;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;

public class Field {
    @JsonProperty("price")
    private int price;
    @JsonProperty("rent")
    private int rent;
    @JsonProperty("prices")
    private int[] prices;
    @JsonProperty("properties")
    private int properties;
    @JsonProperty("owner")
    private Player owner;
    public enum Type{
        START, STREET, EVENT, STATION, PRISON, GO_TO_PRISON, FREE_PARKING;
    }
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    public String name;
    private GameManager gm;

    public Field(){

    }

    public Field(String type, String name, int price, int[] prices, int rent, GameManager gm) {
        this.price = price;
        this.prices = prices;
        this.rent = rent;
        this.type = type;
        this.name = name;
        this.gm = gm;
        this.owner = null;
        this.properties = 0;
    }
    public int getPrice() {
        return price;
    }
    public int getRent() {
        return rent * (properties + 1);
    }
    public int getProperties() {
        return properties;
    }
    public Player getOwner() {
        return owner;
    }
    public String getType() {
        return type;
    }
    public void setGm(GameManager gm){
        this.gm = gm;
    }
    public String getName() {
        return name;
    }

    public boolean action(Player p){
        if(!type.equals("STATION")  && !type.equals("STREET")) return false;
        if(owner == null && p.withdraw(price)) {
            owner = p;
            return true;
        }
        if(owner == p && type.equals("STREET")&&
            properties < 6 && p.withdraw(price)) {
            properties += 1;
            return true;
        }
        return false;
    }

    private ArrayList<Player> getPlayersOnField(){
        ArrayList<Player> list = new ArrayList<>();
        for(Player p:gm.getListOfPlayers()){
            if(p.getPosition() == this) list.add(p);
        }
        return list;
    }
    @Override
    public String toString() {
        StringBuilder players = new StringBuilder();
        for(Player p:getPlayersOnField()) players.append(p.getColor()).append(p.getName()).append(" \u001B[0m");

        if(owner == null) return "[" + String.join(" | ", name, players, Arrays.toString(prices)) + "]";
        return "[" + String.join(" | ", owner.getColor() + name + "\u001B[0m", Integer.toString(properties), players, prices.toString()) + "]";
    }
}
