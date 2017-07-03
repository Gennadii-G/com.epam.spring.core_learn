package main.entity;

import main.beans.Event;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
