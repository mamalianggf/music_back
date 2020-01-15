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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
class MusicApplicationTests {

    /*
    反射+final+常量池+堆
     */
    @Test
    void test2() {
        try {
            String aaaa = new String("aaaa");
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[]) field.get(aaaa);
            Arrays.fill(value, 'b');
            System.out.print(new String("aaaa"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test03() {
        final char[] value = new char[]{'1', '2', '3'};
        value[0] = '0';
        System.out.println(value);
    }

    @Test
    void test04() {
        HashMap<String, String> params = new HashMap<>();
        params.put("roleCode", "ACTOR_946");
        params.put("roleCode", "ACTOR_260");
        System.out.println(params);
    }

    @Test
    void test05() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    }
    @Test
    void test06(){
        String a="gf";
        String b=a;
        StringBuilder sb= new StringBuilder("cxm");
        sb.append("111");
        System.out.println(sb);

        System.out.println(a);
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
