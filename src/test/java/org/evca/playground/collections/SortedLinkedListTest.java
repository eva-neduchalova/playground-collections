package org.evca.playground.collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class SortedLinkedListTest {

    @Test
    void testAddNullThrowsException() {
        SortedLinkedList intList = new SortedLinkedList();
        try {
            intList.add(null);
            fail("Should have thrown IllegalArgumentException exception");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    @Test
    void testAddNegativeNumberSortsProperly() {
        SortedLinkedList intList = new SortedLinkedList();
        intList.add(-100);
        intList.add(-200);
        intList.add(-300);
        intList.add(-250);
        intList.add(0);
        intList.add(1);
        intList.add(-1);
        System.out.println(intList);
        assertThat(intList).containsExactly(-300, -250, -200, -100, -1, 0, 1);
    }

    @Test
    void testAddingDuplicatesSortsProperly() {
        SortedLinkedList intList = new SortedLinkedList();
        intList.add(100);
        intList.add(0);
        intList.add(-10);
        intList.add(-10);
        intList.add(-10);
        intList.add(0);
        intList.add(100);
        intList.add(1000);
        System.out.println(intList);
        assertThat(intList).containsExactly(-10, -10, -10, 0, 0, 100, 100, 1000);
    }

}