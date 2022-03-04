package com.zc.base.algorithms.his;

import java.util.*;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };

        Sudoku sudoku = new Sudoku();
        System.out.println(sudoku.isValidSudoku(board));
    }

    /**
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> subMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if(!rowMap.containsKey(i)){
                    rowMap.put(i, new HashSet());
                }
                if(rowMap.get(i).contains(board[i][j])){
                    return false;
                }
                rowMap.get(i).add(board[i][j]);
                if(!colMap.containsKey(j)){
                    colMap.put(j, new HashSet());
                }
                if(colMap.get(j).contains(board[i][j])){
                    return false;
                }
                colMap.get(j).add(board[i][j]);
                int key = i/3 * 3 + j/3;
                if (!subMap.containsKey(key)){
                    subMap.put(key, new HashSet());
                }
                if(subMap.get(key).contains(board[i][j])){
                    return false;
                }
                subMap.get(key).add(board[i][j]);
            }
        }
        return true;
    }

}
