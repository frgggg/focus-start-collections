package collections.impl;

import collections.List;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    public static final String THROW_ARRAY_SIZE = "Array size <= 0.";
    public static final String THROW_FILL_FACTOR = "FILL factor <= 0 or >= 1.";

    private static final int DEF_ARRAY_LIST_SIZE = 16;
    private static final double DEF_FILL_FACTOR = 0.75;
    public static final int DEF_MAGNIFICATION_FACTOR = 2;

    private int size = 0;
    private int arraySize = DEF_ARRAY_LIST_SIZE;
    private double fillFactor = DEF_FILL_FACTOR;
    private Object[] array;

    public ArrayList()
    {
        this(DEF_ARRAY_LIST_SIZE, DEF_FILL_FACTOR);
    }

    public ArrayList(int arraySize)
    {
        this(arraySize, DEF_FILL_FACTOR);
    }

    public ArrayList(double fillFactor)
    {
        this(DEF_ARRAY_LIST_SIZE, fillFactor);
    }

    public ArrayList(int arraySize, double fillFactor)
    {
        this.arraySize = arraySize;
        this.fillFactor = fillFactor;

        if(arraySize <= 0)
            throw new IllegalArgumentException(THROW_ARRAY_SIZE);

        if((fillFactor <= 0) || (fillFactor >= 1))
            throw new IllegalArgumentException(THROW_FILL_FACTOR);

        array = new Object[arraySize];
    }

    @Override
    public boolean add(E e) {
        if((size+1) < Integer.MAX_VALUE) {
            array[size] = e;
            size += 1;
            resetArray();
            return true;
        }
        else
            return false;
    }

    @Override
    public E remove(int index) {
        if((index >=0) && (index < size))
        {
            E ret = (E)array[index];

            for(int i = index; i < (size-1); i++)
                array[i] = array[i+1];
            array[size-1] = null;
            size -= 1;

            return ret;
        }
        return null;
    }

    @Override
    public E get(int index) {
        if((index >=0) && (index < size))
            return (E)array[index];
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Object[] iteratorArray = array;
            int point = 0;
            @Override
            public boolean hasNext() {
                if(point < iteratorArray.length)
                    return true;
                return false;
            }

            @Override
            public E next() {
                if(hasNext())
                {
                    point++;
                    return (E)iteratorArray[point - 1];
                }

                return null;
            }
        };
    }

    private void resetArray()
    {
        if(size >= (arraySize * fillFactor))
        {
            Object[] bufArray = array;

            long maxCheckArraySize = arraySize * DEF_MAGNIFICATION_FACTOR;
            if(maxCheckArraySize < Integer.MAX_VALUE)
                arraySize = (int)maxCheckArraySize;
            else
                arraySize = Integer.MAX_VALUE;

            array = new Object[arraySize];
            for(int i = 0; i < size; i++)
                array[i] = bufArray[i];
        }
    }

    public int getSize() {
        return size;
    }
    public int getArraySize() {
        return arraySize;
    }
    public double getFillFactor() {
        return fillFactor;
    }
}
