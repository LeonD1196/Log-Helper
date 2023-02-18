import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CustomAppenderTest {
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
    public void whenLoggerEmitsLoggingEvent_thenAppenderReceivesEvent() {
        logger.error("This is an error, watch out!");
        LinkedList<String> logs = appender.getLogs();
        assertEquals(1, logs.size());
        assertEquals("This is an error, watch out!", logs.get(0));
    }
}
