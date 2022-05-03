## for문

> **for문 구조**
> 

```java
// int i=0   i<10    i++
for(초기값; 조건식; 증감량) {
	반복할 문장
}
```

## while문

> **while문 구조**
> 

```java
while(조건식) { // 조건식이 참일 때 반복
	반복할 문장
}
```

> **무한루프**
> 

```java
while(true) {
	반복할 문장
}
```

## do-while문

> **do-while문 구조**
> 

```java
do{
	반복할 문장 // 무조건 실행
}while(조건식);
```

## continue / pass / break / return 차이

- ***continue***
    
    continue의 **아래 행을 수행하지 않고** 반복문의 **다음 턴**으로 넘어간다.
    
- ***pass***
    
    실행할 코드가 없음을 의미한다.
    
- ***break***
    
    해당 break를 감싼 **가장 작은 반복문**을 탈출한다. (반복문 종료)
    
- ***return***
    
    인수 없이 사용하면 **함수 실행을 종료**하고 **함수를 호출한 곳으로 돌아간다.**
