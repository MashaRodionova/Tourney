import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private ArrayList<Player> registeredPlayers = new ArrayList<>();


    public void register(Player player) {

        if (findByName(player.getName()) == null) {
            registeredPlayers.add(player);
        } else {
            throw new NotRegisteredException("Игрок с таким именем уже существует");
        }
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
        } else if (findByName(playerName1) == null & findByName(playerName2) == null) {
            throw new NotRegisteredException("Игроки " + playerName1 + " и " + playerName2 + " не зарегистрированы");

        } else if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }
        return result;
    }
}
