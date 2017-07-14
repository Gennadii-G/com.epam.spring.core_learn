package main.loggers;

import main.beans.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Gennadii_Borodin on 7/4/2017.
 */

@Component
public class CombinedEventLogger implements EventLogger {

    @Resource(name = "combinedLoggers")
    private Collection<EventLogger> loggers;

    public CombinedEventLogger() {
    }

    @Bean
    public static CombinedEventLogger combinedEventLogger(){
        return new CombinedEventLogger();
    }

    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}
