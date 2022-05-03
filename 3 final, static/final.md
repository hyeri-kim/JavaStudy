## **final**

→ 크게 상수, 메서드 클래스 3가지 경우에 같이 사용할 수 있다.

> **상수 정의에 사용**
> 
- 용도 : 상수에 언제든 값을 한 번 저장하고 다음에 다시 바꾸지 않을 때 사용한다.
- 형태 : `final 타입 상수명`

```java
	final int a;
	//final int a = 1; //상수 선언과 함께 값을 정의해도 된다.
	Scanner s= new Scanner(System.in);
	a=s.nextInt();
	//a = 10; //오류 (값을 변경할 수 없다)
	System.out.println(a);
```

> **메서드에 사용**
> 
- 용도 : 오버라이딩(재정의)을 못하게 만든다.
- 형태 : `final 반환형 메서드명(매개변수){}`

```java
class Test{
	public final void test2(){
		//내용정의
	}
}
public class Main extends Test{
	//public test2(){} //compile error: final method는 오버라이딩을 못한다.
}
```

> **클래스에 사용**
> 
- 용도 : 상속을 못하게 만든다.
- 형태 : `final class 클래스명{}`

```java
final class Test {
	int test;
}
//class Main extends Child {} //final class는 상속할 수 없다.
```

→final을 사용한 Test클래스는 객체를 생성할 수 없다.
