import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private ArrayList<Player> registeredPlayers = new ArrayList<>();


    public ArrayList register(Player player) {


        // тк в задании по условиям мы должны использовать список, а не мапы, исключаем
        // возможность дублирования игроков (принимаем за истину, что name - уникальный параметр)

        if (findByName(player.getName()) == player) {
            System.out.println("Игрок с таким именем уже зарегистрирован!");
        } else {
            registeredPlayers.add(player);
        }

        return registeredPlayers;
    }

    public Player findByName(String name) {

        for (int i = 0; i < registeredPlayers.size(); i++) {
            if (registeredPlayers.get(i).getName() == name) {
                return registeredPlayers.get(i);
            }
        }
        return null;
    }


    public int round(String playerName1, String playerName2) {

        int result = 7;

        if (findByName(playerName1) != null & findByName(playerName2) != null) {

            for (int i = 0; i < registeredPlayers.size(); i++) {

                if (findByName(playerName1).getStrength() == findByName(playerName2).getStrength()) {
                    result = 0;
                } else if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
                    result = 1;
                } else {
                    result = 2;
                }

            }
        } else if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        } else if (findByName(playerName1) == null & findByName(playerName2) == null) {
            throw new NotRegisteredException("Игроки " + playerName1 + " и " + playerName2 + " не зарегистрированы");

        }
        return result;
    }
}
