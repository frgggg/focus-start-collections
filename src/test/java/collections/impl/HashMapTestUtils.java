package collections.impl;

public class HashMapTestUtils {
    public static final HashMap<String, String> TEST_HASH_MAP = new HashMap();

    public static final String FIRST_KEY_NULL = null;
    public static final String FIRST_VALUE_BEFORE_INSERT = null;
    public static final String FIRST_VALUE_AFTER_INSERT = "FIRST_VALUE_AFTER_INSERT";

    public static final String SECOND_KEY = "SECOND_KEY";
    public static final String SECOND_VALUE_BEFORE_INSERT = null;
    public static final String SECOND_VALUE_AFTER_INSERT = "SECOND_VALUE_AFTER_INSERT";

    public static final String LAST_KEY = "LAST_KEY";
    public static final String LAST_VALUE = "LAST_VALUE";

    public static final String GET_KEY = SECOND_KEY;
    public static final String GET_VALUE = SECOND_VALUE_AFTER_INSERT;

    public static final String DELETE_KEY = SECOND_KEY;

    public static final int SIZE_AFTER_INSERTS = 3;
    public static final String[] INSERT_KEYS = new String[]{FIRST_KEY_NULL, SECOND_KEY, LAST_KEY};
    public static final String[] INSERT_VALUES = new String[]{FIRST_VALUE_AFTER_INSERT, SECOND_VALUE_AFTER_INSERT, LAST_VALUE};

    public static final String[] DELETE_KEYS = new String[]{FIRST_KEY_NULL, LAST_KEY};
    public static final String[] DELETE_VALUES = new String[]{FIRST_VALUE_AFTER_INSERT, LAST_VALUE};
    public static final int SIZE_AFTER_DELETE = 2;
}
