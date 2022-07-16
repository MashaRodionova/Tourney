import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {


    // тестируем метод round (позитивный сценарий): оба игрока зарегистрированы, три исхода игры
    @Test
    public void test1() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        int expected = 2;
        int actual = game.round("vanya89", "mur");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void test2() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        int expected = 1;
        int actual = game.round("oooo", "mur");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void test3() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        int expected = 0;
        int actual = game.round("vanya89", "tryam");
        Assertions.assertEquals(expected, actual);
    }

    // Тестируем метод round на выброс исключений
    @Test
    public void test4() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "NeVasya");
        });

    }

    @Test
    public void test5() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("NeVasya", "terskol");
        });

    }

    @Test
    public void test6() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("111111", "Vasya");
        });

    }

    @Test
    public void test7() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "");
        });

    }

    // Тестируем метод register на выброс исключения
    @Test
    public void test8() {
        Game game = new Game();
        game.register("vanya89", 37);
        game.register("masha89", 7);
        game.register("terskol", 3);
        game.register("oooo", 372);
        game.register("tryam", 37);
        game.register("111111", 357);
        game.register("mur", 370);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.register("vanya89", 55);
        });


    }
}
