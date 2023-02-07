package log_helper;

import org.apache.logging.log4j.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LogHelperFactory {

    static Map<Level, LogHelper> logHelperMapMap = new HashMap<>();
    static {
        logHelperMapMap.put(Level.TRACE, new TraceMessage());
        logHelperMapMap.put(Level.INFO, new InfoMessage());
        logHelperMapMap.put(Level.WARN, new WarnMessage());
        logHelperMapMap.put(Level.ERROR, new ErrorMessage());
        logHelperMapMap.put(Level.FATAL, new FatalMessage());
    }

    public static Optional<LogHelper> getLogHelper(Level level) {
        return Optional.ofNullable(logHelperMapMap.get(level));
    }
}
