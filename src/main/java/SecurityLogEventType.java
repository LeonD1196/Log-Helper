import org.apache.logging.log4j.Level;

import java.util.HashMap;

public abstract class SecurityLogEventType {

    String username;
    String eventCode;
    String description;
    Level level;
    HashMap<String, Object> params;
    LogMessageEventTypeImpl logMessageEventType;

    public String getEventCode() {
        return eventCode;
    }

    public String getDescription() {
        return description;
    }

    public Level getLevel() {
        return level;
    }

    String createLogMessage() {
        return logMessageEventType.createLogMessage();
    }
}
