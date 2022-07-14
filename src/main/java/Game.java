import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private HashMap<String, Integer> registeredPlayers = new HashMap<>();
    

    public void register(String name, Integer strength) {


        if (findByName(name) == name) {
            throw new NotRegisteredException("Игрок с таким именем уже существует");

        } else {
            registeredPlayers.put(name, strength);
        }


    }


    public String findByName(String playerName) {

        for (String key : registeredPlayers.keySet()) {
            if (key == playerName) {
                return key;
            }

        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        int result = 7;
        String first = findByName(playerName1);
        String second = findByName(playerName2);

        if (first != null & second != null) {

            for (String key : registeredPlayers.keySet()) {

                if (registeredPlayers.get(first) == registeredPlayers.get(second)) {
                    result = 0;
                } else if (registeredPlayers.get(first) > registeredPlayers.get(second)) {
                    result = 1;
                } else {
                    result = 2;
                }

            }
        } else if (first == null & second == null) {
            throw new NotRegisteredException("Игроки " + first + " и " + second + " не зарегистрированы");

        } else if (first == null) {
            throw new NotRegisteredException("Игрок " + first + " не зарегистрирован");
        } else if (second == null) {
            throw new NotRegisteredException("Игрок " + second + " не зарегистрирован");
        }
        return result;
    }
}
