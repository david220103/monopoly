package com.monopoly.monopoly;

import java.util.Random;

public class Player {
    private int AUTO_TRANSFER = 200;
    private int uniqueId; //Each player has a unique Id in case of same names
    private String name; //Name of the player
    private int totalMoney; //How much money the player has at any moment
    private Field currentField; //Where is the player standing
    private boolean outOfJail; //Does the player possess an out of jail card
    private int outPayments; //For statistics (how much has the player paid out: e.g., Miete, Stafe, Steuern, usw.)
    private int inPayments; //For statistics (how much has the player received: e.g., Gehalt, Klimabonus, erhaltende Miete, usw.)

    public Player(int uniqueId, String name){
        this.uniqueId = uniqueId;
        this.name = name;
        this.totalMoney = inPayments - outPayments;
        this.currentField = GameManager.getListOfFields().get(0);
        this.outOfJail = false;
        this.outPayments = 0;
        this.inPayments = AUTO_TRANSFER;
    }

    //GETTERS & SETTERS
    public int getUniqueId() { return uniqueId; }
    public void setUniqueId(int uniqueId) { this.uniqueId = uniqueId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getTotalMoney() { return totalMoney; }
    public void setTotalMoney(int totalMoney) { this.totalMoney = totalMoney; }
    public Field getCurrentField() { return currentField; }
    public void setCurrentField(Field currentField) { this.currentField = currentField; }
    public boolean isOutOfJail() { return outOfJail; }
    public void setOutOfJail(boolean outOfJail) { this.outOfJail = outOfJail; }
    public int getOutPayments() { return outPayments; }
    public void setOutPayments(int outPayments) { this.outPayments = outPayments; }
    public int getInPayments() { return inPayments; }
    public void setInPayments(int inPayments) { this.inPayments = inPayments; }

    //MONEY FUNCTIONS
    public void addMoney(Player player, int amount){
        player.setInPayments(player.getInPayments() + amount);
        player.setTotalMoney(player.getTotalMoney() + amount);
    }

    public void subtractMoney(Player player, int amount){
        player.setOutPayments(player.getOutPayments() + amount);
        player.setTotalMoney(player.getTotalMoney() - amount);
    }

    public String notifyBalanceBeforeBuying(Player player, int amountToPay){
        String notification;
        int resultingBalance = player.getTotalMoney() - amountToPay;
        if(resultingBalance <= -1){
            notification = "After this transaction, your balance will be negative: $ " + resultingBalance;
        } else if(resultingBalance == 0) {
            notification = "After this transaction, your balance will be zero: $ " + resultingBalance;
        } else {
            notification = "After this transaction, your balance will be positive: $ " + resultingBalance;
        }
        return notification;
    }

}
