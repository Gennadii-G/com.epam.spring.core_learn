package main;

import main.beans.Client;
import main.beans.Event;
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
        Event event = (Event) ctx.getBean("event");

        app.logEvant(event, "Some event for user 1");
    }

    private void logEvant(Event event, String msg){
        event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
        eventLogger.logEvent(event);
    }
}
