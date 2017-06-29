package main;

import main.beans.Client;
import main.entity.ConsoleEventLogger;
import main.entity.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */
public class App {

    public App(Client client, EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private Client client;
    private EventLogger eventLogger;

    public static void main(String[] arg){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        app.logEvant("Some event for user 1");
        app.logEvant("Some event for user 2");
    }

    private void logEvant(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
