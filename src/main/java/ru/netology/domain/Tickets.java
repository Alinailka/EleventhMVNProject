package ru.netology.domain;

public class Tickets implements Comparable<Tickets> {

    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int time;

    @Override
    public int compareTo(Tickets o) {
        Tickets t = o;
        return this.price - t.price;
    }

    public Tickets(int id, int price, String departure, String arrival, int time) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
    }

    public Tickets() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
