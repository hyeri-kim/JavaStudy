### Casting (클래스형 변환)

> **up casting**
> 

부모 클래스 타입으로 자식 생성자를 호출하는 것.

- **부모클래스명 객체 = new 자식생성자();**
- 부모와 자식간의 공통 요소(재정의 메서드)만 사용 가능하며,
- 자식 클래스의 추가된 것들은 사용할 수 없다.
- 부모 타입으로 선언 되었기 때문에 부모의 필드만 사용 가능하지만,
- 자식 클래스에서 재정의 했다면, 재정의 된 메서드로 사용된다.

```java
Car noOptionFerrari = new SuperCar();
```

> **down casting**
> 

자식 클래스 타입으로 부모 생성자를 호출하는 오류

- 부모의 범위가 더 크기 때문에 자식에 담을 수 없다.

```java
// SuperCar brokenCar = new Car(); // 오류
SuperCar brokenCar = (SuperCar) new Car(); //강제 형변환
```
