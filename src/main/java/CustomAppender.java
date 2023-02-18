import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.util.LinkedList;

@Plugin(
        name = "CustomAppender",
        category = Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE)
public class CustomAppender extends AbstractAppender {
    private final LinkedList<String> queue = new LinkedList<>();

    protected CustomAppender(String name, Filter filter) {
        super(name, filter, null); // Null is for layout -> We expect frame to resolve default layout.
    }

    @PluginFactory
    public static CustomAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") final Filter filter) {
        return new CustomAppender(name, filter);
    }

    @Override
    public void append(LogEvent event) {
        queue.add(event.getMessage().getFormattedMessage());
    }

    public LinkedList<String> getLogs() {
        return queue;
    }
}