package org.pltw.examples.collegeappdrawer;

/**
 * Created by mrisk on 1/24/2017.
 */
public class AgeException extends RuntimeException{
    public AgeException(String message){
        super(message);
    }

    public static String joinMessageAndYear (String message, int year) {
        return message + " " + year;
    }
}