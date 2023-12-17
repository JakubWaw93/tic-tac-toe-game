package com.kodilla.tictactoe;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GameRanking {

    private final File savedHashMaps = new File("ranking.list");
    private final Map<String, Integer> localMapForRanking = new HashMap<>();

    public void saveMap() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedHashMaps));
            oos.writeObject(localMapForRanking);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void loadMap() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMaps));
            Object readMap = ois.readObject();
            if (readMap instanceof HashMap) {
                localMapForRanking.putAll((HashMap) readMap);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void saveStats(){
        if (localMapForRanking.containsKey(GameStats.getPlayer1Name())) {
            localMapForRanking.put(GameStats.getPlayer1Name(), GameStats.getPlayer1Points() + localMapForRanking.get(GameStats.getPlayer1Name()));
        } else {
            localMapForRanking.put(GameStats.getPlayer1Name(), GameStats.getPlayer1Points());
        }
        if (localMapForRanking.containsKey(GameStats.getPlayer2Name())) {
            localMapForRanking.put(GameStats.getPlayer2Name(), GameStats.getPlayer2Points());
        } else {
            localMapForRanking.put(GameStats.getPlayer2Name(), GameStats.getPlayer2Points());
        }
    }

    public Map<String, Integer> getLocalMapForRanking() {
        return localMapForRanking;
    }

}
