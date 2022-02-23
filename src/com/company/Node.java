package com.company;

import java.util.Objects;

public class Node<Type extends Comparable<Type>> {
    private Type info;
    private Node<Type> left;
    private Node<Type> right;

    public Node(Type info, Node<Type> left, Node<Type> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }

    public Type getInfo() {
        return info;
    }

    public void setInfo(Type info) {
        this.info = info;
    }

    public Node<Type> getLeft() {
        return left;
    }

    public void setLeft(Node<Type> left) {
        this.left = left;
    }

    public Node<Type> getRight() {
        return right;
    }

    public void setRight(Node<Type> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" + info + '}';
    }


}
