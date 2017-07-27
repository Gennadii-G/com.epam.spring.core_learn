package main.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;


public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(){
        Random random = new Random();
        id = random.nextInt(50);
    }

    public static boolean isDay(int start, int end){
        LocalTime time = LocalTime.now();
        return time.getHour() > start && time.getHour() < end;
    }

    public Event(Date date, DateFormat df){
        id = new Random().nextInt(50);
        this.date = date;
        this.df = df;
    }

    public static Event event(){
        return new Event();
    }

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
