## 형변환

> **자동 형변환 (묵시적 형변환)**
> 
- 정수와 정수의 연산 → 정수
- 정수와 실수의 연산 → 정수가 실수로 바뀐다.
- 정수타입에 실수를 넣으면 → 정수로 바뀐다.
- 실수타입에 정수를 넣으면 → 실수로 바뀐다.

```java
// 자동 형변환
	System.out.println(11 / 9); // 1
	System.out.println(11 / 9.0); // 1.222222222222222**3**<-실수의 오류(무한소수)
```

> **강제 형변환 (명시적 형변환) = Casting**
> 

`(자료형)값` 값을 자료형으로 바꾼다.
```java
int a;
byte b;
b = (byte) a;
```
```java
// 강제 형변환(Casting)
	System.out.println((double) 11 / 9); // 11.0 / 9
	System.out.println((int) 8.43 + 2.59); // 8 + 2.59 = 10.59
	System.out.println((int) (8.43 + 2.59)); // (8.433 + 2.59) = 11.02 에서 소숫점 아래 버림 == 11 (형변환은 소괄호 안에 있는 연산기호부터 먼저 일어난다.)
	System.out.println((int) 8.43 + (int) 2.59); // = 10
```

> **문자열 형변환**
> 
- 문자열을 형변환 해 줄 때에는 ***parcing***을 해 준다.
    
    ```java
    String num = "0"
    num = Integer.parseInt(num)
    ```
    
- 정수를 문자열로 바꿔 줄 때에는 정수와 문자열을 ‘연결’만 시켜주면 된다.

```java
public class Casting {
	// 메인 메서드
	public static void main(String[] args) {

		String num1 = "1";
		String num2 = "2";
		int num3 = 3;

		// 문자열 형변환
		System.out.println(num1 + num2); // 문자열 + 문자열 = '연결'
//		System.out.println((int)num1 + (int)num2); // 일반타입은 일반타입끼리 형변환이 가능. But, String은 클래스타입이기 때문에 클래스타입으로 형변환이 가능.
		System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2)); // 클래스타입 형변환
		System.out.println("" + num3 + 9); //39   // 정수(num3)를 문자열로 바꿔줌->정수와 문자열 연결
	}
}
```
