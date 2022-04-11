package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();

    Tickets first = new Tickets(1, 1000, "MOW", "KZN", 95);
    Tickets second = new Tickets(2, 1000, "DME", "KZN", 95);
    Tickets third = new Tickets(3, 1000, "ZKD", "KZN", 95);

    @BeforeEach
    void preSave() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    void save() {

        Tickets[] expected = new Tickets[]{first, second, third};
        Tickets[] actual = repo.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Tickets expected = third;
        Tickets actual = repo.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void findByIdNoOne() {
        Tickets expected = null;
        Tickets actual = repo.findById(4);

        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        Tickets[] expected = new Tickets[]{first, second};
        Tickets[] actual = repo.removeById(3);

        assertArrayEquals(expected, actual);
    }
}