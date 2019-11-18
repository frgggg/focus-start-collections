package collections.impl;

import org.junit.Before;
import org.junit.Test;

import static collections.impl.HashMapTestUtils.*;
import static org.junit.Assert.*;

public class HashMapTest {

    @Before
    public void init()
    {
        TEST_HASH_MAP.insert(FIRST_KEY_NULL, FIRST_VALUE_BEFORE_INSERT);
        TEST_HASH_MAP.insert(FIRST_KEY_NULL, FIRST_VALUE_AFTER_INSERT);

        TEST_HASH_MAP.insert(SECOND_KEY, SECOND_VALUE_BEFORE_INSERT);
        TEST_HASH_MAP.insert(SECOND_KEY, SECOND_VALUE_AFTER_INSERT);

        TEST_HASH_MAP.insert(LAST_KEY, LAST_VALUE);
    }

    @Test
    public void insert() {
        assertEquals(TEST_HASH_MAP.getSize(), SIZE_AFTER_INSERTS);
        for(int i = 0; i < SIZE_AFTER_INSERTS; i++)
        {
            assertEquals(TEST_HASH_MAP.get(INSERT_KEYS[i]), INSERT_VALUES[i]);
        }
    }

    @Test
    public void get() {
        TEST_HASH_MAP.insert(SECOND_KEY, SECOND_VALUE_AFTER_INSERT);
        assertEquals(TEST_HASH_MAP.get(GET_KEY), GET_VALUE);
    }

    @Test
    public void delete() {
        TEST_HASH_MAP.delete(DELETE_KEY);
        assertEquals(TEST_HASH_MAP.getSize(), SIZE_AFTER_DELETE);
        for(int i = 0; i < SIZE_AFTER_DELETE; i++)
        {
            assertEquals(TEST_HASH_MAP.get(DELETE_KEYS[i]), DELETE_VALUES[i]);
        }
    }
}
