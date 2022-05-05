> **super란?**
> 
- 자식 클래스에서 상속받은 부모 클래스의 멤버변수를 참조할 때 사용한다.

> **super()란?**
> 

자식 클래스가 상속받은 부모의 생성자를 호출하는 메소드이다.

(기본적으로 자식 클래스의 생성자에 추가된다.)

- 자식 클래스는 부모 클래스를 상속받았기 때문에 자유롭게 부모의 모든 프로퍼티를 사용할 수 있다.
- 하지만 그럼에도 자식클래스가 부모클래스의 프로퍼티와 동일한 이름을 갖고 있다면 그것을 부모로부터 구분해 낼 수 있어야 한다.

> **사용 예제**
> 

```java
class Object{
	int a;
}
    
class A extends Object{
	int a;
}
    
public static void main(String args[]){
	A ins = new A();
	ins.a=2 // 여기서 a는 A의 a. 즉, 자식의 변수이다
	// 만약 자식에게 a라는 변수가 없었다면 부모의 a를 가리켰을 것이다.
	// 여기서 자식 a가 아닌 부모의 a로 접근하고 싶다면?
        
	ins.super.a = 20; // 이렇게 super라는 참조 변수를 사용해서 부모의 a에 접근할 수 있다
}
// 위와 같은 이유로 자바에서는 다중 상속이 불가능하다 (상속의 모호성)
```

```java
class Parent {
	int a = 10;
}

class Child extends Parent {
	int a = 20;
        
	void display() {
		System.out.println(a);
		System.out.println(this.a);
		System.out.println(super.a);
	}
}

public class Inheritance03 {
	public static void main(String[] args) {
		Child ch = new Child();
		ch.display();
	}
}
```

- 자식 클래스가 인스턴스를 생성하면, 인스턴스 안에는 자식 클래스의 고유 멤버 뿐만 아니라 부모 클래스의 모든 멤버까지 포함되어있다.
- 하지만 상속에서의 생성자는 상속되지 않는 유일한 멤버함수이다.
- 따라서 부모 클래스의 멤버를 초기화하기 위해서는 부모 클래스의 생성자를 호출해야 한다.
- 즉, **자식 클래스 생성자를 호출할 때 부모 클래스 생성자도 동시에 호출**해야 한다. (정확히 말하면 부모 생성자가 먼저 실행됨)
- → 자바 컴파일러가 자동으로 super() 메소드를 추가해준다.
    - 컴파일러가 항상 super()를 추가해 주는 것은 아니다.
    - 부모 클래스에 기본 생성자가 아닌 매개변수를 가지는 생성자가 있다면(=부모 클래스에서 생성자가 오버로딩되면) 자동으로 추가되지 않는다.
        
        ```java
        class Parent{
        	int a;
        	Parent(int n){a = n;};
        }
        ```
        
    - 자식클래스에서 기본 생성자를 호출할 때 부모 클래스의 생성자에 기본 생성자가 없으면 오류가 발생한다.
        
        ```java
        // 오류코드
        class Parent{
        	int a;
        	Parent(int n){a = n;};
        }
        class Child extends Parent(){
        	int b;
        	Child(){
        		super();
        		b = 20;
        	}
        }
        ```
        
        **→ 해결방법?**
        
        1. 부모 클래스에 기본 생성자를 선언한다.
            
            `Parent(){a=10;};`
            
        2. 오버로딩된 생성자에 맞춰 super()의 인자를 맞춰준다.
            
            ```java
            class Child extends Parent(){
            	int b;
            	Child(){
            		super(40);
            		b = 20;
            	}
            }
            ```
