package com.monopoly.monopoly;

public class Field {

    private int purchasePrice; //Cost of the district or station
    private int rentPrice; //Cost of rent for one house in the district or station (only one - no houses built on station)
    private Player owner; //Who owns the field
    private boolean bankHold; //Is the field on hold by the bank? (Hypothek von Player aufgenommen)

    //DEFAULT CONSTRUCTOR + BASE CONSTRUCTORS
    public Field(){}
    public Field(int purchasePrice, int rentPrice){
        this.purchasePrice = purchasePrice;
        this.rentPrice = rentPrice;
        this.owner = null;
        this.bankHold = false;
    }

    //GETTERS & SETTERS
    public int getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(int cost) { this.purchasePrice = cost; }
    public int getRentPrice() { return rentPrice; }
    public void setRentPrice(int benefit) { this.rentPrice = rentPrice; }
    public Player getOwner() { return owner; }
    public void setOwner(Player owner) { this.owner = owner; }
    public boolean isBankHold() { return bankHold; }
    public void setBankHold(boolean bankHold) { this.bankHold = bankHold; }


    //TRANSFER OWNERSHIP FUNCTIONS
    public void exchangeProperty(Player player1, Player player2, Field fieldPlayer1, Field fieldPlayer2){
        fieldPlayer1.setOwner(player2);
        fieldPlayer2.setOwner(player1);
    }

    //TODO: Complete
    public void buyField(){}
    public void buyHouse(){}
    public void buyHotel(){}
}
