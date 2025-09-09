package Ch18;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
	protected String name;
	protected Integer age;
	
	public Person() {}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer  age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

class Employee extends Person{
	private String darptment;
	private String role;
	
	public Employee() {}
	public Employee(Person person) {
		this.name = person.getName();
		this.age = person.getAge();
		//super(이름,나이)
	}

	public Employee(String darptment, String role) {
		super();
		this.darptment = darptment;
		this.role = role;
	}

	public String getDarptment() {
		return darptment;
	}

	public void setDarptment(String darptment) {
		this.darptment = darptment;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [darptment=" + darptment + ", role=" + role + ", name=" + name + ", age=" + age + "]";
	}

	
	
	
} 

public class C01Map {
	public static void main(String[] args) {
	
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		//filter
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		list2.stream() //스트림 작업 반환 및
			.filter((n)->{return n%2==0;})
			.collect(Collectors.toList());
		System.out.println(list2);
		//map
		List<Integer> list3 =
		list.stream()
			.filter((n) ->{return n%2==1; } )
			.map((n)->{return n*n;})
			.collect(Collectors.toList());		
		System.out.println(list3);
		//sort
		List<Person> list4 = Arrays.asList(
					new Person("홍길동", 45),
					new Person("홍1", 27),
					new Person("홍2", 37),
					new Person("홍3", 48),
					new Person("홍4", 59),
					new Person("홍5", 90)
				);
		
		List<Person> list5 = 
		list4.stream().sorted((a,b)->{return b.getAge()-a.getAge();})
					.collect(Collectors.toList());
		list5.forEach(System.out::println);
		
		//람다식
		List<Integer> list6=
		list4.stream()
//				.map((el)->{return el.getAge();})
//				.map((el)-> el.getAge()) //one method
				.map(Person::getAge)
				.collect(Collectors.toList());
		
		List<Integer> list7 =
		list4.stream()
//			.map((el)->{return el.getName();})
			.map(Person :: getName) //매서드 참조(::) 연산자 - Person  (Person 안에 있는..) 
//			.map((el)->{return el.length();})
			.map(String :: length)  //  "   - String 
			.collect(Collectors.toList());
		System.out.println(list7);
		
		List<Employee> list8 =
		list4.stream()
//			.map((el)->{return new Employee(el);})
			.map( Employee :: new)
			.collect(Collectors.toList());
		list8.forEach(System.out::println);
		
	}

	
}
