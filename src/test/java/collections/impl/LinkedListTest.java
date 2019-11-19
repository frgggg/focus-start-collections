package collections.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import collections.Iterator;

import static collections.impl.LinkedListTestUtils.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    @Rule
    public ExpectedException testException = ExpectedException.none();

    @Test
    public void addThrowNullValue()
    {
        LinkedList<Integer> addTestList = new LinkedList<>();
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(LinkedList.THROW_NULL_VALUE);
        addTestList.add(null);
        testException = ExpectedException.none();
    }

    @Test
    public void addByIndexThrowNullValue()
    {
        LinkedList<Integer> addTestList = new LinkedList<>();
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(LinkedList.THROW_NULL_VALUE);
        addTestList.add(null, 0);
        testException = ExpectedException.none();
    }

    @Test
    public void addAndGet() {
        LinkedList<Integer> addTestList = new LinkedList<>();
        for(int i = 0; i < ADD_TEST.length; i++)
            addTestList.add(ADD_TEST[i]);

        for(int i = 0; i < addTestList.getSize(); i++)
            assertEquals(addTestList.get(i), ADD_TEST[i]);

        for(int i = 0; i < ADD_BY_INDEX_TESTS_INDEXES.length; i++)
        {
            addTestList.add(ADD_BY_INDEX_TESTS_VALUES[i], ADD_BY_INDEX_TESTS_INDEXES[i]);
            for(int j = 0; j < ADD_BY_INDEX_TESTS[i].length; j++)
                assertEquals(addTestList.get(j), ADD_BY_INDEX_TESTS[i][j]);
        }
    }

    @Test
    public void remove() {
        LinkedList<Integer> removeTestList = new LinkedList<>();
        for(int i = 0; i < REMOVE_TEST.length; i++)
            removeTestList.add(REMOVE_TEST[i]);

        for(int i = 0; i < REMOVE_TESTS_INDEXES.length; i++)
        {
            removeTestList.remove(REMOVE_TESTS_INDEXES[i]);
            for(int j = 0; j < REMOVE_TESTS[i].length; j++)
                assertEquals(removeTestList.get(j), REMOVE_TESTS[i][j]);
        }

    }

    @Test
    public void iterator() {
        LinkedList<Integer> iteratorTestList = new LinkedList<>();
        for(int i = 0; i < ITERATOR_TEST.length; i++)
            iteratorTestList.add(ITERATOR_TEST[i]);

        Iterator<Integer> testIterator = iteratorTestList.iterator();

        for(int i = 0; i < ITERATOR_TESTS_NEXT.length; i++)
        {
            assertEquals(testIterator.hasNext(), ITERATOR_TESTS_HAS_NEXT[i]);
            assertEquals(testIterator.next(), ITERATOR_TESTS_NEXT[i]);
        }
    }
}
