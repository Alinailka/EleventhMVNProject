package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager manager = new Manager();

    Tickets first = new Tickets(1, 1000, "MOW", "KZN", 95);
    Tickets second = new Tickets(2, 2000, "DME", "KZN", 95);
    Tickets third = new Tickets(3, 100, "ZKD", "KZN", 95);
    Tickets fourth = new Tickets(4, 1000, "DME", "KZO", 95);
    Tickets fifth = new Tickets(5, 300, "MOW", "KZN", 95);
    Tickets sixth = new Tickets(6, 100, "MOW", "KZN", 95);

    @BeforeEach
    public void preAdd() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void findAllOne() {
        Tickets[] expected = new Tickets[]{second};
        Tickets[] actual = manager.findAll("DME", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllNoOne() {
        manager.add(fourth);
        Tickets[] expected = new Tickets[0];
        Tickets[] actual = manager.findAll("ZKD", "KZO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllMoreOne() {
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        Tickets[] expected = new Tickets[]{sixth, fifth, first};
        Tickets[] actual = manager.findAll("MOW", "KZN");

        assertArrayEquals(expected, actual);
    }
}
