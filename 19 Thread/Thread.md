> **스레드란?**
> 

일반적인 자바 프로그램을 실행하면 작성한 코드가 위에서부터 아래로 순차적으로 실행된다. 이러한 흐름을 하나의 ‘스레드’라고 표현한다.

- 따라서 자바를 실행하면 “하나의 스레드가 실행되었다.”라고 표현할 수 있다.
- 그러나 대규모 프로그램의 경우 하나의 스레드로만 구현할 수 없는 경우가 많이 있다.
- 이 경우 다중스레드로 구현하면 각각의 스레드가 동시에 수행되면서 프로그램을 병렬처리할 수 있다.
    - 동작하고 있는 프로그램을 프로세스(Process)라고 한다. 보통 한 개의 프로세스는 한 가지의 일을 하지만, 쓰레드를 이용하면 한 프로세스 내에서 두 가지 또는 그 이상의 일을 **동시에** 할 수 있다.

## 1. 상속

> **스레드 기동**
> 

```java
public class Sample extemds Thread {
	public void run() { // Thread 를 상속하면 run 메서드를 구현해야 한다.
		System.out.println("thread run."); // 병렬처리 할 코드 구현
	}
	
	public static void main(String[] args) {
		Sample sample = new Sample();
		sample.start(); // start()로 쓰레드를 실행한다.
	}
}
```

- 스레드를 기동하기 위해서는 먼저 클래스 라이브러리의 Thread 클래스를 상속받아야 한다.
    
    ```java
    class Sample extemds Thread {
    	public void run() {
    		// 병렬처리 할 코드 구현
    	}
    }
    ```
    
    - Sample 클래스가 Thread 클래스를 상속받는다.
    - `run()` 안에 작성된 코드는 일반적인 흐름과 달리 병렬로 동작한다.
    - `run()` 메서드 = 시작점
- 이 클래스를 실행하기 위해서는 객체를 생성한 수 `start()` 메서드를 호출해야 한다.
    
    ```java
    public class ThreadTest {
    	public static void main(String[] args) {
    		Sample sample = new Sample(); // 객체 생성
    		sample.start(); // start() 메서드 호출
    	}
    }
    ```
    
    - Thread 클래스의 `run` 메서드를 구현하면 `sample.start()` 실행 시 sample객체의 `run` 메서드가 수행된다.
        
        Thread 클래스를 extends 했기 때문에 start 메서드 실행 시 run 메서드가 수행된다. Thread 클래스는 start 실행 시 run 메서드가 수행되도록 내부적으로 동작한다.
        

> **여러개의 스레드 기동**
> 
- 객체를 여러개 생성

```java
public class ThreadTest {
	public static void main(String[] args) {
		Sample sample = new Sample(); // 객체 생성
		sample.start(); // start() 메서드 호출

		Sample sample2 = new Sample();
		sample2.start();
	}
}
```

> **스레드 일시정지**
> 

CPU 이슈 방지

- Thread 클래스의 메서드인 `sleep()` 함수를 사용한다.
    - `sleep()` 함수는 ()안에 기입한 밀리단위 숫자만큼 대기한다. (1000 = 1s)
- **sleep 함수 사용** : try catch 문 안에 작성해야 한다.
    
    ```java
    class Sample extemds Thread {
    	public void run() {
    		// 병렬처리 할 코드 구현
    	
    		try {
    			sleep(1000); // 1초 대기
    		} catch (Exception e) {
    			e.printStackTrace();
    	}
    }
    ```
    

> **스레드 종료 대기**
> 
- 각각의 스레드는 전혀 다른 처리 흐름에서 동작하지만, 다른 스레드의 종료를 기다린 후 다시 동작하도록 하는 기능도 필요하다.
- 이런 경우 Thread 클래스의 메서드인 `join()` 함수를 사용한다.

```java
public class ThreadTest {
	public static void main(String[] args) {
		Sample sample = new Sample();
		sample.start();
		
		Sample sample2 = new Sample();
		try {
			sample.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sample2.start();
```

> **스레드 예제**
> 

```java
public class ThreadTest {
    static int num;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        thread1 th = new thread1(1, 1, 3);
        thread1 th2 = new thread1(2, 4, 6);
        thread1 th3 = new thread1(3, 7, 10);
        
        th.start();
        th2.start();
        th3.start();
        
        try {
            th.join();
            th2.join();
            th3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("더하기 작업이 완료되었습니다. 모든 수를 더한 값은 " + th.getAddNum() + " 입니다.");
    }
}
 
class thread1 extends Thread {
    
    static int all_add_num = 0;
    int add_num = 0;
    
    int thread_num = 0;
    int start = 0;
    int end = 0;
    
    thread1 ( int thread_num, int start, int end ) {
        this.thread_num = thread_num;
        this.start = start;
        this.end = end;
    }
    
    public void run () {        
        try {
            for ( int i = start ; i <= end ; i ++ ) {
                System.out.println ( "쓰레드 ID " + this.thread_num + " :: i 값 : " + i );
                add_num = add_num + i;
                sleep (1000);  // 1초 대기
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTPS (add_num);
    }
    
    public void setTPS ( int num ) {
        all_add_num = all_add_num + num;
    }
    
    public int getAddNum () {
        return all_add_num;
    }
}
```

## 2. Runnable

- 이미 클래스가 다른 클래스를 상속받고 있을 경우에 Runnable 인터페이스를  사용한다. (클래스는 2개의 클래스를 상속 받을 수 없기 때문)
- 즉, Thread 클래스를 사용하는 게 아닌 Runnable 인터페이스를 구현하는 것.

```java
public class ThreadTest {
    
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        thread1 runnable_th = new thread1();
        Thread th = new Thread(runnable_th);    // 클래스 객체 생성 후, 스레드 클래스에 생성한 객체를 등록해 주어야 한다.
        th.start();
    }
}
 
class thread1 implements Runnable {
    
    public void run () {        
        try {
                Thread.sleep (1000);  // 1초 대기 -> Runnable 로 구현한 경우 Thread 클래스를 명시해 주어야 한다.
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
}
```
