## 접근 권한 제어자

> **default**
> 

접근 지정자를 생략하고 클래스를 선언한 경우를 말한다.

- 같은 패키지 내에 있는 클래스들만 접근이 가능하다.

> **public**
> 
- 다른 클래스와 다른 패키지에서 접근이 가능하다.

> **protected**
> 
- 같은 패키지 내의 모든 클래스에서 접근이 가능하다.
- 다른 패키지의 클래스라도 해당 클래스를 상속 받았다면 접근이 가능하다.

> **private**
> 

기본적으로 비공개를 의미한다.

- 같은 클래스 내부 멤버에 의해서만 접근이 가능하다. (선언된 영역에서만 접근 가능)
- 같은 패키지에 있더라도 다른 어떤 클래스에서도 접근할 수 없다.
    
    → 오직 자기 자신 클래스에서만 접근이 가능하다.
    

## getter(), setter()

> **getter()**
> 

데이터 가져오기

- public 제어자를 붙여서 다른 클래스 혹은 패키지에서도 private 변수에 접근할 수 있도록 해 준다.
- 단축키 : Alt + Shift + S → R(Generate Getters and Setters...)

> **setter()**
> 

데이터 변경하기

- public 제어자를 붙여서 다른 클래스 혹은 패키지에서도 private 변수에 접근할 수 있도록 해 준다.

```java
package day13;

public class Access { //메인 class에만 public이 붙을 수 있다.
	
	int data1 = 10;
	public int data2 = 20;
	protected int data3 = 30;
	private int data4 = 40;
	
	//다른 곳에서 private 값에 접근 하는 법 -> 메서드를 통해 접근
	// setter -> private 값을 변경할 때 사용
	public int getData4() {
		return data4;
	}
	
	public void setData4(int data4) {
		this.data4 = data4;
	}
	
	void f() {
	}
}

class Cloud {
	void function() {
		Access a = new Access();
	}
}
```

```java
package day13;

public class Access2 {
	void function() {
		Access a = new Access();
		a.data3 = 30;
		System.out.println(a.data3);
	}
	public static void main(String[] args) {
		Access2 a = new Access2();
		a.function();
	}
}
```

```java
package access;

import day13.Access;

public class Access3 {
	private void function() {
		Access a = new Access();
		System.out.println(a.getData4());
	}
}
```
