package com.zc.base.datastructure;

public class MyHashMap<K,V> implements IMap<K,V>{

    private Node root;

    static class Node<K,V>{
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        if(key == null){
            throw new IllegalArgumentException("key不能为空");
        }
        Node node = new Node(key, value);
        addNode(root, node);
    }

    private void addNode(Node root, Node node) {
        if(root == null){
            root = node;
            return;
        }
        if(node.hashCode() < root.hashCode()){
            addNode(root.left, node);
        }else if(node.hashCode() > root.hashCode()){
            addNode(root.right, node);
        }else {
            root = node;
        }
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    public static void main(String[] args) {
//        Node<String, String> node = new Node<>("1", "name");
//        System.out.println("node".hashCode());
    }

}
