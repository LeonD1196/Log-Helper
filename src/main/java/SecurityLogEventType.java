import java.util.HashMap;
import java.util.Map;

public abstract class SecurityLogEventType {

    Map<String, String> params;

    public SecurityLogEventType() {
        params = new HashMap<>();
    }

    public abstract String getEventCode();

    public abstract String getDescription();

    public  abstract SecurityLevel getLevel();

    public String getParamValues() {
        StringBuilder values = new StringBuilder("[");
        for (String key : params.keySet())
            values.append(String.format("%s : %s, ", key, params.get(key)));
        values.replace(values.length()-2, values.length(), "]");
        return values.toString();
    }

    String createLogMessage() {
        return "WD-SEC-" +
                getEventCode() + " " + getParamValues() + ". " +
                getDescription();
    }
}
