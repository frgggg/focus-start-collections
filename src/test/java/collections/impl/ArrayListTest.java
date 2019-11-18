package collections.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import collections.Iterator;
import static org.junit.Assert.*;
import static collections.impl.ArrayListTestUtils.*;

public class ArrayListTest {
    @Rule
    public ExpectedException testException = ExpectedException.none();

    @Test
    public void createThrowArraySize() {
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(ArrayList.THROW_ARRAY_SIZE);
        ArrayList<Integer> arrayList = new ArrayList<>(THROW_ARRAY_LIST_SIZE_CONSTRUCTOR_ARG);
        testException = ExpectedException.none();
    }

    @Test
    public void createThrowFillFactorLessThenZero() {
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(ArrayList.THROW_FILL_FACTOR);
        ArrayList<Integer> arrayList = new ArrayList<>(THROW_FILL_FACTOR_LESS_THEN_ZERO_CONSTRUCTOR_ARG);
        testException = ExpectedException.none();
    }

    @Test public void createThrowFillFactorMoreThenOne() {
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(ArrayList.THROW_FILL_FACTOR);
        ArrayList<Integer> arrayList = new ArrayList<>(THROW_FILL_FACTOR_MORE_THEN_ONE_CONSTRUCTOR_ARG);
        testException = ExpectedException.none();
    }

    @Test
    public void add() {

        assertEquals(ADD_ARRAY_LIST.getSize(), START_SIZE);
        assertEquals(ADD_ARRAY_LIST.getArraySize(), START_ARRAY_SIZE);
        ADD_ARRAY_LIST.add(ADD_INTEGER);
        assertEquals(ADD_ARRAY_LIST.getArraySize(), AFTER_ADD_ARRAY_LIST_SIZE);
    }

    @Test
    public void get() {
        assertEquals(GET_ARRAY_LIST.get(GET_INDEX), GET_INTEGER);
        assertNull(GET_ARRAY_LIST.get(GET_NULL_INDEX));
    }

    @Test
    public void remove() {
        assertEquals(REMOVE_ARRAY_LIST.getSize(), BEFORE_REMOVE_SIZE);
        assertEquals(REMOVE_ARRAY_LIST.remove(REMOVE_INDEX), REMOVE_INTEGER);
        assertEquals(REMOVE_ARRAY_LIST.getSize(), AFTER_REMOVE_SIZE);
        assertEquals(REMOVE_ARRAY_LIST.get(GET_AFTER_REMOVE_INDEX), GET_AFTER_REMOVE_INTEGER);
        assertNull(REMOVE_ARRAY_LIST.get(REMOVE_NOT_EXIST_INDEX_GET_NULL));
    }

    @Test
    public void iterator() {
        Iterator<Integer> testIterator = ITERATOR_ARRAY_LIST.iterator();
        assertEquals(testIterator.hasNext(), true);
        assertEquals(testIterator.next(), FIRST_INTEGER_FOR_ITERATOR);
        assertEquals(testIterator.hasNext(), true);
        assertEquals(testIterator.next(), LAST_INTEGER_FOR_ITERATOR);
        assertEquals(testIterator.hasNext(), false);
    }
}
