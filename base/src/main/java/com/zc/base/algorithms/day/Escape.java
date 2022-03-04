package com.zc.base.algorithms.day;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为(x, y) 。
 *
 * 现在从源方格source = [sx, sy]开始出发，意图赶往目标方格target = [tx, ty] 。数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 *
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表blocked上。同时，不允许走出网格。
 *
 * 只有在可以通过一系列的移动从源方格source 到达目标方格target 时才返回true。否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-a-large-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Escape {

    int[][] r = {{0,1}, {0,-1}, {1,0},{-1,0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        Set<Node> blocks = new HashSet<>();
        for (int i = 0; i < blocked.length; i++) {
            blocks.add(new Node(blocked[i][0], blocked[i][1]));
        }

        return check(blocks, new Node(source[0], source[1]), new Node(target[0], target[1]));

    }

    private boolean check(Set<Node> blocks, Node start, Node end) {
        int s = blocks.size();
        if(s < 2){
            return false;
        }

        int countDown = s * (s-1) / 2;              // 最大能围住的区块
        Queue<Node> queue = new LinkedList<>();     // 当前验证的节点
        Set<Node> visited = new HashSet<>();        // 已经搜索过的节点
        queue.add(start);

        while(!queue.isEmpty() && countDown > 0){
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                Node next = new Node(cur.x + r[i][0], cur.y + r[i][1]);
                if(next.x == end.x && next.y == end.y){
                    return true;
                }
                if(next.x < 0 && next.y < 0 && next.x > 1000000 && next.y > 1000000){
                    continue;
                }
                if(!blocks.contains(next) && !visited.contains(next) && !queue.contains(next)){
                    visited.add(next);
                    queue.add(next);
                    countDown --;
                }
            }
        }
        if(countDown > 0){
            return check(blocks, end, start);
        }
        return false;
    }

    @AllArgsConstructor
    class Node{

        int x;

        int y;

        @Override
        public int hashCode() {
            return (int)((long)(x << 20) | y);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Node){
                Node node = (Node) obj;
                return this.x == node.x && this.y == node.y;
            }
            return false;
        }
    }

}
