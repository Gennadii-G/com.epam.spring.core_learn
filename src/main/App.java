package main;

import com.sun.org.apache.xpath.internal.SourceTree;
import main.beans.Client;
import main.beans.Event;
import main.loggers.EventLogger;
import main.beans.EventType;
import main.spring.AppConfig;
import main.spring.LoggerConfig;
import main.util.TestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;



public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;
    private String startupMessage;

    public static void main(String[] arg){
        TestLog.p("app start ->\n");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        System.out.println(app.startupMessage);

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event,
                "Some event for 1 " + app.client.getGreeting());

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event,
                "Some event for 2 " + app.client.getGreeting());

        event = ctx.getBean(Event.class);
        app.logEvent(null, event,
                "Some event for 3 " + app.client.getGreeting());

        TestLog.p("\napp finished work");
        ctx.close();
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if(logger == null){
            logger = defaultLogger;
        }

        defaultLogger.logEvent(event);
    }

    public void setStartupMessage(String startupMessage) {
        this.startupMessage = startupMessage;
    }

    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }
//    https://github.com/yuriytkach
}
