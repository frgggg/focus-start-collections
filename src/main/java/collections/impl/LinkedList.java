package collections.impl;

import collections.Iterator;
import collections.List;

public class LinkedList<E> implements List<E> {

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
            return cloneNode;
        }
    }

    private Node firstNode = null;
    private Node headNode = null;

    @Override
    public boolean add(E e) {
        if (firstNode == null)
        {
            firstNode = new Node(e);
            headNode = firstNode;
        }
        else {
            headNode.next = new Node(e);
            headNode = headNode.next;
        }
        return true;
    }

    public boolean add(E e, int index) {
        //todo написать реализацию
        return false;
    }

    @Override
    public E remove(int index) {
        //todo написать реализацию
        return null;
    }

    @Override
    public E get(int index) {
        //todo написать реализацию
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        //todo написать реализацию
        return null;
    }
}
