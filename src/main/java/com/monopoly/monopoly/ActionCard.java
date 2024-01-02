package com.monopoly.monopoly;

public class ActionCard {

    public enum ActionCardName{ GET_KLIMABONUS, GO_TO_PRISON, GET_OUT_OF_JAIL, TAXES_REGULAR, TAXES_FRAUD_CHARGE,
        BACK_TO_START, TICKET_DODGER, FREE_PARKING, EXPERIENCE1, EXPERIENCE2, EXPERIENCE3, EXPERIENCE4,
        BAD_HAIRCUT, BIKE_STOLEN, LOST_MY_KEY, UBAHN_STAR_EXTRA_CASH; }

    private ActionCardName actionCardName;
    private String text;

    //CONSTRUCTOR
    public ActionCard(ActionCardName actionCardName, String text){
        this.actionCardName = actionCardName;
        this.text = text;
    }

    //GETTERS & SETTERS
    public String getText(){ return text; }

    //TODO je nach karte aktion direkt durchführen und str zurückgeben
}
