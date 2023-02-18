import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void whenAuthenticationFailureCreated_thenAppenderReceivesCorrectEventAndMessage() {
        AuthenticationFailure authenticationFailure = new AuthenticationFailure("leon.dixon");
        SecurityLogHelper securityLogHelper = new SecurityLogHelper();
        securityLogHelper.sendLogEvent(authenticationFailure, logger);

        int actualLogSize = appender.getLogs().size();
        String actualMessage = appender.getLogs().get(0);

        assertEquals(1, actualLogSize);
        assertEquals("WD-SEC-AUTH-FAIL [ID : 12345, username : leon.dixon]. Authentication failed for user: leon.dixon", actualMessage);
    }
}
