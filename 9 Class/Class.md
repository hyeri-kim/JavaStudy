## 클래스

공통요소로 묶는 것!

> **클래스 선언**
> 

```java
class 클래스명{
	필드(변수, 메서드)
}
```

> **클래스 사용**
> 

```java
클래스명 객체명 = new 클래스명(); //메모리에 객체가 클래스명 타입으로 올라감.

객체명.필드;
```

- `클래스명` : 타입(type)
- `new` : heap 메모리 안에 무언가를 만든다는 연산자
- `클래스명()` : 생성자
    - 이 생성자가 객체를 생성해주고(실체화) 그 안에 있는 필드들은 heap 메모리 영역에 만들어준다.
    - 객체 안에는 그 필드들의 시작주소가 들어있다.
- `A.b`
- `.` : 하위 연산자

**요약**

- 객체명의 이름으로 저장공간이 만들어지고 그 안에는 주소값이 들어있다.
- 그 주소값은 heap 메모리 안에 들어가 있다. (그 주소값 == 필드의 주소값)

**⇒ 객체마다 주소가 다 다르다 !**
