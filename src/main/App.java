package main;

import com.sun.org.apache.xpath.internal.SourceTree;
import main.beans.Client;
import main.beans.Event;
import main.loggers.EventLogger;
import main.beans.EventType;
import main.spring.AppConfig;
import main.spring.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;



@Service
public class App {

    @Autowired
    private Client client;

    @Resource(name = "defaultLogger")
    private EventLogger defaultLogger;

    @Resource(name = "loggerMap")
    private Map<EventType, EventLogger> loggers;

    public static void main(String[] arg){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class, LoggerConfig.class);
        ctx.scan("main");
        ctx.refresh();

        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event,
                "Some event for 1" + " " + app.client.getGreeting() +  "\n");
        System.out.println("note wrote");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event,
                "Some event for 2" + " " + app.client.getGreeting() +  "\n");
        System.out.println("note wrote");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event,
                "Some event for 3" + " " + app.client.getGreeting() +  "\n");
        System.out.println("note wrote");

        ctx.close();
    }

    public App(){}

    @Bean
    public static App app(){
        return new App();
    }

    private void logEvent(EventType eventType, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        System.out.println(message);
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if(logger == null){
            logger = defaultLogger;
        }

        defaultLogger.logEvent(event);
    }
}
