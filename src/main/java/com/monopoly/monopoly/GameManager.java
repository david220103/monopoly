package com.monopoly.monopoly;

import java.io.IOException;
import java.util.*;

public class GameManager {
    private LinkedList<Field> listOfFields = new LinkedList<>();
    private LinkedList<Player> listOfPlayers = new LinkedList<>();
    public LinkedList<Field> getListOfFields() { return listOfFields; }
    public LinkedList<Player> getListOfPlayers() { return listOfPlayers; }
    public void setListOfFields(LinkedList<Field> listOfFields) {
        this.listOfFields = listOfFields;
    }
    public void setListOfPlayers(LinkedList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
    public int[] throwDice(){ //TODO: Implement in GUI (e.g., animation two dice?)
        Random random = new Random();
        int [] twoDice = new int [2];
        twoDice[0] = random.nextInt(1, 7);
        twoDice[1] = random.nextInt(1, 7);
        return twoDice;
    }

    public void movePlayer(Player player, int [] diceResult){
        int numberOfMoves = diceResult[0] + diceResult[1];
        int indexCurrentField = listOfFields.indexOf(player.getPosition());
        int indexTargetField = indexCurrentField + numberOfMoves;
        if(indexTargetField >= listOfFields.size()){
            indexTargetField = listOfFields.size() - indexCurrentField;
            player.deposit(200);
        }
        player.setPosition(listOfFields.get(indexTargetField));
    }

    public GameManager(){
        listOfFields.add(new Field(Field.Type.START, "Start", 0, 0, this));
        listOfFields.add(new Field(Field.Type.STREET, "Innere Stadt", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Leopoldstadt", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Landstraße", 150, 100, this));
        listOfFields.add(new Field(Field.Type.EVENT, "EVENT", 0, 0, this));
        listOfFields.add(new Field(Field.Type.STATION, "Hauptbahnhof", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Wieden", 150, 100, this));
        listOfFields.add(new Field(Field.Type.EVENT, "Margareten", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Mariahilf", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Neubau", 150, 100, this));
        listOfFields.add(new Field(Field.Type.PRISON, "Gefängnis", 0, 0, this));

        listOfFields.add(new Field(Field.Type.STREET, "Josefstadt", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Alsergrund", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Favoriten", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Simmering", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STATION, "Erdberg BF", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Meidling", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Hietzing", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Penzing", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Rudolfsheim FH", 150, 100, this));
        listOfFields.add(new Field(Field.Type.FREE_PARKING, "gratis Parken", 0, 0, this));

        listOfFields.add(new Field(Field.Type.STREET, "Ottakring", 150, 100, this));
        listOfFields.add(new Field(Field.Type.EVENT, "EVENT", 0, 0, this));
        listOfFields.add(new Field(Field.Type.STREET, "Hernals", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Währing", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STATION, "Hütteldorf BF", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Döbling", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Brigittenau", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Floridsdorf", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Donaustadt", 150, 100, this));
        listOfFields.add(new Field(Field.Type.GO_TO_PRISON, "geh in hefen!", 0, 0, this));

        listOfFields.add(new Field(Field.Type.STREET, "Liesing", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Vösendorf", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Mödling", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Purkersdorf", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STATION, "Baden BF", 150, 100, this));
        listOfFields.add(new Field(Field.Type.EVENT, "EVENT", 0, 0, this));
        listOfFields.add(new Field(Field.Type.STREET, "St. Pölten", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Eisenstadt", 150, 100, this));
        listOfFields.add(new Field(Field.Type.STREET, "Prag", 150, 100, this));
    }
}
