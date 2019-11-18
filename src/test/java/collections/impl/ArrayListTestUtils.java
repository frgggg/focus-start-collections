package collections.impl;

public class ArrayListTestUtils {
    public static final int THROW_ARRAY_LIST_SIZE_CONSTRUCTOR_ARG = 0;
    public static final double THROW_FILL_FACTOR_MORE_THEN_ONE_CONSTRUCTOR_ARG = 1.1;
    public static final double THROW_FILL_FACTOR_LESS_THEN_ZERO_CONSTRUCTOR_ARG = -1.1;

    public static final int START_ARRAY_SIZE = 2;
    public static final int START_SIZE = 0;
    public static final double START_FILL_FACTOR = 0.5;

    public static ArrayList<Integer> ADD_ARRAY_LIST = new ArrayList<>(START_ARRAY_SIZE, START_FILL_FACTOR);
    public static final Integer ADD_INTEGER = new Integer(1);
    public static final int AFTER_ADD_ARRAY_LIST_SIZE = START_ARRAY_SIZE * ArrayList.DEF_MAGNIFICATION_FACTOR;

    public static ArrayList<Integer> REMOVE_ARRAY_LIST = new ArrayList<>(START_ARRAY_SIZE, START_FILL_FACTOR);
    public static final Integer REMOVE_INTEGER = new Integer(1);
    public static final Integer GET_AFTER_REMOVE_INTEGER = new Integer(2);
    public static final int REMOVE_INDEX = 0;
    public static final int GET_AFTER_REMOVE_INDEX = 0;
    public static final int BEFORE_REMOVE_SIZE = 2;
    public static final int AFTER_REMOVE_SIZE = 1;
    public static final int REMOVE_NOT_EXIST_INDEX_GET_NULL = GET_AFTER_REMOVE_INDEX + 1;

    public static ArrayList<Integer> GET_ARRAY_LIST = new ArrayList<>(START_ARRAY_SIZE, START_FILL_FACTOR);
    public static final Integer GET_INTEGER = new Integer(1);
    public static final int GET_INDEX = 0;
    public static final int GET_NULL_INDEX = 1;

    static
    {
        REMOVE_ARRAY_LIST.add(REMOVE_INTEGER);
        REMOVE_ARRAY_LIST.add(GET_AFTER_REMOVE_INTEGER);

        GET_ARRAY_LIST.add(GET_INTEGER);
    }
}
