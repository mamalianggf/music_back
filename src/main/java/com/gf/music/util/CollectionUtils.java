package com.gf.music.util;

import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class CollectionUtils {

    /**
     * 深度复制（改进deepCopy方法)
     * 缺陷：参数t必须实现Serializable接口例如list必须改成其实现类
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T darkCopy(Serializable t) {
        byte[] para = SerializationUtils.serialize(t);
        return SerializationUtils.deserialize(para);
    }

    /**
     * 深度拷贝list
     * 缺陷：参数限定，流没关闭，供以后对照回忆
     *
     * @param src
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    /**
     * 返回一个新建数组
     * 缺陷：只能放一组数据作为参数
     * @param key
     * @param value
     * @return
     */
    public static HashMap createHashMap(String key, Object value) {
        HashMap map = new HashMap();
        map.put(key,value);
        return map;
    }
}
