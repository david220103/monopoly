package com.monopoly.monopoly;

import java.util.Random;

public class Player {
    private int id; //Each player has a unique Id in case of same names
    private String name; //Name of the player
    private int balance; //How much money the player has at any moment
    private int total_payments; //For statistics (how much has the player paid out: e.g., Miete, Stafe, Steuern, usw.)
    private int total_income; //For statistics (how much has the player received: e.g., Gehalt, Klimabonus, erhaltende Miete, usw.)
    private Field position; //Where is the player standing
    private boolean has_out_of_jail_card; //Does the player possess an out of jail card
    private GameManager gameManager;
    private String color;

    public Player(int id, String name, String color, GameManager gameManager) {
        this.id = id;
        this.name = name;
        this.balance = 200;
        this.total_payments = 0;
        this.total_income = 200;
        this.gameManager = gameManager;
        this.position = gameManager.getListOfFields().get(0);
        this.has_out_of_jail_card = false;
        this.color = color;
    }

    public String getName(){ return name; }
    public int getBalance(){ return balance; }
    public boolean deposit(int amnt){
        if(amnt < 1) return false;
        balance += amnt;
        total_income += amnt;
        return true;
    }
    public boolean withdraw(int amnt){
        // if(amnt < 1 || balance - amnt < 1) return false;
        balance -= amnt;
        total_payments += amnt;
        return true;
    }
    public Field getPosition() {
        return position;
    }
    public void setPosition(Field position) {
        this.position = position;
    }
    public String getColor() {
        return color;
    }


    public String notifyBalanceBeforeBuying(int amountToPay){
        String notification;
        int resultingBalance = balance - amountToPay;
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
