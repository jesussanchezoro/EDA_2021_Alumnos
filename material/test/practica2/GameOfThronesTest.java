package material.test.practica2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.practica2.GameOfThrones;

import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesTest {
    private GameOfThrones got;
    private String path;

    @BeforeEach
    void setUp() {
        got = new GameOfThrones();
        got.loadFile(path);
    }


    @Test
    void testFindHeir() {
        String expected = "Eddad Stark";
        String output = got.findHeir("Stark");
        assertEquals(expected, output);
    }

    @Test
    void testChangeFamily() {
        got.changeFamily("Daenerys Targarien", "Eddard Stark");
        assertTrue(got.areFamily("Daenerys Targarien", "Arya Stark"));
    }

    @Test
    void testAreFamily() {
        assertTrue(got.areFamily("Arya Stark", "Rob Stark"));
        assertFalse(got.areFamily("Catelyn Tully", "Aerys Targarien"));
    }

}