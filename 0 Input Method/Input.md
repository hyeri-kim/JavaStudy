# 입력

- 입력상태 : 커서가 깜빡이고 있는 상태
- 입력하기 전에 무엇을 입력해야 할 지 사용자에게 알려줘야 함

/***출력함수와 입력함수는 개발자를 위한 도구*/**

> **입력 메서드**
> 

이름 뒤에 소괄호() 있으면 메서드

- `next()` : 공백을 구분점으로 판단해서, 각각의 **문자열**을 입력받음
- `nextLine()` : 공백까지도 한 줄로 판단해서, **한 줄**을 그대로 입력받음
- `nextInt()` : **정수**를 입력받음
- `nextDouble()` : **실수**를 입력받음

```java
package day04;

import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		String name = "";
		String lastName = "";
		Scanner sc = new Scanner(System.in);
		// 마침표(.) : 하위연산자 (e.g.  A.b : A안에 b)
		System.out.println("이름이 뭐니?");
		name = sc.nextLine(); // nextLine()은 공백까지도 변수에 담음
//		name = sc.next(); // sc.next() == 내가 입력한 문자열 값. next()는 공백을 만나는 순간 거기까지만 담긴다.
//		lastName = sc.next();
		System.out.println(name);
//		System.out.println(lastName);
	}
}
```

**`sc.next()`** : 내가 입력한 **문자열 '값'** → name 변수에 담음('값'이니까 저장공간에 담아줘야 함)

> **입력 메서드 연습1**
> 

```java
package day04;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		
		int num1 = 0, num2 = 0;
		
		Scanner sc = new Scanner(System.in); // sc는 변수(저장공간).
		// 입력이니까 System.**in**

		System.out.print("첫 번째 정수를 입력하세요: ");
		num1 = sc.nextInt();
		System.out.print("두 번째 정수를 입력하세요: ");
		num2 = sc.nextInt();
		
		System.out.println("첫 번째 정수: " + num1);
		System.out.println("두 번째 정수: " + num2);
		System.out.println(num1 + num2);
	}
}
```

```java
package day04;

import java.util.Scanner;
/*
 *  next()를 사용해서 동시에 2개의 값을 입력받고
 *  두 값을 더한 결과 값을 출력하기
 */
public class InputTask {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 2개를 차례로 입력하세요.\n예)1 2");

		num1 = Integer.parseInt(sc.next()); // 문자열 형변환
		num2 = Integer.parseInt(sc.next());
		
		System.out.println("결과 값 : " + (num1 + num2));
	}
}
```

**`sc.next()` ← 이걸 통째로 '값'으로 볼 줄 알아야 함 (내가 입력한 '값')**

> **입력메서드 연습2**
> 

```java
package day04;

import java.util.Scanner;

public class InputTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요");
		sc.nextInt();
		System.out.println("이름을 입력하세요");
//		sc.nextLine(); // 그 전에 입력한 엔터를 먹음
		sc.next();
	}
}
```

**`sc.nextLine()`**

- 공백이든 문자든 문자가 하나라도 있으면 다 담는다.
    
    (So, 그 전에 입력한 엔터를 먹음)
    
- `nextLine()`을 사용하려면 `sc.nextLine();`을 두 번 써줘야 한다.
    
    (첫번째 입력한 `nextLine()`은 엔터를 먹음)
