package log_helper;

import org.apache.logging.log4j.core.Logger;

public class FatalMessage implements LogHelper {
    @Override
    public void sendLog(Logger logger, String message) {
        logger.fatal(message);
    }
}
