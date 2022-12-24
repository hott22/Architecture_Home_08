package ru.geekbrains.lesson8.MVP.Models;

import java.util.Date;
import java.util.Random;

public class Reservation {

    private static int counter;
    private final int id;
    private Date date;
    private String name;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }


    {
        id = ++counter;

    }

    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }


}
