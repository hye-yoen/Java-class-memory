package Ch14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class C01BASIC {

	public static void main(String[] args) throws Exception {
		
		Class<?> clazz =  Class.forName("java.lang.String");//클래스를 제너릭으로 받기 -> String 클래스 위치 찾기
		
		//모든 Field 확인 (String class에 있는)
//		Field[] fields = clazz.getDeclaredFields(); //모든 필드 가져오기
//		for(Field field : fields) {
//			System.out.println(field);
//		}
//		
		//모든 생성자 확인
//		Constructor[] constructors =  clazz.getDeclaredConstructors();
//		for(Constructor con : constructors) {
//			System.out.println(con);
//		}
		
		//모든 메서드 확인
//		Method [] methods = clazz.getDeclaredMethods();
//		for(Method m : methods)
//			System.out.println(m);
		
	

	}

}
