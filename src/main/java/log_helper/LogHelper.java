package log_helper;

import org.apache.logging.log4j.core.Logger;

public interface LogHelper {
    void sendLog(Logger logger, String message);
}
