> ## 자바 코드의 기초
<br>

자바의 모든 프로그램은 public static void main (String[] args) 함수로 시작합니다.

왜 모든 코드는 위의 구문으로 실행이 되어야 할까요?   
이 의미를 파헤쳐 보도록 하겠습니다. ( 자바의 기초를 아시는 분들은 이해하기가 좀 더 쉬울 수 있습니다. )

<br>
<br>

>## 코드 파헤치기
<br>

### public
<Br>

제한자 부분으로, 모든 함수의 앞에는 이 함수를 어디에서 접근할 수 있는지 범위를 지정할 수 있습니다.

제한자는 public, private, protected 종류를 지정할 수 있지만 main 함수만은 public 을 지정해야 합니다.
<br>

![Error](https://blog.kakaocdn.net/dn/cgWfVF/btq1ataD62F/LeON4EqEdVmQbKE8yzoYfk/img.png)

<br>

왜그럴까요?

main 함수는 모든 실행프로그램의 기본이 되는 함수여야 합니다.

기본이 되는 함수이기 때문에 어디에서나 접근이 가능해야 합니다.


private 는 해당 클래스에서만 접근이 가능하고 protected 는 같은 패키지 내에서만 접근이 가능합니다.


main 함수의 제한자가 public 이 아니라면 main 함수에 접근하지 못하는 클래스가 있을 수 있고,
이런경우가 발생하면 안되기 때문에 public 으로 선언이 되어야 합니다.

<br>

|접근제한자|기능|
|---------|----|
|public|모든 곳에서 접근 가능|
|private|자기 자신 클래스에서만 접근 가능|
|protected| 자기 자신 클래스와 상송된 클래스에서 접근 가능|

<br>
<br>

### static

자바는 변수나 함수를 메모리에 할당하는 방법이 2가지가 있습니다.
첫번째는 static 영역에 선언하는 것이고, 다른 하나는 heap 영역에 선언(new 연산자)하는 것 입니다.

||static|heap|
|--|---|----|
|메모리 할당 기준| 프로그램 실행되는 순간| 연산이 실행되는 순간|
|메모리 정리 기준(Garbage Collector)| 정리 대상 아님| Garbage Collector에 의해 정리|

<br>


main 메소드가 heap 영역에 선언되면 어떻게 될까요?
위에서 말했듯이 main 메소드는 프로그램에 없어서는 안되는 기본 함수 입니다.


이 함수가 Garbage Collector 에 의해 메모리에서 정리되면 어떻게 될까요?
기본이 되는 함수가 정리되었으니 프로그램이 죽겠죠..


따라서 static 으로 선언하여 메모리에 항상 상주하도록 설정합니다.
만약 static 을 사용하지 않으면 아래와 같은 에러가 발생합니다.
<Br>

![error](https://blog.kakaocdn.net/dn/cMEYnD/btq1atBHPTh/7TnuYeRYrJ8IIinoBgcuqk/img.png)

<br>
<Br>

### void

<Br>

void 는 "함수가 끝날 때 리턴값이 없다" 라는 의미입니다.


일반 함수는 void 를 사용해도 되고 int, char 등 다른 타입을 사용해도 문제 없이 동작합니다.
그런데 왜 main 함수만 void 여야 할까요?


이유는 위에서도 말했지만 main 함수가 종료되면(혹은 비정상적으로 죽으면) 프로그램이 종료됩니다.
프로그램 자체가 종료되기 때문에, return 값의 의미를 지닐수가 없습니다.


반면, 일반함수의 경우 정상적 혹은 비정상적인 경우 리턴값을 변수에 담아 다음 단계를 진행할 수 있죠.
그래서 main 함수는 void 를 의무적으로 사용해야 하고 return 값을 가지기 위해 void 대신 다른 타입을 사용하는 경우 에러가 발생합니다.

![error](https://blog.kakaocdn.net/dn/t44q7/btq09zCrn1R/tK12DfcOkOVXSWPZZGLCn1/img.png)

<br>
<br>

### main

<br>

자바의 시작은 main 함수명으로 시작해야 합니다.
이는 규칙이기 때문에 설명을 하기가 애매하네요.

<Br>
<br>

### String[] args

<br>

args 문자열을 배열로 사용하겠다 라는 의미입니다.
args 는 변수명이기 때문에 꼭 args 가 아니어도 상관은 없으나, String[] args 구문 자체를 뺄 수는 없습니다.
<Br>

![error](https://blog.kakaocdn.net/dn/cERbWv/btq1g9ht2Us/vG4nKachEEj2nkJKNEvUQK/img.png)

<Br>

왜그럴까요?

모든 함수는 매개변수를 사용할수도 있고 않을수도 있습니다. 이는 main 함수도 마찬가지 입니다.
그러나 일반 함수는 메인함수 내부에서 호출하기 때문에 입력값을 적어도 main 함수 안에서 정할 수 있습니다.


그러나 main 함수는 프로그램 실행 시 처음으로 수행되는 함수이기 때문에, 외부로부터 값을 입력받을 수 있어야 합니다.
프로그램 내부에서 값을 호출할 수가 없으며, 이렇기 때문에 항상 문자열 인자를 받게됩니다.
외부로부터 값을 입력받는건 이런 의미입니다.

<br>

```
class Test {
  public static void main (String[] args) {
    System.out.println(args[0]);
 
    strMethod("def");
  }
  public static void strMethod(String srg) {
    System.out.println(srg);
  }
}
```
<br>

![result](https://blog.kakaocdn.net/dn/brVZXP/btq1e8DbejL/SskHEqydq5irkaomfV0OZk/img.png)