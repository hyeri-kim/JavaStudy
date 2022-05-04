> **상속 특징**
> 
- 기존에 사용 중인 클래스의 필드를 다른 클래스에서 계속 사용을 해야 할 경우 상속 받는다.
- 부모 클래스의 필드를 마치 자신의 것처럼 사용할 수 있다.
- 자식 클래스의 생성자가 실행되기 전에 부모 클래스의 생성자가 먼저 실행된다.
- 실행할 부모 클래스의 생성자를 지정하지 않으면 부모 클래스의 기본 생성자가 자동으로 생성된다.
- 자동으로 입력되는 `super()`를 지우더라도 자바 컴파일러가 자동으로 넣어준다.
- 다중 상속은 불가능하다. (부모클래스 2 + 자식클래스 1)
    - extends 뒤에는 클래스 하나만 올 수 있다.

> **상속 구조**
> 

```java
class A{
	A필드
}

class B extends A{
	A, B 필드
}
```

- A : 부모 클래스, 상위 클래스, 슈퍼 클래스, 기반 클래스
- B : 자식 클래스, 하위 클래스, 서브 클래스, 파생 클래스

> **부모 클래스로부터 상속받은 멤버 변수의 접근 권한이 private일 때**
> 
1. 부모 클래스의 생성자를 호출해서 멤버 변수를 초기화 시킬 수 있다.
2. 부모 클래스에 setter메소드를 통해서 초기화 시킬 수 있다.
3. 변수에 저장된 값은 getter메소드를 통해서 가져온다.

> **부모 클래스로부터 상속받은 멤버 변수의 접근 권한이 protected일 때**
> 
1. 자식 클래스에서 접근이 가능하기 때문에 this를 사용해서 변수를 초기화 한다.
2. 자식 클래스에서 접근이 가능하므로 getter메소드를 사용하지 않고 **변수 명으로 값에 직접 접근**하면 된다.

> **연습**
> 

```java
package day16;

class A {
	int data = 10;
	
	public A() {
		System.out.println("부모 클래스 생성자");
	}
	
	void show() {
		System.out.println("A 클래스");
	}
}

class B extends A{
	@Override
	void show() { // 재정의
		System.out.println("B 클래스");
	}
	
	void check() {
		show();
	}
	
}

public class InhTest {
	public static void main(String[] args) {
		B instance = new B(); // 부모클래스(A)의 생성자가 먼저 실행된다.
		          //-> 자식생성자를 사용하는 부분
		instance.check();
	}
	
}
```
