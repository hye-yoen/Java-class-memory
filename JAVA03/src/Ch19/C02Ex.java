package Ch19;

import java.util.Arrays;

@FunctionalInterface
interface Functional{
	Integer execute(int ...args);	
}

class Calc{
	Functional sum;	//합
	Functional sub;	//차
	Functional mul;	//곱
	Functional div;	//나누기
	Calc(){
		//Functional sum 에 대한 스트림 & 람다식 완성 할 것
		sum=(arr)->{
			return Arrays.stream(arr).reduce(0,(s,el)->{return s+el;});
			};
		//Functional sub 에 대한 스트림 & 람다식 완성 할 것
		sub = (arr)->{
			return Arrays.stream(arr)
					.boxed() //sub에서는 Comparator를 써서 내림차순 정렬을 하고, reduce()에서 조건 분기까지 하려면 객체형 스트림이 필요

					.sorted((a,b)->{return b-a;})
					.reduce(0, (sub,el)->{return sub<el?el-sub:sub-el;}); //아~~ 와...
		};
		//Functional mul 에 대한 스트림 & 람다식 완성 할 것
		mul = (arr)->{
			return Arrays.stream(arr).reduce(1,(m,el)->{return m*el;});
		};
		//Functional div 에 대한 스트림 & 람다식 완성 할 것
		div = (arr) -> {
		    return Arrays.stream(arr).reduce(1, (d, el) -> d / el);
		};
		//조건
		//sum,sub,mul,div 각각에 람다&스트림함수를 적절히 이용해서 기능 구현을 합니다
		//모든 인자를 받을 수있는 가변인자 처리로 구현합니다
		//뺄셈,나눗셈은 큰수에서 작은수로 정렬(sorted)한다음 누적 감산 처리(reduce)를 합니다
	}
}
public class C02Ex {
	
	public static void main(String[] args) {
		
		Calc calc = new Calc();
		System.out.println("합 :"+ calc.sum.execute(10,20,30,40,50,60));
		System.out.println("차 :"+ calc.sub.execute(1,4,2,9));//1,2,4,5
		System.out.println("곱 :"+ calc.mul.execute(10,20,30,40,50,60));
		System.out.println("나눗셈 :"+ calc.div.execute(10,20,30,40,50,60)); //애초에 이거 정수형 값 실수형 값으로 바꿀려 해도 잘 안됨 ㅅㅂ
//		
	}
}