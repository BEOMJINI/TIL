package enumTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
public static void main(String[] args) {
	
	List<String> list = Arrays.asList("a","b","c","a");
	System.out.println(list);
	list.stream().forEach(System.out::println);
	System.out.println("======================");
	System.out.println(list.stream().filter((val)->val.equals("b")).count());
	int count = (int)list.stream()
						.filter((val)->val.equals("b"))
						.count();
	System.out.println(count);
	System.out.println("======================\n중복제거");
	list.stream().distinct().forEach(System.out::println);
	System.out.println("======================");
	List<String> temp = list.stream().distinct().collect(Collectors.toList());
	temp.stream().forEach(System.out::println);
	
}
}
