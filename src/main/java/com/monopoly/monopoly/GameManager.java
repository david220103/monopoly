package com.monopoly.monopoly;

import java.util.LinkedList;
import java.util.Random;

public class GameManager {

    private static LinkedList<Field> listOfFields = new LinkedList<>();
    private static LinkedList<Player> listOfPlayers = new LinkedList<>();

    public LinkedList<Field> createListOfFields(){
        //TODO: Bring in information about all Fields from a JSON file?
        listOfFields.add(new District(District.DistrictName.GO));
        listOfFields.add(new District(District.DistrictName.LIESING, 75, 25));
        listOfFields.add(new District(District.DistrictName.DONAUSTADT, 90, 30));
        // ...
        return listOfFields;
    }

    public LinkedList<Player> createListOfPlayers(){
        //TODO: Bring in info from Network/Socket Connection classes?
        return listOfPlayers;
    }

    //GETTERS & SETTERS
    public static LinkedList<Field> getListOfFields(){ return listOfFields; }
    public static LinkedList<Player> getListOfPlayers() {return listOfPlayers; }

    //TODO:
    //generatePlayerUniqueId() -> or data comes from Network/Socket Connection classes?
    //throwDice() -> see below
    //movePlayer() -> see below
    //implementFieldAction() depending on field type and attributes
        //District field
        //Station field
        //ActionCard field
    //surrender()

    public int[] throwDice(){ //TODO: Implement in GUI (e.g., animation two dice?)
        Random random = new Random();
        int [] twoDice = new int [2];
        twoDice[0] = random.nextInt(1, 7);
        twoDice[1] = random.nextInt(1, 7);
        return twoDice;
    }

    public void movePlayer(Player player, int [] diceResult){
        int numberOfMoves = diceResult[0] + diceResult[1];
        int indexCurrentField = listOfFields.indexOf(player.getCurrentField());
        player.setCurrentField(getListOfFields().get(indexCurrentField + numberOfMoves));
    }
}
