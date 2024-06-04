package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    @Test
    public void compareToTest() {
        Ticket ticket = new Ticket("Москва", "Нижний Новгород", 100, 12, 20);
        Ticket ticket2 = new Ticket("Омск", "Владивосток", 300, 15, 21);
        Assertions.assertTrue(ticket.compareTo(ticket2) < 0);
    }

    @Test
    public void searchTest() {
        Ticket ticket = new Ticket("Москва", "Нижний Новгород", 100, 12, 20);
        Ticket ticket2 = new Ticket("Москва", "Нижний Новгород", 300, 15, 21);
        Ticket ticket3 = new Ticket("Москва", "Нижний Новгород", 500, 19, 23);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket);
        Ticket[] expected = new Ticket[]{
                ticket, ticket2, ticket3
        };
        Assertions.assertArrayEquals(expected, aviaSouls.search("Москва", "Нижний Новгород"));
    }

    @Test
    public void compareTest() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Ticket ticket = new Ticket("Москва", "Нижний Новгород", 100, 12, 20);
        Ticket ticket2 = new Ticket("Омск", "Владивосток", 300, 15, 21);
        int actual = ticketTimeComparator.compare(ticket, ticket2);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchAndSortByTest() {
        Ticket ticket = new Ticket("Москва", "Нижний Новгород", 100, 12, 20);
        Ticket ticket2 = new Ticket("Москва", "Нижний Новгород", 300, 15, 21);
        Ticket ticket3 = new Ticket("Москва", "Нижний Новгород", 500, 19, 23);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket);
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Нижний Новгород", ticketTimeComparator);
        Ticket[] expected = new Ticket[]{
                ticket3, ticket2, ticket
        };
        Assertions.assertArrayEquals(expected, actual);
    }
}
