public class LogMessageEventTypeImpl implements LogMessageEventType{

    private final SecurityLogEventType securityLogEventType;
    LogMessageEventTypeImpl(SecurityLogEventType securityLogEventType) {
        this.securityLogEventType = securityLogEventType;
    }

    @Override
    public String createLogMessage() {
        return "WD-SEC-" +
                securityLogEventType.getEventCode() + "-" +
                securityLogEventType.getLevel() + " (" +
                securityLogEventType.getUsername() + "). " +
                securityLogEventType.getDescription();
    }
}
