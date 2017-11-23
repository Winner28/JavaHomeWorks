package test.java.Module_4_IO.Task_wFour.Hollywood;

import Module_4_IO.Task_wFour.Movie.Movie;
import Module_4_IO.Task_wFour.Serialize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HollywoodTest {

    @Test
    void Test_One() {
        String filename = "";
        PictureCreator hollywood = new Hollywood();

        hollywood.createMovie("50","50",100);

        Serialize serialize = new Serialize().setHollywood(hollywood);

        serialize.serialize(filename);

        serialize.deserialize(filename);

        PictureCreator hollywood1 = serialize.getHollywood();

        assertEquals(hollywood, hollywood1);

        assertNotEquals(hollywood, new Hollywood());


    }
}