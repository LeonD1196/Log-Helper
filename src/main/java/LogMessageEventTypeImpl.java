public class LogMessageEventTypeImpl implements LogMessageEventType{

    private final SecurityLogEventType securityLogEventType;
    LogMessageEventTypeImpl(SecurityLogEventType securityLogEventType) {
        this.securityLogEventType = securityLogEventType;
    }

    @Override
    public String createLogMessage() {
        return securityLogEventType.getEventCode() + "-" +
                securityLogEventType.getLevel() + "-" +
                securityLogEventType.getDescription();
    }
}
