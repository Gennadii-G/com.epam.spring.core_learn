package main.loggers;

import main.beans.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gennadii_Borodin on 7/3/2017.
 */

@Component
public class CacheFileEventLogger extends FileEventLogger {

    @Value("${cache.size:5}")
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger() {
    }

    @Bean
    public static CacheFileEventLogger cacheEventLogger(){
        return new CacheFileEventLogger();
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    @PostConstruct
    public void initCache() {
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @PreDestroy
    public void destroy(){
        if(!cache.isEmpty()){
            System.out.println("PreDestroy Work | Notes save in file | cacheSize: " + cache.size());
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
//        cache.stream().forEach(super::logEvent);

        for(Event eve : cache){
            System.out.println("[ OK ]");
            super.logEvent(eve);
        }


    }

}
