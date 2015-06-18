package Concurrency;

import java.util.Date;

/**
 * Created by tony.tan on 6/18/2015.
 *
 *
 */
public class Event {
    private Date date;
    private String event;

    public void setEvent(String event){
        this.event = event;
    }

    public String getEvent(){
       return this.event;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return this.date;
    }

}
