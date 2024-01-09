package com.monopoly.monopoly;

import java.util.ArrayList;
import java.util.Arrays;

public class Field {
    private int price;
    private int rent;
    private int[] prices;
    private int properties;
    private Player owner;
    public enum Type{
        START, STREET, EVENT, STATION, PRISON, GO_TO_PRISON, FREE_PARKING;
    }
    private Type type;
    public String name;
    private GameManager gm;
    public Field(Type type, String name, int price, int[] prices, int rent, GameManager gm) {
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
    public Type getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public boolean action(Player p){
        if(type != Type.STATION && type != Type.STREET) return false;
        if(owner == null && p.withdraw(price)) {
            owner = p;
            return true;
        }
        if(owner == p && type == Type.STREET &&
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

        if(owner == null) return "[" + String.join(" | ", name, players, prices.toString()) + "]";
        return "[" + String.join(" | ", owner.getColor() + name + "\u001B[0m", Integer.toString(properties), players, prices.toString()) + "]";
    }
}
