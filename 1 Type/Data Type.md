# 자료형

<aside>
🔸 자료형의 종류와 특징

</aside>

**Intro.**

- 상수(Constant) : 항상 일정한 값을 유지하는 데이터
- 변수(Variable) : 값을 담기 위한 저장 공간
- 자료형(Data Type) : 데이터의 형태

## **기본 자료형 Primitive Type**

- 기본 자료형은 반드시 사용하기 전에 선언이 되어야 한다.
- OS에 따라 자료형의 길이가 변하지 않는다.
- 객체가 아니기 때문에 null을 가질 수 없다.

> **종류**
> 
- 논리형 : boolean(1byte)
- 문자형 : char(2byte)
- 정수형 : byte / short(2byte) / int(4byte) / long(8byte)
- 실수형 : float(4byte) / double(8byte)

> **BigInteger**
> 

`long`타입을 사용한다면 가장 큰값은 `9223372036854775807`이다. 이보다 정말 큰 숫자가 필요하다면 BigInteger를 사용해야 된다.

- 일반적인 operator 연산자는 사용할 수 없다.
- `.add()`, `.subtract()`, `.multiply()`, `.divide()` 메소드가 제공된다.
- 매개변수 또한 BigInteger를 받는다.

## **참조 자료형** **Reference Type**

기본 자료형을 제외한 모든 데이터 유형이다.

- `java.lang.Object`를 상속받는다.
- 참조형의 변수는 데이터를 그대로 저장하지 않고 데이터를 저장하는 메모리의 주소만 저장한다.

> **Class Type**
> 

기본형과 다르게 객체를 참조하는 형태이다.

- **String Class**
    - 기본형처럼 사용
    
    ```java
    String s = "string class"
    ```
    
    - 일반적으로 기본형 비교는 `==`연산자를 사용하지만, String 객체간의 비교는 `.equals()`메소드를 사용해야 한다.
- **Wrapper Class**
    
    기본형을 클래스로 감싼 형태이다.
    
    - 기본형을 객체가 아니기 때문에 `null`을 넣을 수 없지만, 기본형에 `null`을 넣고 싶다면 Wrapper Class를 활용하면 된다.
    - Wrapper Class는 내부에 멤버변수(기본자료형)가 `final` 선언이 되어 있다.
    - 기본형 > 대응래퍼클래스
        - byte > Byte
        - short > Short
        - int > Integer
        - long > Long
        - float > Float
        - double > Double
        - char > Char
        - boolean > Boolean
        - void > Void
    
    ```java
    public Class Wrapper_EX {
    	public static void main(String[] args) {
    		String str = "10";
    		int i = Integer.parseInt(str);
    	}
    }
    ```
    

> **Interface Type**
> 
- 인터페이스를 만들게 되면 새로운 참조 자료형을 만드는 것과 같다.
    
    → 기존에 있는 자료형의 이름도 만들 수 있다.
    
- 인터페이스도 자료형이기 때문에 자료형으로써 자신을 구현한 객체의 주소를 가질 수 있다.
- But, 인터페이스에 정의된 메소드만 사용할 수 있게 된다.

```java
interface MyInterface<T> {   // T는 제네릭 타입으로 옵션이다.
	void add(T value);
}
```

> **Array Type**
> 

배열형은 기본형으로도 만들 수 있고 참조형으로도 만들 수 있다.
```java
int[] num1 = new int[2];
Integer[] num2 = new Integer[3];
Object[][] obj = null; // 중첩 괄호 사용 -> 다중 배열로 사용 가능하다.
```
