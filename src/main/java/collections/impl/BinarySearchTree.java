package collections.impl;

import collections.Iterable;
import collections.Iterator;

// monster mode сделать на объъектах с дженериками
public class BinarySearchTree implements Iterable {
    private boolean reverseMode = false;
    private Node firstNode = null;

    public void add(int value) {
        if(firstNode == null) {
            firstNode = new Node(value);
            return;
        }

        createNewNode(firstNode, value);
    }

    public void reverse() {
        reverseMode = !reverseMode;
        if(firstNode != null)
            setReverseModeForNode(firstNode);
    }

    private void createNewNode(Node currentNode, int valueOfNewNode)
    {
        if(reverseMode)
        {
            if(valueOfNewNode < currentNode.value)
            {
                if(currentNode.right == null)
                    currentNode.right = new Node(valueOfNewNode);
                else
                    createNewNode(currentNode.right, valueOfNewNode);
            }
            if(valueOfNewNode > currentNode.value)
            {
                if(currentNode.left == null)
                    currentNode.left = new Node(valueOfNewNode);
                else
                    createNewNode(currentNode.left, valueOfNewNode);
            }
        }
        else
        {
            if(valueOfNewNode < currentNode.value)
            {
                if(currentNode.left == null)
                    currentNode.left = new Node(valueOfNewNode);
                else
                    createNewNode(currentNode.left, valueOfNewNode);
            }
            if(valueOfNewNode > currentNode.value)
            {
                if(currentNode.right == null)
                    currentNode.right = new Node(valueOfNewNode);
                else
                    createNewNode(currentNode.right, valueOfNewNode);
            }
        }
    }

    private void swapNode(Node currentNode)
    {
        Node bufNode;
        bufNode = currentNode.right;
        currentNode.right = currentNode.left;
        currentNode.left = bufNode;
    }

    private void setReverseModeForNode(Node currentNode)
    {
        swapNode(currentNode);

        if(currentNode.left != null)
            setReverseModeForNode(currentNode.left);
        if(currentNode.right != null)
            setReverseModeForNode(currentNode.right);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node node = (Node)firstNode.clone();

            @Override
            public boolean hasNext() {
                return node != null;
            }

            private Node nextProcess(Node parent, Node currentNode, boolean isItRight)
            {
                if((currentNode.left == null) && (currentNode.right == null))
                {
                    Node nextNode = currentNode;
                    if(parent != null)
                    {
                        if(isItRight)
                            parent.right = null;
                        else
                            parent.left = null;
                    }
                    else
                        node = null;
                    return nextNode;
                }

                if(currentNode.left != null)
                    return nextProcess(currentNode, currentNode.left, false);
                else
                    return nextProcess(currentNode, currentNode.right, true);
            }
            @Override
            public Object next() {
                if(hasNext()) {
                    return nextProcess(null, node, true);
                }
                return null;
            }
        };
    }

    public boolean isReverseMode() {
        return reverseMode;
    }

    class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }

        @Override
        protected Object clone(){
            Node cloneNode = new Node(value);
            if(left != null)
                cloneNode.left = (Node)left.clone();
            if(right != null)
                cloneNode.right = (Node)right.clone();
            return cloneNode;
        }
    }
}
