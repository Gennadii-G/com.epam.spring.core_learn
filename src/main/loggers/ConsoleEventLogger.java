package main.loggers;

import main.beans.Event;
import main.entity.EventLogger;
import org.springframework.stereotype.Component;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */

@Component
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
