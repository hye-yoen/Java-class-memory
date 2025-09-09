package Ch19;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface  
interface Func1 {
	void say(String message);
}
@FunctionalInterface  
interface Func2 {
	void say(Integer...args );
}
@FunctionalInterface  
interface Func3 {
	List<Integer> sum(Object...args );
}

public class C01FunctionalinterfaceMain {

	public static void main(String[] args) {
		//01 
		Func1 func1 = (message) -> {System.out.println(message + "_!");};
		func1.say("안녕 못해");
		
		Func1 func1_2 = System.out::println;
		func1_2.say("피곤해");
		
		//02
		Func2 func2 = (arr) ->{
			int sum = 0;
			for(Integer n : arr)
				sum+=n;
//			return sum;
		};
//		System.out.println(func2.sum(10,20,30,40,50));
		
//		//03
//		Func3 func3 = (arr) -> {
//			return Arrays.stream(arr)
//					.filter((obj) -> {return obj instanceof Integer})
//					,map((obi)->return (Integer)obj;)
//					.collect(Colllertors.toList);
//			
//		};

	}

}
