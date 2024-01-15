package com.monopoly.monopoly;

import java.io.File;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


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

    private void loadDataFromJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            File fieldsJson = new File("src/main/resources/com/monopoly/monopoly/fields.json");
            LinkedList<Field> fields = objectMapper.readValue(fieldsJson, new TypeReference<>() {});
            for (Field field:fields) {
                field.setGm(this);
            }
             listOfFields = fields;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
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
        // Java ist ein klumpatt :( !!!
        //Ja Stimmt :D
        loadDataFromJson();
    }
}
