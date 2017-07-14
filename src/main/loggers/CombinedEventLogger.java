package main.loggers;

import main.beans.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Gennadii_Borodin on 7/4/2017.
 */

public class CombinedEventLogger implements EventLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger() {
    }

    public static CombinedEventLogger combinedEventLogger(){
        return new CombinedEventLogger();
    }

    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}
