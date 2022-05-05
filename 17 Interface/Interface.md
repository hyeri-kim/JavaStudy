> **인터페이스**
> 

추상 클래스를 고도화 시킨 문법

- 추상 메서드와 상수만 선언해야 한다.
- 다른 클래스에서 인터페이스를 지정 할 때에는 implements를 사용한다.
- 지정된 인터페이스가 가지고 있는 추상 메서드들을 반드시 재정의 해야한다. (강제성)
- 즉, 일반 메서드는 정의할 수 없다.

```java
package marker;
/*
 * Phone 인터페이스 내에서 모든 핸드폰이 사용하는 기능 정의
 * Phone2G, Phone3G, Phone4G에 구현한다.
 * User 클래스에서 3가지 전부 사용해보기
 */
public interface Phone {
	void msg(String str, String tel);
	void call(String tel);
	void useInternet();
}
```

```java
package marker;

public class Phone2G extends PhoneAdapter{
	@Override
	public void msg(String str , String tel) {
			System.out.println(tel+"에게 전송중"+"\n내용 : "+str);
	}

	@Override
	public void call(String tel) {
		System.out.println(tel+"에게 전화거는 중");
	}
}
```

```java
package marker;

public class Phone3G implements Phone{

	@Override
	public void msg(String str, String tel) {
		
	}

	@Override
	public void call(String tel) {
		
	}
	
	@Override
	public void useInternet() {
		System.out.println("웹 서핑");
	}
}
```

```java
package marker;

public class Phone4G implements Phone{

	@Override
	public void msg(String str, String tel) {
		
	}

	@Override
	public void call(String tel) {
		
	}
	
	@Override
	public void useInternet() {
		System.out.println("빠른 속도로 웹 서핑");
	}
}
```

```java
package marker;

public abstract class PhoneAdapter implements Phone {

	public void turnOn() {
		System.out.println("전원 켜기");
	}
	
	public void turnOff() {
		System.out.println("전원 끄기");
	}
	
	@Override
	public void msg(String str, String tel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void call(String tel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void useInternet() {
		// TODO Auto-generated method stub

	}
}
```
