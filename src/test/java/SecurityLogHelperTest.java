import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SecurityLogHelperTest {
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
    public void whenAuthorizationFailureCreated_thenAppenderReceivesCorrectEventAndMessage() throws Exception {
        AuthorizationFailure authorizationFailure = new AuthorizationFailure("leon.dixon");
        SecurityLogHelper securityLogHelper = new SecurityLogHelper();
        securityLogHelper.sendLogEvent(authorizationFailure, logger);

        int actualLogSize = appender.getLogs().size();
        String actualMessage = appender.getLogs().get(0).getMessage();

        assertEquals(1, actualLogSize);
        assertEquals("AUTH-WARN-Authorization failed for user: leon.dixon", actualMessage);
    }

    @Test
    public void whenAuthenticationFailureCreated_thenAppenderReceivesCorrectEventAndMessage() throws Exception {
        AuthenticationFailure authenticationFailure = new AuthenticationFailure("leon.dixon");
        SecurityLogHelper securityLogHelper = new SecurityLogHelper();
        securityLogHelper.sendLogEvent(authenticationFailure, logger);

        int actualLogSize = appender.getLogs().size();
        String actualMessage = appender.getLogs().get(0).getMessage();

        assertEquals(1, actualLogSize);
        assertEquals("AUTH-WARN-Authentication failed for user: leon.dixon", actualMessage);
    }
}