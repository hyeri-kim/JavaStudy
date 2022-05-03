## static final

- static은 클래스 변수이다.
- 그러므로 static final은 객체(인스턴스)가 아닌 클래스에 존재하는 단 하나의 상수이다.
- 즉, 객체마다 값이 바뀌는 것이 아닌 클래스에 존재하는 상수이므로 **선언과 동시에 초기화**를 해주어야 하는 클래스 상수이다.

```java
public class test {
	static final int a = 1;  //선언과 동시에 초기화
	public static void main(String args[]) {
		System.out.println(a);
	}
}
```
