package collections.impl;

import collections.Iterator;
import collections.List;

public class LinkedList<E> implements List<E> {
    public static final String THROW_NULL_VALUE = "Add value is null.";
    private Node firstNode = null;
    private int size = 0;

    private Node getNodeByIndex(int index)
    {
        if((index >= 0) && (index < size)) {
            Node node = firstNode;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        }
        return null;
    }

    @Override
    public boolean add(E e) {
        if(e == null)
            throw new IllegalArgumentException(THROW_NULL_VALUE);

        if (firstNode == null)
        {
            firstNode = new Node(e);
        }
        else {
            Node headNode = getNodeByIndex(size - 1);
            if(headNode == null)
                return false;

            headNode.next = new Node(e);
            headNode.next.prev = headNode;
        }
        size += 1;
        return true;
    }

    public boolean add(E e, int index) {
        if(e == null)
            throw new IllegalArgumentException(THROW_NULL_VALUE);

        Node nextNode = getNodeByIndex(index);
        if(nextNode != null)
        {
            Node newNode = new Node(e);
            if(index != 0)
            {
                Node prevNode = nextNode.prev;
                if(prevNode != null) {
                    prevNode.next = newNode;
                    newNode.prev = prevNode;
                }
                else
                    return false;
            }
            else
                firstNode = newNode;

            nextNode.prev = newNode;
            newNode.next = nextNode;
            size += 1;
            return true;
        }

        return false;
    }

    @Override
    public E remove(int index) {
        Node removeNode = getNodeByIndex(index);
        if(removeNode != null) {
            if(index != 0) {
                removeNode.prev.next = removeNode.next;
                if(index != (size - 1))
                    removeNode.next.prev = removeNode.prev;
            }
            else {
                firstNode = removeNode.next;
                removeNode.next.prev = null;
            }

            size -= 1;
            return removeNode.getData();
        }
        return null;
    }

    @Override
    public E get(int index) {
        Node getNode = getNodeByIndex(index);
        if(getNode != null) {
            return getNode.getData();
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        Node copyNode = (Node)firstNode.clone();
        return new Iterator<E>() {
            private Node node = copyNode;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if(node == null)
                    return null;
                Node currentNode = node;
                if(currentNode.next == null)
                    node = null;
                else
                    node = currentNode.next;
                return currentNode.data;
            }
        };
    }

    public int getSize()
    {
        return size;
    }

    class Node
    {
        private Node next = null;
        private Node prev = null;
        private E data;

        public Node(E data)
        {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        @Override
        protected Object clone(){
            Node cloneNode = new Node(this.data);
            if(next != null)
                cloneNode.next = (Node)next.clone();
            if(prev != null)
                cloneNode.prev = prev;
            return cloneNode;
        }
    }
}
