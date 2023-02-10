import org.apache.logging.log4j.Level;

public class AuthorizationFailure extends SecurityLogEventType {

    public AuthorizationFailure(String username) {
        super(username);
        this.eventCode = "AUTH";
        this.description = String.format("Authorization failed for user: %s", username);
        this.level = Level.WARN;
    }
}
