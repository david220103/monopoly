package com.monopoly.monopoly;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        // Java ist ein klumpatt :( !!!
        try {
            URL resourceUrl = GameManager.class.getResource("fields.json");
            System.out.println(resourceUrl);
            JSONArray jsonArray = new JSONArray(resourceUrl);

            for (int i = 0; i < jsonArray.length(); i++) {
                // Get the current object in the array
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Access fields within the object
                Field.Type type = Field.Type.valueOf(jsonObject.getString("type"));
                String name = jsonObject.getString("name");
                int price = jsonObject.getInt("price");
                JSONArray prices_json = jsonObject.getJSONArray("prices");
                int[] prices = new int[prices_json.length()];
                for(int j = 0; j < prices_json.length(); j++) prices[j] = prices_json.getInt(j);
                int rent = jsonObject.getInt("rent");

                listOfFields.add(new Field(type, name, price, prices, rent, this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
