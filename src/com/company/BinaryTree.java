package com.company;

import com.sun.corba.se.spi.ior.IdentifiableBase;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<Type extends Comparable<Type>> {
    public Node<Type> root;
    private int size;


    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(Type value) {
        if (root == null) {
            root = new Node<>(value, null, null);
            size++;
            return;
        }
        Node<Type> temp = root;
        Node<Type> parentNode = null;
        while (temp != null) {
            parentNode = temp;
            if (value.compareTo(temp.getInfo()) > 0) {
                temp = temp.getRight();
            } else if (value.compareTo(temp.getInfo()) < 0) {
                temp = temp.getLeft();
            }
        }
        if (value.compareTo(parentNode.getInfo()) > 0) {
            parentNode.setRight(new Node<>(value, null, null));
        } else if (value.compareTo(parentNode.getInfo()) < 0) {
            parentNode.setLeft(new Node<>(value, null, null));
        }
        size++;
    }

    public List<Type> inOrderTraverseIterative() {
        Stack<Node<Type>> st = new Stack<>();
        List<Type> list = new LinkedList<>();

        if (root == null) {
            return new LinkedList<>();
        }

        Node<Type> temp = root;
        while (temp != null || !st.isEmpty()) {
            while (temp != null) {
                st.push(temp);
                temp = temp.getLeft();
            }
            temp = st.pop();
            list.add(temp.getInfo());
            temp = temp.getRight();
        }
        return list;
    }

    public boolean contains(Type key) {
        Node<Type> temp = root;
        if (root == null) return false;
        while (temp != null) {
            if (temp.getInfo().compareTo(key) == 0) return true;
            else if (key.compareTo(temp.getInfo()) < 0) temp = temp.getLeft();
            else if (key.compareTo(temp.getInfo()) > 0) temp = temp.getRight();
        }
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Data { tree ");
        result.append(inOrderTraverseIterative().toString());
        result.append(" size: ").append(size).append(" }");
        return result.toString();
    }

    public int height() {
        Node<Type> temp = root;
        if (root == null) return 0;
        int height = 0;
        Queue<Node<Type>> queue = new LinkedList<>();
        queue.add(temp);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node<Type> poll = queue.poll();
            if (poll == null) {
                height++;
            }
            if (poll != null) {
                if (poll.getLeft() != null) {
                    queue.add(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    queue.add(poll.getRight());
                }
            } else if (!queue.isEmpty()) {
                queue.add(null);
            }
        }
        return height;

    }

}
