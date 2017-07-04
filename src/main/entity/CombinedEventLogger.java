package main.entity;

import main.beans.Event;

import java.util.Collection;
import java.util.List;

/**
 * Created by Gennadii_Borodin on 7/4/2017.
 */
public class CombinedEventLogger implements EventLogger {

    private final Collection<EventLogger> loggers;

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
}
