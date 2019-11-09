package com.gf.music;

import com.gf.music.domain.User;
import com.gf.music.util.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MusicApplicationTests {

	@Test
	void contextLoads() {
		List<HashMap<String,Object>> a = new ArrayList();
		HashMap para = new HashMap();
		para.put("one","one");
		a.add(para);
		try {
			List b = deepCopy(a);
			((HashMap<String,String>)b.get(0)).put("two",((HashMap<String,String>)b.get(0)).remove("one").toString());
			System.out.println(a);
			System.out.println(b);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void test1(){
		User user1 = new User(1,"gg","gg",1,"gg","gg");
		ArrayList<User> list1 = new ArrayList();
		list1.add(user1);
		ArrayList<User> list2 = CollectionUtils.darkCopy(list1);
		list2.get(0).setName("cc");
		System.out.println(list1);
		System.out.println(list2);
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
