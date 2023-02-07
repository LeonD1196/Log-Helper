package log_helper;

import org.apache.logging.log4j.core.Logger;

public class InfoMessage implements LogHelper {
    @Override
    public void sendLog(Logger logger, String message) {
        logger.info(message);
    }
}
