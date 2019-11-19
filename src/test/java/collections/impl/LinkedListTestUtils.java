package collections.impl;

public class LinkedListTestUtils {
    public static final Integer ADD_SECOND_NODE_DATA = new Integer(2);
    public static final Integer ADD_LAST_NODE_DATA = new Integer(3);
    public static final Integer[] ADD_TEST = new Integer[]{ADD_SECOND_NODE_DATA, ADD_LAST_NODE_DATA};

    public static final int ADD_ZERO_NODE_INDEX = 0;
    public static final Integer ADD_BY_INDEX_ZERO_NODE_DATA = new Integer(0);
    public static final Integer[] ADD_BY_INDEX_ZERO_TEST = new Integer[]{ADD_BY_INDEX_ZERO_NODE_DATA, ADD_SECOND_NODE_DATA, ADD_LAST_NODE_DATA};

    public static final int ADD_FIRST_NODE_INDEX = 1;
    public static final Integer ADD_BY_INDEX_FIRST_NODE_DATA = new Integer(1);
    public static final Integer[] ADD_BY_INDEX_FIRST_TEST = new Integer[]{ADD_BY_INDEX_ZERO_NODE_DATA, ADD_BY_INDEX_FIRST_NODE_DATA, ADD_SECOND_NODE_DATA, ADD_LAST_NODE_DATA};

    public static final int[] ADD_BY_INDEX_TESTS_INDEXES = new int[]{ADD_ZERO_NODE_INDEX, ADD_FIRST_NODE_INDEX};
    public static final Integer[] ADD_BY_INDEX_TESTS_VALUES = new Integer[]{ADD_BY_INDEX_ZERO_NODE_DATA, ADD_BY_INDEX_FIRST_NODE_DATA};
    public static final Integer[][] ADD_BY_INDEX_TESTS = new Integer[][]{ADD_BY_INDEX_ZERO_TEST, ADD_BY_INDEX_FIRST_TEST};



    public static final Integer REMOVE_ZERO_NODE_DATA = new Integer(0);
    public static final Integer REMOVE_FIRST_NODE_DATA = new Integer(1);
    public static final Integer REMOVE_SECOND_NODE_DATA = new Integer(2);
    public static final Integer REMOVE_LAST_NODE_DATA = new Integer(3);
    public static final Integer[] REMOVE_TEST = new Integer[]{REMOVE_ZERO_NODE_DATA, REMOVE_FIRST_NODE_DATA, REMOVE_SECOND_NODE_DATA, REMOVE_LAST_NODE_DATA};

    public static final int REMOVE_ZERO_NODE_INDEX = 0;
    public static final Integer[] REMOVE_ZERO_TEST = new Integer[]{REMOVE_FIRST_NODE_DATA, REMOVE_SECOND_NODE_DATA, REMOVE_LAST_NODE_DATA};

    public static final int REMOVE_SECOND_NODE_INDEX = 1;
    public static final Integer[] REMOVE_SECOND_TEST = new Integer[]{REMOVE_FIRST_NODE_DATA, REMOVE_LAST_NODE_DATA};

    public static final int REMOVE_LAST_NODE_INDEX = 1;
    public static final Integer[] REMOVE_LAST_TEST = new Integer[]{REMOVE_FIRST_NODE_DATA};

    public static final int[] REMOVE_TESTS_INDEXES = new int[]{REMOVE_ZERO_NODE_INDEX, REMOVE_SECOND_NODE_INDEX, REMOVE_LAST_NODE_INDEX};
    public static final Integer[][] REMOVE_TESTS = new Integer[][]{REMOVE_ZERO_TEST, REMOVE_SECOND_TEST, REMOVE_LAST_TEST};


    public static final Integer ITERATOR_ZERO_NODE_DATA = new Integer(0);
    public static final Integer ITERATOR_FIRST_NODE_DATA = new Integer(1);
    public static final Integer ITERATOR_SECOND_NODE_DATA = null;
    public static final Integer[] ITERATOR_TEST = new Integer[]{ITERATOR_ZERO_NODE_DATA, ITERATOR_FIRST_NODE_DATA};

    public static final Integer[] ITERATOR_TESTS_NEXT = new Integer[]{ITERATOR_ZERO_NODE_DATA, ITERATOR_FIRST_NODE_DATA, ITERATOR_SECOND_NODE_DATA};
    public static final boolean[] ITERATOR_TESTS_HAS_NEXT = new boolean[]{true, true, false};

}
