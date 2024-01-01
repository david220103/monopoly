package com.monopoly.monopoly;

public class ActionCard extends Field {

    public enum ActionCardName{ GET_KLIMABONUS, GO_TO_PRISON, GET_OUT_OF_JAIL, TAXES_REGULAR, TAXES_FRAUD_CHARGE,
        BACK_TO_START, TICKET_DODGER, FREE_PARKING, EXPERIENCE1, EXPERIENCE2, EXPERIENCE3, EXPERIENCE4,
        BAD_HAIRCUT, BIKE_STOLEN, LOST_MY_KEY, UBAHN_STAR_EXTRA_CASH; }

    private ActionCardName actionCardName;
    private String text;
    private int payIn;
    private int payOut;

    //CONSTRUCTOR
    public ActionCard(ActionCardName actionCardName, String text, int payIn, int payOut){
        this.actionCardName = actionCardName;
        this.text = text;
        this.payIn = payIn;
        this.payOut = payOut;
    }

    //GETTERS & SETTERS
    public ActionCardName getActionCardName() { return actionCardName; }
    public void setActionCardName(ActionCardName actionCardName) { this.actionCardName = actionCardName; }
    public void setText(String text) {this.text = text; }
    public String getText(){ return text; }
    public int getPayIn() { return payIn; }
    public void setPayIn(int payIn) { this.payIn = payIn; }
    public int getPayOut() { return payOut; }
    public void setPayOut(int payOut) { this.payOut = payOut; }
}
