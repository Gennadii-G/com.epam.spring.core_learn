package main.beans;

/**
 * Created by Gennadii_Borodin on 6/28/2017.
 */
public class Client {

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    private String id;
    private String fullName;

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
}
