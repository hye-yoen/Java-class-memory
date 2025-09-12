package Ch20;
//에노테이션 만들기!

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //에노테이션의 유지가간 RUNTIME : 프로그램이 동작중인 생태에서만 실행
@Target({ElementType.TYPE,ElementType.METHOD}) //에노테이션 적용 대상 제한 
//ElementType.TYPE : 믈래스,인터페이스,emn ... 적용
//ElementType.FIELD : 멤버 변수에 적용
//ElementType.METHOD : 메서드에 적용
public @interface CustomAnnotation {
	String value() default "HELLO WORLD";
	int number() default 10;
	boolean isOpen() default false; //default 기본값 <- 기본값 넣기
}
