package main.loggers;

import main.beans.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Gennadii_Borodin on 7/4/2017.
 */

public class CombinedEventLogger extends AbstractLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }

    @Override
    protected void setName(String name) {

    }

    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }
}
