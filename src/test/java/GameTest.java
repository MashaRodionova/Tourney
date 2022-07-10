import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(352, "king", 1);
    Player player2 = new Player(352, "lion", 2);
    Player player3 = new Player(356, "ksl", 11);
    Player player4 = new Player(352, "los", 7);
    Player player5 = new Player(352, "los-ld", 0);
    Player player6 = new Player(352, "lion", 9);
    Player player7 = new Player(352, "smk", 1);

    // подать несуществующего игрока, подать двух несуществующих игроков, подать двух одинаковых игроков, испчтать три варианта исхода турнира


    // Два зарегестрированных игрока  с разными именами
    @Test
    public void test1(){
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        int expected = 2;
        int actual = game.round("lion", "ksl");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void test2(){
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        int expected = 1;
        int actual = game.round("lion", "king");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void test3(){
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        int expected = 0;
        int actual = game.round("smk", "king");
        Assertions.assertEquals(expected, actual);

    }

}
