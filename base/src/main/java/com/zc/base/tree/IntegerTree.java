package com.zc.base.tree;

import java.util.Iterator;

public class IntegerTree<V> implements Iterator {

    private TreeNode root;

    private TreeNode minNode;

    private Integer size;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    private class TreeNode{

        private Integer key;

        private V v;

        private TreeNode leftSon;

        private TreeNode rightSon;

        private boolean removed = true;

        private TreeNode(Integer key, V v){
            this.key = key;
            this.v = v;
        }

    }

    public void put(Integer key, V v){
        TreeNode cur = new TreeNode(key, v);
        put(cur, root);
    }

    public void put(TreeNode cur, TreeNode tmpRoot){

        if(root == null){
            root = cur;
            size ++;
            return;
        }

        if(cur.key < tmpRoot.key){
            put(cur, tmpRoot.leftSon);
        }else if(cur.key > tmpRoot.key){
            put(cur, tmpRoot.rightSon);
        }else {
            tmpRoot.v = cur.v;
        }
    }

    public V get(Integer key){
        if(key == null){
            throw new NullPointerException("key不能为空");
        }

        return get(root, key);
    }

    public V get(TreeNode tmpRoot, Integer key){
        if(root == null){
            return null;
        }else if(root.key < key){
            return get(tmpRoot.rightSon, key);
        }else if(root.key > key){
            return get(tmpRoot.leftSon, key);
        }else {
            return root.v;
        }
    }

    public int size(){
        return size;
    }

    public void remove(Integer key){
        if(key == null){
            throw new NullPointerException("key不能为空");
        }
        if(root == null){
            return;
        }else if(key < root.key){
            remove(root, root.leftSon, key);
        }else if(key > root.key){
            remove(root, root.rightSon, key);
        }else {
            size --;
            root = null;
        }

    }

    private void remove(TreeNode parentNode, TreeNode tmpRoot, Integer key) {
        if(tmpRoot == null){
            return;
        }else if(key < tmpRoot.key){
            remove(tmpRoot, tmpRoot.leftSon, key);
        }else if(key > tmpRoot.key){
            remove(tmpRoot, tmpRoot.rightSon, key);
        }else {
            tmpRoot.v = null;
            tmpRoot.removed = false;
            size --;
        }
    }

}
