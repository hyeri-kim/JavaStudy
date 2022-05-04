## Over Loading

같은 이름의 메서드라도 매개변수의 개수 혹은 타입이 다르면 선언 가능하다.

- 예시 코드

```java
public class OverLoading {
	
	void add(int num1, int num2) {
		System.out.println("두 정수의 합");
		System.out.println(num1+num2);
	}
	
	void add(int num1, int num2, int num3) {
		System.out.println("세 정수의 합");
		System.out.println(num1+num2+num3);
	}
	
	void add(double num1, double num2) {
		System.out.println("두 실수의 합");
		System.out.println(num1+num2);
	}
	
	public static void main(String[] args) {
		OverLoading o = new OverLoading();
		o.add(10, 20);
		o.add(10.5, 20.9);
		o.add(1, 2, 3);
		
	}
}
```

## Overriding(재정의)

부모 클래스에서 정의된 메서드를 자식 클래스에서 다르게 정의할 때 사용된다.

- 자식 클래스에서 부모 클래스의 메서드를 재정의 하기 위해서는 **부모 메서드의 이름, 리턴타임, 매개변수의 개수, 자료형, 순서**를 동일하게 하여 자식 클래스에서 작성해야 한다.
- 접근 제어자는 주로 부모 클래스와 동일하게 사용하지만 접근 범위를 넓게 지정할 수는 있다.

```java
class SuperClass {
	public void method(매개변수1, 매개변수2,...) {}
}
class SubClass extends SuperClass {
	public void method(매개변수1, 매개변수2,...) {}
}
```

- main 메서드에서 자식 클래스로 인스턴스를 생성하고 `Subclass sub = new SubClass();`
- 메서드를 호출하면 `sub.` 자식 클래스의 재정의된 메서드만 호출한다.
- 이때, 부모의 메서드를 호출하고 싶다면 `super.메서드명()` 으로 호출이 가능하다.

> **요약**
> 
- 오버라이딩이란 **상속받은 메소드를 자식 클래스에서 재정의하여 사용하는 것**이다.
- 자식 클래스에서 **부모의 메서드를 수정해야 할 때** 사용된다.
- **추상 클래스**나 **인터페이스**에서 필수적으로 사용하는 개념이다.
- 자식클래스에서 부모 클래스의 메서드와 **동일한 조건(메서드 이름, 리턴 타입, 매개변수의 개수, 자료형, 순서)을 적용**해야 한다.
- 오버라이딩 결과 부모 메서드는 은닉되고 **자식 클래스에서 재정의된 메서드만 기본적으로 호출**된다. 필요 시 `super.`으로 부모 메서드를 호출할 수 있다.
