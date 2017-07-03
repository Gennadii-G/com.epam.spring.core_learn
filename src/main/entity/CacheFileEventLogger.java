package main.entity;

import main.beans.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gennadii_Borodin on 7/3/2017.
 */
public class CacheFileEventLogger extends FileEventLogger {

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    private int cacheSize;
    private List<Event> cache;

    @Override
    public void logEvent(Event event){
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
        for(Event e : cache){

        }
    }

}
