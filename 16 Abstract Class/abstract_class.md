> **추상 클래스(불완전한 클래스)**
> 

추상적인 내용만 정의하고 있는 클래스로 구체적인 내용은 하위 클래스에서 구현되도록 해놓은 클래스

- 추상클래스는(부모)  클래스들의(자식)  공통요소들을 가상화 시켜놓는다.
- 객체화는 가능하나 잘 사용하지 않는다. (bc. 목적에 어긋난다)
- 부모 추상 클래스의 역할은 단지 자식 클래스를 만들 때 도와주는 역할을 수행하기 위해 존재한다. (다형성)
- 중괄호 없으면 미구현 상태, 중괄호 있으면 구현 상태
- 자식 클래스에서 사용할 메서드의 이름만 갖고 있다. (미구현 상태)
    
    즉, `{}`를 갖지 않는다.
    
- 그 메서드를 추상 메서드라고 하며, abstract 키워드가 앞에 붙는다.
- 일반 메서드도 선언 가능하다.

```java
abstract 추상클래스명 {

	abstract 리턴타입 추상 메서드(매개변수,....);

}
```

```java
package day21;

public abstract class Shape {
	double area;

	public abstract void draw(double w, double h); // 미구현된 상태

	final static void function() { // final ->재정의 못하게 막아줌
		System.out.println("추상 클래스의 일반 메서드 입니다.");
	}

}

class Rect extends Shape {
	@Override
	public void draw(double w, double h) {
		System.out.println("직사각형 점 4개 연결");
		area = w * h;
		System.out.println("넓이 : " + area);
	}
}

class Tri extends Shape {

	@Override
	public void draw(double w, double h) {
		System.out.println("삼각형 점 3개 연결");
		area = (w * h) / 2;
		System.out.println("넓이 : " + area);
	}

}
```
