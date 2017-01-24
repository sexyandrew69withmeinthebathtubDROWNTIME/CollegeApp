package org.pltw.examples.collegeappdrawer;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mrisk on 1/12/2017.
 */
public class Profile {
    private String fName;
    private String lName;
    private Date date;

    public Profile(){
        this.fName = "Alan";
        this.lName = "Turing";
        date = new Date(84, 6, 22, 0, 0);
    }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if(isWithin8Years(date)){
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            throw new AgeException(AgeException.joinMessageAndYear("Who are you, Michael Kearny?", cal.get(Calendar.YEAR)));
        }

        this.date = date;
    }
    private boolean isWithin8Years(Date date){
        Calendar then = Calendar.getInstance();
        then.setTime(date);
        return Calendar.getInstance().get(Calendar.YEAR) - then.get(Calendar.YEAR) <= 8;
    }
}
