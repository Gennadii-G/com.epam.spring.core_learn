package main.loggers;

import main.beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by Gennadii_Borodin on 7/3/2017.
 */

public class FileEventLogger extends AbstractLogger {

    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMsg() + "\n", true);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public void init() throws IOException {
        System.out.println("PostConstruct FileEvent Work | " + "filename: " + filename);
        this.file = new File(filename);
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
