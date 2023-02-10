import org.apache.logging.log4j.Level;

import java.util.HashMap;

public class AuthenticationFailure extends SecurityLogEventType {

    public AuthenticationFailure(
            String username
    ) {
        this.username = username;
        this.eventCode = "AUTH";
        this.description = String.format("Authentication failed for user: %s", username);
        this.level = Level.WARN;
        this.params = new HashMap<>();
        this.logMessageEventType = new LogMessageEventTypeImpl(this);
    }
}
