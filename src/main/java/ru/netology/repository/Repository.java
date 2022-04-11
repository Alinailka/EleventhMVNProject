package ru.netology.repository;

import ru.netology.domain.Tickets;

public class Repository {
    public Tickets[] tickets = new Tickets[0];

    public void save(Tickets ticket) {
        int length = tickets.length + 1;
        Tickets[] tmp = new Tickets[length];

        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Tickets[] getAll() {
        return tickets;
    }

    public Tickets findById(int id) {
        for (Tickets ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Tickets[] removeById(int id) {
        int lenght = tickets.length - 1;
        Tickets[] tmp = new Tickets[lenght];
        int index = 0;
        for (Tickets ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
        return tickets;
    }
}

