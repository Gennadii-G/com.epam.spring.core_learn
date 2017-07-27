package main.loggers;

import main.beans.Event;

/**
 * Created by Gennadii_Borodin on 7/14/2017.
 */
public abstract class AbstractLogger implements EventLogger {

    protected String name;

    public void logEvent(Event event){}

    public String getName() {
        return name;
    }

    protected abstract void setName(String name);
}
