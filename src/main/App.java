package main;

import main.beans.Client;
import main.beans.Event;
import main.entity.CacheFileEventLogger;
import main.entity.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */
public class App {

    public App(Client client, CacheFileEventLogger CFELogger){
        super();
        this.client = client;
        this.CFELogger = CFELogger;
    }

    private Client client;
    private CacheFileEventLogger CFELogger;

    public static void main(String[] arg){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        Event event;
        for(int i = 0; i < 4; i++) {
            event = ctx.getBean(Event.class);
            app.logEvent(event, "Some event for " + i + "\n");
            System.out.println("note wrote");
        }

        ctx.close();
    }

    private void logEvent(Event event, String msg){
        event.setMsg(msg.replaceAll(client.getId(), client.getFullName()));
        CFELogger.logEvent(event);
    }
}
