# Static이란 
<br>
Static 키워드를 통해 생성된 정적멤버들은 Heap영역이 아닌 Static영역에 할당된다. Static 영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있는 장점을 가지지만 Garbage Collector의 관리 영역 밖에 존재하기에 Static영역에 있는 멤버들은 프로그램의 종료시까지 메모리가 할당된 채로 존재하게 된다. 그렇기에 Static을 너무 남발하게 되면 만들고자 하는 시스템 성능에 악영향을 줄 수 있다.

<br>

![static](https://blog.kakaocdn.net/dn/b71AmB/btq6CBgiBUN/hzXWkLZnyXHYa5Qn66Rkok/img.png)

- static 키워드가 붙으면 객체에 포함되지 않는다.

- 멤버변수에만 붙일 수 있다. (로컬 변수에는 붙일 수 없다.)

​모든 객체가 같은 값을 가질 때, 메모리마다 값을 할당시키면 메모리가 아깝다.

모두 같은 값을 가지면 하나의 메모리에 할당시키고 모든 객체가 공유하게 한다.

    ex: 같은 학교를 다니는 학생들의 이름과 성적 등은 다르나 학교 이름은 같다.

    학교 이름을 statc 변수로 사용하면 효율적이다.

​
즉, static을 통해 메모리를 더욱 효율적으로 사용할 수 있다.

>객체 생성을 안한다 = 메모리를 덜 쓴다 = 속도가 빨라진다 = 성능 향상

<br>

---

## static 멤버 선언

<br>
필드나 메소드를 생성 시 인스턴스로 생성할것인지 정적(static)으로 생성할것인지에 대한 판단 기준은 공용으로 사용하느냐 아니냐로 내리면 된다. 그냥 생성한다면 자동으로 인스턴스로 생성되며 정적으로 생성하려면 필드와 메소드 선언 시 static이라는 키워들를 추가적으로 붙이면 된다. 

<br>

```
static int num = 0;    //타입 필드 = 초기값
public static void static_method(){}    //static 리턴 타입 메소드 {} 
``` 
<br>

---

## 정적(Static) 필드 사용 예시

```
class Number{
    static int num = 0; //클래스 필드
    int num2 = 0; //인스턴스 필드
}

public class Static_ex {
	
    public static void main(String[] args) {
    	Number number1 = new Number(); //첫번째 number
    	Number number2 = new Number(); //두번쨰 number
    	
    	number1.num++; //클래스 필드 num을 1증가시킴
    	number1.num2++; //인스턴스 필드 num을 1증가시킴
    	System.out.println(number2.num); //두번째 number의 클래스 필드 출력
    	System.out.println(number2.num2); //두번째 number의 인스턴스 필드 출력
    }
}
```

![result](https://blog.kakaocdn.net/dn/BpJ7O/btqDoUCBfyO/SEmGG8OPWKGcVvRbkzPIe0/img.png)

Number이라는 클래스 안에 클래스 변수 num과 인스턴스 변수 num2를 생성하였다. 

두 개의 Number  인스턴스 number1과 number2를 생성했을 때 number1에서 num과 num2를 각각 1씩 증가시키고, number2에서 num1와 num2를 각각 출력시켜보면 num1은 1, num2는 0이 출력되었다. 인스턴스 변수는 인스턴스가 생성될 때마다 생성되므로 인스턴스마다 각자 다른 메모리를 가지지만 static 변수는 모든 인스턴스가 하나의 저장 공간을 공유하기에 항상 같은 값을 가지기 때문이다.

​

즉, num은 모두 같은 메모리 공간을 공유하기에 number1.num++에서 증가시킨 1이 그대로 남아있으나,

number1,num++로 증가시킨 변수와 number2.num은 서로 다른 메모리를 사용한다.

<br>

---
## static 블록

<Br>

static 블록 영역은 main 메소드보다 먼저 실행되기 때문에 프로그램 실행 시 가장 먼저 실행되는 코드이다.

객체는 여러 개를 생성하지만, 한 번만 호출되어야 하는 코드가 있다면 "static 블록"을 사용하면 된다. static 블록은 다음과 같이 선언하여 사용한다.

```
static{
//딱 한번만 수행되는 코드
}
```

이 static 블록은 객체가 생성되기 전에 한 번만 호출되고, 그 이후에는 호출하려고 해도 호출할 수가 없다. 그리고, 클래스 내에 선언되어 있어야 하며, 메소드 내에서는 선언할 수 없다. 

즉, 인스턴스 변수나 클래스 변수와 같이 어떤 메소드나 생성자에 속해있으면 안된다.

​

static 블록은 여러 개를 선언할 수 있으며, 선언되어 있는 순서는 매우 중요하다. 왜냐하면, 선언된 순서대로 블록들이 차례대로 호출되기 때문이다.

이와 같은 static 블록은 클래스를 초기화할 때 꼭 수행되어야 하는 작업이 있을 경우 유용하게 사용할 수   있다.

​
추가로, static 블록 안에서는 static한 것들만 호출할 수 있다. static 클래스에서는 static하지 않은 변수나 메소드를 사용할 수 없다. 생성자는 static 키워드를 붙이지 않아도 된다. 생성자가 호출되기 전에 static    블록들이 먼저 호출된다. 또 static 블록들은 단지 한 번씩만 호출된다.

static 블록은 생성자가 불리지 않더라도, 클래스에 대한 참조가 발생하자마자 호출된다.