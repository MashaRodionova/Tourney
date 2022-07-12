import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Player player1 = new Player(392, "king", 1);
    Player player2 = new Player(32, "lion", 2);
    Player player3 = new Player(156, "ksl", 11);
    Player player4 = new Player(3352, "los", 7);
    Player player5 = new Player(35222, "los-ld", 0);
    Player player6 = new Player(3, "lion", 9);
    Player player7 = new Player(752, "smk", 1);


    // тестируем метод round (позитивный сценарий): оба игрока зарегистрированы, три исхода игры
    @Test
    public void test1() {
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
    public void test2() {
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
    public void test3() {
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

    // Тестируем метод round на выброс исключений
    @Test
    public void test4() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "NeVasya");
        });

    }

    @Test
    public void test5() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("NeVasya", "los-ld");
        });

    }

    @Test
    public void test6() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("king", "Vasya");
        });

    }

    @Test
    public void test7() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "");
        });

    }

    // Тестируем метод register на выброс исключения
    @Test
    public void test8() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player7);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.register(player6);
        });


    }
}
