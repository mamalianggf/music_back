package com.gf.music;

import com.gf.music.domain.User;
import com.gf.music.util.CollectionUtils;
import com.sun.corba.se.spi.ior.ObjectKey;
import net.minidev.json.JSONUtil;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
class MusicApplicationTests {

    @Test
    void test2() {

    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int para = 0;
        for (int i = 0; i < nums.length; i++) {
            para = target - nums[i];
            if (map.containsKey(para) && map.get(para) != i) {
                return new int[]{i, map.get(para)};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
