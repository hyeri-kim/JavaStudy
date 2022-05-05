## 예외처리
- 에러 : 심각한 오류
- 예외 : 덜 심각한 오류

> **구조**
> 

(1)

```java
try{
	오류가 날 수도 있는 문장
}catch(예외이름 객체명){
	오류 발생시 실행할 문장
}
```

(2)

```java
try{
	오류가 날 수도 있는 문장
}catch(예외이름1 객체명1){
	오류 발생시 실행할 문장
}catch(예외이름2 객체명2){
	오류 발생시 실행할 문장
}
```

(3)

```java
try{
	시도할 문장
}catch(예외이름 객체명){
	오류 발생시 실행할 문장
}finally{
	예외발생 여부에 상관없이 무조건 실행할 문장
}
```

(4)

```java
try{
	시도할 문장
}catch(예외이름1 | 예외이름2 객체명){
	둘 중 하나라도 발생시 실행할 문장
}
```

> **사용 예제1**
> 

```java
public class Try {
	public static void main(String[] args) {
		// Alt + Shift + Z
		try {
			System.out.println(10/0); // 이 문장이 오류가 나면,
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다."); // 이게 실행됨
			System.out.println(e.getMessage()); // 어떤 오류 메세지인지 알려줌(String 타입)
			e.printStackTrace(); //오류 내용 알려줌
		}
		
		System.out.println("종료"); // 이 문장은 무조건 실행시키고 싶음
	}
}
```

> **사용 예제2**
> 

```java
public class Try2 {
	public static void main(String[] args) {
		int [] arData = new int[5];
		// 총 6번 반복됨(마지막 반복도 돌아봐야 오류인지 아닌지 알기 때문)
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			try {
				arData[i] = i+1;
			} catch (Exception e) {
				break;
			}
		}
		System.out.println("정상 종료");
	}
}
```
