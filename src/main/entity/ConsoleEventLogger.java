package main.entity;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(String msg){
        System.out.println(msg);
    }
}
