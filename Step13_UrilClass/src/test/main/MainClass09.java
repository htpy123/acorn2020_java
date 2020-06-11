package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 	3명의 회원정보 (번호, 이름, 주소) 를 HashMap 객체에 담고
		 * 
		 * 	HashMap 객체의 참조값을 ArrayList 객체에 순서대로 담아보세요
		 */
		Map<String, Object> hash1 = new HashMap<>();
		hash1.put("num", 1);
		hash1.put("name", "김구라");
		hash1.put("addr", "노량진");
		
		hash1.get("num");
		
		HashMap<String, Object> hash2 = new HashMap<>();
		hash2.put("num", 2);
		hash2.put("name", "해골");
		hash2.put("addr", "상도동");
		
		HashMap<String, Object> hash3 = new HashMap<>();
		hash3.put("num", 3);
		hash3.put("name", "주뎅이");
		hash3.put("addr", "이뎅주");
		
//		List<HashMap> list = new ArrayList<>();
//		list.add(hash1);
//		list.add(hash2);
//		list.add(hash3);
		
		//해보세요
//		for(Map<String, Object> tmp : list) {
//			int num = (int)tmp.get("num");
//			String name = (String)tmp.get("name");
//			String addr = (String)tmp.get("addr");
//			
//			System.out.println(num+" | "+name+" | "+addr);
//			}
		//참조 연습
//		List<Map<String, Object>> a = list;
//		Map<String, Object> b = list.get(0);
//		Object c = list.get(0).get("num");
//		Object d = list.get(0).get("name");
//		Object e = list.get(0).get("addr");
//		int f = (int)list.get(0).get("num");
//		String g = (String)list.get(0).get("name");
//		String h = (String)list.get(0).get("addr");
//		int i = ((String)list.get(0).get("addr")).length();
		}
}