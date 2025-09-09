package Ch01;
class Person {
	private String name;
	private int age;
	
	public Person() {}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}

public class C10Ex {
	public static void func1(int num) { //원시타입 - 데이터값 저장 목적
		System.out.println(num);
	}
	
	
	public static void func2(Object obj) { //파라미터 :Reference(주소값 사용)
		System.out.println(obj);
	}
	
	public static <T> Object func3(String name , int age) 
	{
		return new Person(name,age);
	}
	
	public static void main(String[] args) {
		func1(10);
		func2(new Person("홍길동",10));
		Object ob = func3("티모",100);
	}
}
