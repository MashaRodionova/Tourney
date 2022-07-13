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
        Player first = findByName(playerName1);
        Player second = findByName(playerName2);

        if (first != null & second != null) {

            for (int i = 0; i < registeredPlayers.size(); i++) {

                if (first.getStrength() == second.getStrength()) {
                    result = 0;
                } else if (first.getStrength() > second.getStrength()) {
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
