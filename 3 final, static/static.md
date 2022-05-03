## **static**

클래스(정적) 멤버를 설정하는 키워드이다.

- Java는 JVM에 의해 실행될 때 클래스로딩을 하는데 이때 클래스의 모든 멤버와 정보가 JVM의 class영역에 올라가게 되므로 static을 사용한 모든 멤버는 별도의 객체(인스턴스)의 생성 없이 사용 가능하다.
    - 컴파일을 하게 되면 가장 먼저 메모리에 올라가고,
    - 어떠한 경우에도 초기화가 되지 않는다. (항상 메모리에 상주해 있음)
    - 단, 프로그램이 종료 시 메모리에서 해제 된다.
    - 메모리에 고정되기 때문에 남용 시에는 메모리 혹은 프로그램 실행 속도에 악영향을 준다.
- static 메소드가 아닌 곳에서는 static 요소들에 언제든 객체 생성 없이도 접근할 수 있다.
- static 내부에서는 static이 아닌 외부에 접근할 수 없다.
- 즉, static 메서드 안에서 외부에 접근하려는 요소(field, method)들은 모두 static이어야 한다.

⇒ static은 여러번 참조해야하는 상수나 유틸리티 같은 경우에만 선언하는 것이 좋다.

> **static 사용 예시**
> 

```java
public class Main {
  static int testVal=1; //static 변수
  int val=3; //인스턴스변수

  public static void testStatic(){ //static 메서드
    System.out.println("test");
  }
  
  public static void main(String[] args){
    //System.out.println(val); static 메서드안에서는 외부의 static 멤버에만 접근이 가능하다. 
    System.out.println(testVal);
    System.out.println(Test.a);
    Test.print();
    testStatic(); 
//////////////////////////////////////
    Test test1=new Test();
    System.out.println(test1.b);
    Test test2=new Test();
    System.out.println(test2.b);
    Test test3=new Test();
    System.out.println(test3.a);
    System.out.println(test3.b);
  }
}
///////////////////////////////////////
class Test{
  static int a=0;
  int b=0;

  Test(){
   a++;
   b++;
  }
  static void print(){
    System.out.println("static 메소드 입니다.");
  }
}
```

- 위 예를 보면 Test 클래스에 있는 변수 a와 print 메서드를 static 키워드를 붙여 선언하였다.
- 따라서 Main 클래스에서 test클래스의 변수 a와 print 메서드는 객체 생성없이도 접근이 가능하다.
- 하지만 static 메소드인 main 함수 안에서는 밖에 선언되어 있는 val 변수를 사용할 수 없다. static 메서드 안에서는 static이 아닌 외부에 접근이 불가능 하기 때문이다.
- 반면 그 아래의 Main클래스의 static 변수인 testVal, static 메서드인 testStatic, Test클래스의 static 변수인 a, static 메서드인 print는 오류없이 정상적으로 접근가능하다.
- 또한 주석아래 Test객체를 3개를 생성하면서 생성자로 static변수 a와 인스턴스 변수 b를 1씩 증가를 시켜주고 있다.
- 결과를 확인해보면 Test객체 생성 후 각각 출력한 b의 값은 모두 1이고 a는 3인것을 확인할 수 있다.
- 그 이유는 static 변수 a는 객체를 생성하기 전부터 0을 가지고 있다가 객체 생성자에 의해 1씩 3번 증가가 되었고 인스턴스 변수인 b는 각 인스턴스가 생성될때 0으로 초기화 됐다가 생성자에 의해 1씩 증가하였기 때문이다.

한 클래스의 static 변수는 Class영역에 저장되어 있어 어떤 인스턴스든 모두 똑같은 값을 가진다!
