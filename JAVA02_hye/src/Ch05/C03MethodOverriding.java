package Ch05;

class Animal{
	void sound() {System.out.println("소리낸다....");}
}

class Dog extends Animal{
	//함수 재정의 - 수동 => 오버로딩과 다르게 헤더 건들기 X!
	void sound() {System.out.println("멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!멍멍!");}
}

class Cat extends Animal{
	//람수 재정의 - 자동 => source -> Overriding implemethod... 
	@Override
	void sound() {
		System.out.println("꽁꽁 얼어붙은 강에 고양이가 걸어다닙니다");
	}
	
}

public class C03MethodOverriding {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.sound();
		
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat .sound();
		
	System.out.println("-----------------");
	animal = dog; //상위클래스형 참조변수 = 하위객체 업 캐스팅 
	// 기본적으로 자동 형변환 / 하위객체가 재정의를 했다면 재정의(확장/추가 아님)를 했다면 재정의 출력 )
	animal.sound(); // 상위 클래스참조 변수가 하위클래스의 힙 영역에 연결(힙영역은 method == Class(공유))
	animal = cat;
	animal.sound();
	
	
	
 	}
}
