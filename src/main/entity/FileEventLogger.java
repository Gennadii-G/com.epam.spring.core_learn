package main.entity;

import main.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Gennadii_Borodin on 7/3/2017.
 */
public class FileEventLogger implements EventLogger{

    public FileEventLogger(String filename) {
        this.file = new File(filename);
    }

    private String filename;
    private File file;

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMsg(), true);
            System.out.println("something in fileeventlogger");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        if(file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("I can't write file " + filename);
        }else if(!file.exists()){
            try{
                file.createNewFile();
            }catch(Exception e){
                throw new IllegalArgumentException("I can't create file " + filename);
            }
        }
    }

}
