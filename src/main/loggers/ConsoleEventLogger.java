package main.loggers;

import main.beans.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */

@Component
public class ConsoleEventLogger extends AbstractLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
