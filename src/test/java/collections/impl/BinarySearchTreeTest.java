package collections.impl;

import org.junit.Before;
import org.junit.Test;
import collections.Iterator;

import static collections.impl.BinarySearchTreeTestUtils.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    @Before
    public void init()
    {
        BINARY_SEARCH_TREE.add(FIRST_NODE_VALUE);

        BINARY_SEARCH_TREE.add(SECOND_LEFT_NODE_VALUE);
        BINARY_SEARCH_TREE.add(SECOND_RIGHT_NODE_VALUE);

        BINARY_SEARCH_TREE.add(LAST_LEFT_NODE_VALUE);
        BINARY_SEARCH_TREE.add(LAST_RIGHT_NODE_VALUE);
    }

    @Test
    public void addAndIterator() {
        Iterator<BinarySearchTree.Node> testIterator = BINARY_SEARCH_TREE.iterator();

        for(int i = 0; i < NOT_REVERSE_RESULT_HAS_NEXT.length; i++)
        {
            boolean hasNextResult = testIterator.hasNext();
            assertEquals(hasNextResult, NOT_REVERSE_RESULT_HAS_NEXT[i]);
            if(i != HAS_NEXT_FALSE_NUMBER)
                assertEquals(testIterator.next().value, NOT_REVERSE_RESULT_VALUES[i]);
            else
                assertNull(testIterator.next());
        }
    }

    @Test
    public void reverse() {
        BINARY_SEARCH_TREE.reverse();
        Iterator<BinarySearchTree.Node> testIterator = BINARY_SEARCH_TREE.iterator();

        for(int i = 0; i < REVERSE_RESULT_VALUES.length; i++)
        {
            assertEquals(testIterator.next().value, REVERSE_RESULT_VALUES[i]);
        }
    }
}
