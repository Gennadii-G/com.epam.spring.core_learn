package main.beans;

import org.springframework.stereotype.Component;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */

@Component
public class Client {

    private String id;
    private String fullName;
    private String greeting;

    public Client(String id, String fullName) {
        super();
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
