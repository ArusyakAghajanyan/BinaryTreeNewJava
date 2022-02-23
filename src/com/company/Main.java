package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
       tree.insert(5);
       tree.insert(3);
       tree.insert(2);
       tree.insert(4);
       tree.insert(9);
       tree.insert(7);
       tree.insert(6);
       tree.insert(8);
       tree.insert(12);
       tree.insert(10);
       tree.insert(13);

        System.out.println(tree);
        System.out.println(tree.height());


    }

}
