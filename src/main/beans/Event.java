package main.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Gennadii_Borodin on 6/30/2017.
 */
public class Event {

    public Event(){
        Random random = new Random();
        id = random.nextInt(50);
    }

    public Event(Date date, DateFormat df){
        Random random = new Random();
        id = random.nextInt(50);
        this.date = date;
        this.df = df;
    }

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    @Override
    public String toString(){
        String s =  id + " \n" + df.format(date) + " \n" + msg;
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
