package ru.netology.manager;

import ru.netology.domain.Tickets;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {

    private Repository repo = new Repository();

    public void add(Tickets ticket) {
        repo.save(ticket);
    }

    public Tickets[] findAll(String departure, String arrival) {
        Tickets[] result = new Tickets[0];
        for (Tickets ticket : repo.getAll()) {
            if (ticket.getDeparture().equals(departure)) {
                if (ticket.getArrival().equals(arrival)) {
                    int length = result.length + 1;
                    Tickets[] tmp = new Tickets[length];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    int lastIndex = tmp.length - 1;
                    tmp[lastIndex] = ticket;
                    result = tmp;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}
