package main;

import main.beans.Client;
import main.beans.Event;
import main.entity.CacheFileEventLogger;
import main.entity.EventLogger;
import main.entity.EventType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */
public class App {

    private Client client;
    private EventLogger defaultlooger;
    private Map<EventType, EventLogger> loggers;

    public static void main(String[] arg){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1" + " " + app.client.getGreeting() +  "\n");
        System.out.println("note wrote");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2" + " " + app.client.getGreeting() +  "\n");
        System.out.println("note wrote");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3" + " " + app.client.getGreeting() +  "\n");
        System.out.println("note wrote");

        ctx.close();
    }

    public App(Client client, EventLogger defaultlooger, Map<EventType, EventLogger> loggers){
        super();
        this.client = client;
        this.defaultlooger = defaultlooger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if(logger == null){
            logger = defaultlooger;
        }

        defaultlooger.logEvent(event);
    }
}
