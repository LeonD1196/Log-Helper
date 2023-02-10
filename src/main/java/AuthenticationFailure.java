import org.apache.logging.log4j.Level;

public class AuthenticationFailure extends SecurityLogEventType {

    public AuthenticationFailure(String username) {
        super(username);
        this.eventCode = "AUTH";
        this.description = String.format("Authentication failed for user: %s", username);
        this.level = Level.WARN;
    }
}
