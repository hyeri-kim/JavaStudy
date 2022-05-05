## Method

> **메서드 형태**
> 
- 이름() ⇒ `print()`
- 단, 키워드()는 메서드가 아니다. ⇒ `if()`, `for()`

> f(x) = 2x + 1  (단, x는 정수)
> 
- f : 메서드 이름
- (x) : 매개변수
- 2x + 1 : 리턴값
- **f(1) 통째로를 리턴값으로 볼 줄 알아야 한다. (단, 리턴값이 있을 경우만)**

$**f$ 함수**

```java
int f(int x) {
	return 2*x + 1;
}
```

- x는 매개변수 : 외부에서 들어오는 값과 f라는 함수를 연결시켜주는 매개체 역할을 한다.

> **메서드의 선언**
> 
1. **기본형**

```java
리턴타입 메서드명(자료형 매개변수1, ...) {
	실행할 문장
	return 리턴값;
}
```

1. **리턴값 X**

```java
void 메서드명(자료형 매개변수1, ...) {
	실행할 문장
}
```

1. **매개변수 X** → 사용할 때 값을 전달하면 안됨.

```java
void 메서드명() {
	실행할 문장
}
```

> **메서드 선언 순서**
> 
1. 메서드 이름을 생각한다.
2. 매개변수를 생각한다.
3. 실행할 문장과 리턴값을 생각한다.

```java
int add(int num1, int num2) {
	System.out.println("덧셈 메서드입니다.");
	return num1 + num2;
}

int result = add(3, 7);
syso(result); //10
```

> **메서드 주의사항**
> 
- 매개변수가 없는 메서드는 외부에서 값을 전달 받을 수 없다.
- 리턴값이 있는 메서드는 사용 시 전체를 리탄값으로 보자.
- 메서드 내부에 다른 메서드를 선언할 수 없다. (단, 사용은 가능하다.)
- 메서드 선언 시 매개변수는 저장공간이고, 사용 시에는 값을 그 자리 순서에 맞게 넣어준다.

> **메서드 선언 연습**
> 
- main메서드는 static이라는 키워드가 붙어있기 때문에 메모리에 제일 먼저 올라가서 자동으로 실행이 된다.
- 그렇기 때문에 그 외의 함수들은 알지 못하므로
- 바로 사용하고 싶으면 같이 static을 붙여주거나 `static int add(int num1, int num2) {}`
- 혹은 그 메서드의 소속을 알려 줌으로써 `MethodTest m = new MethodTest();`
- 메인 메서드에서 이 함수들을 실행할 수 있게끔 해준다.

```java
public class MethodTest {
	
	int add(int num1, int num2) {
		System.out.println("add 메서드입니다.");
		return num1 + num2; // 리턴값이 정수
	}
	
	public static void main(String[] args) {
		// 컴파일 하자마자 자동으로 실행되는 메서드가 main메서드(static), public->접근권한제어자
//	System.out.println(add(3, 7));
		MethodTest m = new MethodTest(); // class 선언해서 이 클래스 안에 add가 있다는 걸 알려줌
		System.out.println(m.add(3, 7)); // 이 통째로를 return값으로 봐야 함.
	}
}
```

> **메서드를 사용하는 이유**
> 
1. 반복되는 기능들을 쉽게 관리하기 위해 → 메서드에는 특정성을 부여하면 안된다.
2. 코드를 줄이기 위해 → (특정성을 부여해도 상관없음)
