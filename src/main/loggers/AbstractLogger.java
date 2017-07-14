package main.loggers;

import main.beans.Event;

/**
 * Created by Gennadii_Borodin on 7/14/2017.
 */
public class AbstractLogger implements EventLogger {

    private String name;

    public void logEvent(Event event) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
