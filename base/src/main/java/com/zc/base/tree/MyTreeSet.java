package com.zc.base.tree;

/**
 * 元素不重复集合
 * @param <T>
 */
public class MyTreeSet<T> {

    private int size;

    private Node<T> root;

    class Node<T>{

        private T value;

        private int hash;

        private Node<T> left;

        private Node<T> right;

        Node(){

        }

        Node(T value, int hash){
            this.value = value;
            this.hash = hash;
        }

    }

    public void add(T t){
        if(t == null){
            throw new NullPointerException();
        }
        Node<T> n = new Node<>(t, t.hashCode());
        if(root == null){
            root = n;
        }
        add(root, n);
    }

    private void add(Node<T> root, Node<T> n) {
        if(n.hash > root.hash){
            if(root.right != null){
                add(root.right, n);
            }else {
                root.right = n;
            }
        }else if(n.hash < root.hash){
            if(root.left != null){
                add(root.left, n);
            }else {
                root.left = n;
            }
        }
    }

    /**
     * 优先以左子树根节点作为新的根节点
     * @param t
     */
    public void delete(T t){
        if(root == null){
            return;
        }
        if(root.hash == t.hashCode()){
            deleteNode(root);
        }
    }

    private void deleteNode(Node<T> node) {
        if(node == root){
            Node l = root.left;
            Node r = root.right;
            if(l != null){
                Node lr = l.right;
                if(lr != null){

                }
            }
        }
    }

    /**
     * 前序排列
     *        8
     *    5      15
     *  3   6  10   20
     *
     *  3 5 6 8 10 15 20
     * @return
     */
    @Override
    public String toString(){
        StringBuilder sbd = new StringBuilder();
        print(root, sbd);
        return sbd.toString();
    }

    private void print(Node<T> root, StringBuilder sbd) {
        if(root == null){
            return;
        }

        if(root.left != null){
            print(root.left, sbd);
        }

        sbd.append(root.value).append(" ");

        if(root.right != null){
            print(root.right, sbd);
        }
    }

}
