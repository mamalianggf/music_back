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
    void contextLoads() {
        List<HashMap<String, Object>> a = new ArrayList();
        HashMap para = new HashMap();
        para.put("one", "one");
        a.add(para);
        try {
            List b = deepCopy(a);
            ((HashMap<String, String>) b.get(0)).put("two", ((HashMap<String, String>) b.get(0)).remove("one").toString());
            System.out.println(a);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test1() {
        // 循环bug
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        //其余代码都没有修改，就在list.add("3")之后添加这一行
        list.add("4");
        list.add("5");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("3".equals(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(list);

    }

    @Test
    void test2() {
        //Optional<String> helloOptional = Optional.of("Hello");
        Optional<String> emptyOptional = Optional.empty();
        //helloOptional.ifPresent(s -> System.out.println(s.length()));
        emptyOptional.ifPresent(s -> System.out.println(s.length()));
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

}
