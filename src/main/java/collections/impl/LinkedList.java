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

    private int size = 0;

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
        size += 1;
        return true;
    }

    public boolean add(E e, int index) {
        if((index >= 0) && (index < size))
        {
            // 0 1 2 3|| 4 || 2
            Node leftNode = firstNode;
            for(int i = 0; i < (index-1); i++)
                leftNode = leftNode.next;
            Node rightNode = leftNode.next;
            Node nodeForAdd = new Node(e);
            leftNode.next = nodeForAdd;

            nodeForAdd.prev = leftNode;
            nodeForAdd.next = rightNode;

            rightNode.prev = nodeForAdd;

            size += 1;
            return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if((index >= 0) && (index < size))
        {
            // 0 1 2  3 || 4 || 2
            Node leftNode = firstNode;
            for(int i = 0; i < (index-1); i++)
                leftNode = leftNode.next;
            Node ret = leftNode.next;
            Node rightNode = leftNode.next.next;
            leftNode.next = rightNode;
            rightNode.prev = leftNode;
            size -= 1;
            return ret.getData();
        }
        return null;
    }

    @Override
    public E get(int index) {
        if((index >= 0) && (index < size)) {
            // 0 1 2  3 || 4 || 2
            Node node = firstNode;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node.getData();
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
                E ret;
                if(node.next != null) {
                    ret = node.getData();
                    node = node.next;
                }
                else
                {
                    if(node != null)
                    {
                        ret = node.getData();
                        node = null;
                        return ret;
                    }
                    return null;
                }
                return null;
            }
        };
    }
}
