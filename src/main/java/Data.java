import org.apache.logging.log4j.Level;

public class Data {

    private final Level level;
    private final String message;

    public Data(Level level, String message) {
        this.level = level;
        this.message = message;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
