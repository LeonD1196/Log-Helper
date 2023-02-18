public class AuthenticationFailure extends SecurityLogEventType {

    String username;
    String eventCode;
    String description;
    SecurityLevel level;

    public AuthenticationFailure(String username) {
        super();
        this.username = username;
        this.eventCode = "AUTH-FAIL";
        this.description = String.format("Authentication failed for user: %s", username);
        this.level = SecurityLevel.WARN;
        this.params.put("username", username);
        this.params.put("ID", "12345");
    }


    @Override
    public String getEventCode() {
        return eventCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public SecurityLevel getLevel() {
        return level;
    }
}
