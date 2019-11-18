package collections.impl;

import collections.Map;

public class HashMap<K, V> implements Map<K, V> {
    private static final int NO_KEY_IN_MAP = -1;
    private static final int DEF_ARRAY_LIST_SIZE = 16;
    private static final double DEF_FILL_FACTOR = 0.75;
    private static final int DEF_MAGNIFICATION_FACTOR = 2;
    private int fillFactor = DEF_MAGNIFICATION_FACTOR;

    public int mapSize = DEF_ARRAY_LIST_SIZE;
    public int size = 0;

    private Object[] keys = new Object[mapSize];
    private Object[] values = new Object[mapSize];

    public boolean containsKey(K key)
    {
        return containsKeyService(key) != NO_KEY_IN_MAP;
    }

    @Override
    public boolean insert(K key, V value) {
        int elementNumber = containsKeyService(key);
        if(elementNumber != NO_KEY_IN_MAP) {
            values[elementNumber] = value;
        }
        else
        {
            if((size + 1) < Integer.MAX_VALUE)
            {
                keys[size] = key;
                values[size] = value;
                size += 1;
                resetArrays();
                return true;
            }
        }

        return false;
    }

    @Override
    public V get(K key) {
        int elementNumber = containsKeyService(key);
        if(elementNumber != NO_KEY_IN_MAP)
            return (V)values[elementNumber];
        return null;
    }

    @Override
    public boolean delete(K key) {
        int elementNumber = containsKeyService(key);
        if(elementNumber != NO_KEY_IN_MAP)
        {
            for(int i = elementNumber; i < (size-1); i++)
            {
                keys[i] = keys[i+1];
                values[i] = values[i+1];
            }

            keys[size-1] = null;
            values[size-1] = null;
            size -= 1;
        }
        return false;
    }

    private void resetArrays()
    {
        if(size >= (mapSize * fillFactor))
        {
            Object[] keys = this.keys;
            Object[] values = this.values;

            long maxCheckMapSize = mapSize * fillFactor;
            if(maxCheckMapSize < Integer.MAX_VALUE)
                mapSize = mapSize * fillFactor;
            else
                mapSize = Integer.MAX_VALUE;

            this.keys = new Object[mapSize];
            this.values = new Object[mapSize];

            for(int i = 0; i < mapSize; i++)
            {
                this.keys[i] = keys[i];
                this.values[i] = values[i];
            }
        }
    }

    private int containsKeyService(K key)
    {
        for(int i = 0; i < size; i++) {
            if(key == null) {
                if(keys[i] == null)
                    return i;
            }
            else
            {
                if(
                        ((K)key).equals( ((K)keys[i]) )
                )
                    return i;
            }

        }
        return NO_KEY_IN_MAP;
    }

    public int getSize() {
        return size;
    }
}
