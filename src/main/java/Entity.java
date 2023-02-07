import log_helper.LogHelper;
import log_helper.LogHelperFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

public class Entity {

    public static void useLogHelperFactory(Logger logger, Level level, String message) {
        LogHelper helper = LogHelperFactory.getLogHelper(level).orElseThrow(() -> new IllegalArgumentException("Invalid Level."));
        helper.sendLog(logger, message);
    }

}
