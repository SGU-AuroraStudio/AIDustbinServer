package com.aurora.Test;

import com.aurora.util.RandomNickName;
import org.junit.Test;

public class TestRandomName {
    @Test
    public void testRandomName(){
        System.out.println(RandomNickName.generateName());
    }

}
