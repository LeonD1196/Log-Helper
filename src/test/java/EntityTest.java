import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class EntityTest {
    private Logger logger;
    private CustomAppender appender;

    @Before
    public void setup() {
        logger = (Logger) LogManager.getLogger(CustomAppender.class);
        LoggerContext context = LoggerContext.getContext(false);
        Configuration config = context.getConfiguration();
        appender = config.getAppender("CustomAppender");
    }

    @Test
    public void whenEntityUsesLogHelper_thenLoggerWritesLog() throws Exception {
        Entity.useLogHelperFactory(logger, Level.INFO, "This is an info message!");
        List<Data> logs = appender.getLogs();
        assertEquals(1, logs.size());
        assertEquals("This is an info message!", logs.get(0).getMessage());
    }
}
