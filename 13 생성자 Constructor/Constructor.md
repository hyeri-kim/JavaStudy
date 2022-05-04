`클래스명()`

- ‘초기화’의 목적이 있다.
- 메서드와 같은 기능을 가지고 있지만, 리턴이 없으며, 리턴타입도 없다.
- 따라서 메서드라고 부르지 않는다.
- 단축키 : Alt + Shift + S → O(Generate Constuctor using Fields...)
    - Select fields to initialize : 초기화 할 필드를 선택하세요.
- 생성자 안에서는 지역변수와 전역변수의 이름이 같을 때 **초기화**를 해 준다.
    - 전역변수 앞에 `this.`을 붙여준다. (구분해주기 위해)
    - 전역변수는 프로그램이 종료될 때 사라진다.

```java
Car(){} // 기본 생성자
	public Car(int price, String color, String brand) {
		this.price = price;
		this.color = color;
		this.brand = brand;
	}
```

- this.price == 그 객체의 price
- 그 객체의 price(this.price)에 외부에서 받아온 값(price)를 초기화 해 준다.
