import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

public class SecurityLogHelper {

    void sendLogEvent(SecurityLogEventType securityLogEventType, Logger logger) {
        Level levelForSecurityLogEventType = securityLogEventType.getLevel();
        if (levelForSecurityLogEventType == Level.TRACE)
            logger.trace(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == Level.INFO)
            logger.info(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == Level.WARN)
            logger.warn(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == Level.ERROR)
            logger.error(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == Level.FATAL)
            logger.fatal(securityLogEventType.createLogMessage());
        else return;
    }
}
