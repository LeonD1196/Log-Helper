import org.apache.logging.log4j.core.Logger;

public class SecurityLogHelper {

    void sendLogEvent(SecurityLogEventType securityLogEventType, Logger logger) {
        SecurityLevel levelForSecurityLogEventType = securityLogEventType.getLevel();
        if (levelForSecurityLogEventType == SecurityLevel.TRACE)
            logger.trace(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == SecurityLevel.INFO)
            logger.info(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == SecurityLevel.WARN)
            logger.warn(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == SecurityLevel.ERROR)
            logger.error(securityLogEventType.createLogMessage());
        else if (levelForSecurityLogEventType == SecurityLevel.FATAL)
            logger.fatal(securityLogEventType.createLogMessage());
        else return;
    }
}
