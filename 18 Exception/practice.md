```java
package day23;

public abstract class Lift { //추상클래스로 만든 이유? -> 층수는 내가 수정할 수 있어야 하기 때문에(인터페이스로 만들면 수정 불가능)
	
	static int floor = 0; // 지금 현재 층수 -> new 됐을때마다 초기화되면 안되고 프로그램이 종료됐을 때 초기화돼야 하기 때문에 static 변수로 사용
	
	abstract void up();
	abstract void down();
	abstract void start(int choice); // 내가 갈 층을 받아와야 함
	abstract void stop(); // 자동으로 멈춤
	abstract void go(); //탈지 말지
	
}
```

```java
package day23;

import java.util.Scanner;

public class Elevator extends Lift{
	// 값이 수정되면 안되니까 final로.
	final int maxFloor = 10; 
	final int minFloor = -3;
	
	@Override
	void up() {
		floor++;
	}

	@Override
	void down() {
		floor--;
	}

	@Override
	void start(int choice) {
		if(choice < floor) {
			for(int i = 0; i <= floor-choice+i; i++) { // floor-choice+i가 고정값이 됨 -> why? floor는 1씩 감소, i는 1씩 증가하니까 -> 반복횟수가 고정됨!
				if(floor!=0) {
					if(floor < 0) {
						int floorB = floor;
						floorB *= -1;
						System.out.println("지하"+floorB+"층");
					}else {
						System.out.println(floor+"층");
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {} // Thread.sleep()이 오류뜨는 이유? 기존의 컴파일러를 방해하고 있는 거기 때문에 오류가 뜸
				}
				down(); // 0층일때도 일단 무조건 down은 해야되니까 down()을 if문 밖으로 뺌 -> 0층일때 다운 안시키면 1층에서 항상 멈춰버림
			}
			stop(); // for문 탈출할 때 stop
		}else if(choice != floor) { // 내가 있는 층과 누른 층이 다를때
			for (int i = 0; i <= choice-floor+i; i++) {
				if(floor != 0) {
					if(floor < 0) {
						int floorB = floor;
						floorB *= -1;
						System.out.println("지하"+floorB+"층");
					}else {
						System.out.println(floor+"층");
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
				up();
			}
			stop();
		}else {
			System.out.println("같은 층 선택 불가");
		}
	}

	@Override
	void stop() {
		System.out.println("●도착●");
	}

	@Override
	void go() {
		int choice = 0;
		String msg = "";
		// go를 한번 쓸 경우를 대비해서 while문 안에 넣어줌
		while(true) { // 내가 층수를 잘 입력할 때까지 반복
			msg = "층수를 입력하세요(현재층 : "+floor+"층)"; // msg에 바뀐 floor값을 계속해서 넣어줌
			if(floor < 0) {
				int floorB = floor;
				floorB *= -1;
				System.out.println("층수를 입력하세요(현재층 : 지하"+floorB+"층)");
			}else {
				System.out.println(msg);
			}
			choice = new Scanner(System.in).nextInt();
			if(choice > maxFloor || choice < minFloor) {
				System.out.println("B3층부터 10층까지만 가능합니다.");
			}else {
				break;
			}
		}
		start(choice);
	}
	
}
```

```java
package day23;

import java.util.Random;
import java.util.Scanner;

public class Building {
	public static void main(String[] args) {
		Elevator e = new Elevator();
		Random r = new Random();
		int cnt = 0; //인원수
		int floor = 0; // 현재 층수
		String check = ""; // 인원 수 체크
		int [] arElevator = new int[5]; //엘레베이터 정원
		
		cnt = r.nextInt(6); // 인원수 랜덤
		for (int i = 0; i < cnt; i++) { // 처음 엘레베이터에 타고있는 인원
			arElevator[i] = 1;
		}
		
		while(true) { // 내가 있는 층수 랜덤
			// 최대 : 10층
			// 최소 : -3층
			// 0~13 - 3 => -3 ~ 10
			floor = r.nextInt(e.maxFloor+(e.minFloor*-1)+1) + e.minFloor; // 10+(-3*-1)+1+-3 => 14 -3 => (0~13 중에 랜덤) -3 ==> -3~10 중에 랜덤
			if(floor != 0) break; // 0층이면 계속 반복돌림
		}
		if(cnt == 0) {
			System.out.println("현재 탑승 인원 : 없음(최대5명)");
		}else {
			System.out.println("현재 탑승 인원 : "+cnt+"명(최대5명)");
		}
		System.out.println("Y : 타기            N : 보내기");
		check = new Scanner(System.in).next().toUpperCase(); // toUpperCase() : 내가 입력한 값을 대문자로 바꿔주는 메서드
		if(check.equals("Y")) {  //check.equals("Y") || check.equals("y") --> 이거 안써도 됨
			cnt++;
			try {
				arElevator[cnt-1] = 1;
				Elevator.floor = floor; // 현재 층수를 floor에 담아줌
				e.go();
			} catch (Exception e1) {
				System.out.println("정원이 초과되었습니다.");
			}
		}
	}
}
```
