package collections.impl;

public class BinarySearchTreeTestUtils {
    public static final int FIRST_NODE_VALUE = 6;
    public static final int SECOND_LEFT_NODE_VALUE = 3;
    public static final int SECOND_RIGHT_NODE_VALUE = 10;
    public static final int LAST_LEFT_NODE_VALUE = 1;
    public static final int LAST_RIGHT_NODE_VALUE = 5;

    /*
            (6)
        (3)         (10)
     (1)    (5)
     */
    public static final int[] NOT_REVERSE_RESULT_VALUES = new int[]{LAST_LEFT_NODE_VALUE, LAST_RIGHT_NODE_VALUE, SECOND_LEFT_NODE_VALUE, SECOND_RIGHT_NODE_VALUE, FIRST_NODE_VALUE};
    public static final boolean[] NOT_REVERSE_RESULT_HAS_NEXT = new boolean[]{true, true, true, true, true, false};
    public static final int HAS_NEXT_FALSE_NUMBER = 5;

    /*
            (6)
        (10)        (3)
                (5)     (1)
     */
    public static final int[] REVERSE_RESULT_VALUES = new int[]{SECOND_RIGHT_NODE_VALUE, LAST_RIGHT_NODE_VALUE, LAST_LEFT_NODE_VALUE, SECOND_LEFT_NODE_VALUE, FIRST_NODE_VALUE};

    public static BinarySearchTree BINARY_SEARCH_TREE = new BinarySearchTree();
}
