import org.apache.logging.log4j.Level;

import java.util.HashMap;

public abstract class SecurityLogEventType {

    String username;
    String eventCode;
    String description;
    Level level;
    HashMap<String, Object> params;
    LogMessageEventTypeImpl logMessageEventType;

    public SecurityLogEventType(String username) {
        this.username = username;
        this.params = new HashMap<>();
        this.logMessageEventType = new LogMessageEventTypeImpl(this);
    }

    public String getEventCode() {
        return eventCode;
    }

    public String getDescription() {
        return description;
    }

    public Level getLevel() {
        return level;
    }

    public String getUsername() {
        return username;
    }

    String createLogMessage() {
        return logMessageEventType.createLogMessage();
    }
}
