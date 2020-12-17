package com.zc.base;

import com.zc.base.tree.IntegerTree;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class IntegerTreeTest {

    @Test
    public void testPut(){

        IntegerTree<String> tree = new IntegerTree<>();
        for(int i = 0; i < 20; i ++){
            int num = ThreadLocalRandom.current().nextInt(100);
            tree.put(num, "value_" + num);
        }


    }

}
