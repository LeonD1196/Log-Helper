import org.apache.logging.log4j.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class DataTest {

    @Test
    public void whenInstanceOfDataIsCreated_thenDetailsAreCorrect() throws Exception {
        Data data = new Data(Level.INFO, "This is an info message.");
        assertEquals("This is an info message.", data.getMessage());
        assertEquals(Level.INFO, data.getLevel());
    }
}
