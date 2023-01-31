package enumTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {
	public static List<Item> setData(){
		
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1001,"과자","새우깡",1500));
		itemList.add(new Item(1002,"음료수","사이다",1000));
		itemList.add(new Item(1003,"과자","고래밥",3000));
		itemList.add(new Item(1004,"음료수","콜라",500));
		itemList.add(new Item(1005,"고기","닭고기",18000));
		itemList.add(new Item(1006,"고기","돼지고기",20000));
		itemList.add(new Item(1004,"음료수","콜라",500));
		itemList.add(new Item(1005,"고기","닭고기",18000));
		itemList.add(new Item(1006,"고기","돼지고기",20000));
		
		return itemList;
		
	}
	
	public static void main(String[] args) {
		List<Item> itemList = setData();
		
		// 문제 1번 전체 출력
		System.out.println("===========1==============");
		itemList.stream().forEach(System.out::println);
		// 문제 2번 중복된 데이터 제거 후 출력 
		System.out.println("===========2==============");
		itemList.stream().distinct().forEach(System.out::println);
		// 문제 3번 카테고리가 과자인 itemList 출력
		System.out.println("===========3==============");
		itemList.stream().filter(i -> i.getCategorayName().equals("과자")).forEach(System.out::println); 
		// 문저 4번 카테고리가 고기인 item 갯수 출력 
		System.out.println("===========4==============");
		System.out.println(itemList.stream().filter(i -> i.getCategorayName().equals("고기")).count());
		// 문제 5번 가격이 10000원 이상인 값들의 	ArrayList<Item> 만들기
		System.out.println("===========5==============");
		itemList.stream().filter(i->i.getPrice()>=10000).collect(Collectors.toList()).forEach(System.out::println);
		// 문제 6번 카테고리가 고기인 아이템 이름들만 가져와서 	ArrayList<String>으로 만들기
		System.out.println("===========6==============");
		List<String> temp = itemList.stream()
				.filter(i-> i.getCategorayName().equals("고기"))
				//.map(i->i.getItemName())
				//축약형
				.map(Item::getItemName)
				.collect(Collectors.toList());
		for(String s : temp) {
			System.out.println(s);
		}
	
	}
}