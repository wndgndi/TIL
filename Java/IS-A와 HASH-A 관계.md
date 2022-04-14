상속관계 중 IS-A관계와 HAS-A관계가 있다.

# IS-A 관계 (상속 관계)
IS-A 관계(is a relationship, inheritance)는 일반적인 개념과 구체적인 개념의 관계이다.
```
- 사람은 동물이다.
- 소는 동물이다
- 새는 동물이다.
```
위와 같은 관계이다. 즉, 일반 클래스를 구체화 하는 상황에서 상속을 사용한다.

상속을 사용하면 많은 장점이 있지만, 하위 클래스가 상위 클래스에 종속되기 때문에 이질적인 클래스 간에 상속을 사용하지 않는 것이 좋다. 단순히 코드를 재사용할 목적으로 서로 관련이 없는 개념의 클래스를 상속 관계로 사용하는 것은 추천하지 않는다.

<br>

 -  부모클래스로 데이터형을 선언하고 자식클래스를 생성해서 할당 하는 것이다.

 -  부모클래스의 변수와 메소드만 호출 할 수 있다.

 -  원칙적으로 자식클래스의 변수와 메소드는 호출 할 수 없다.

 -  자식클래스에 부모클래스에게서 Override한 메소드가 있다면 그 메소드는 호출이 가능하다.

 -  class 뿐만 아니라 interface 등도 부모로 받을 수 있다.

<br>

### 부모클래스 객체명 = new 자식클래스();
 

 <br>

 ![is-a](https://blog.kakaocdn.net/dn/cuH6k7/btqFa7GmJK9/lcJYhIMQ9EFzeIbKE7fmW0/img.png)

<br>

![is-a2](https://mblogthumb-phinf.pstatic.net/20120509_48/lunatic918_1336538724212mOFQf_GIF/isa.gif?type=w2)

<br>

다음 상속관계를 살펴보자.
```
public class Human{

String name; // 이름
int age; // 나이
int sex; // 성별
}

public class Studentextends Human{

int number; // 학번
int major; // 전공

}
```
위의 상속 관계에서는 학생클래스가 사람클래스를 상속받고 있다.

"학생은 사람이다". 이러한 관계를 위처럼 표현했을 때 IS-A관계 라고 한다.

<br>

---

<br>

# HAS-A 관계 (포함관계)
HAS-A 관계에서는 상속을 사용하지 않는다.<br>
HAS-A 관계(has a relationship, association)는 일반적인 포함 개념의 관계이다. <br>
HAS-A 관계는 다른 클래스의 기능(변수 혹은 메서드)을 받아들여 사용한다.

​

 -  다른 객체를 받아들여서 그 객체의 기능을 사용하는 것이다. 

    (사람이 핸드폰을 사서 그 핸드폰의 기능을 사용하는 것)

 -  받아들인 객체의 자원(메소드/변수)을 사용할 수 있다.

-  어떤 클래스 A가 또 다른 클래스인 B가 가진 기능을 사용하고 싶을때 B 클래스를 포함하면 B 클래스의 기능을 사용할 수 있다.  

<br>

### A has a B (A는 B를 가지고 있다.)

<br>

![has-a](https://blog.kakaocdn.net/dn/xy28c/btqFa77tFXV/BEOrJ7TikSk3fAfpnEhUJK/img.png)

<br>

![has-a2](https://mblogthumb-phinf.pstatic.net/20120510_233/lunatic918_1336643902026zDbT0_GIF/hasa.gif?type=w2)

<br>

이어서 다음 상속관계를 살펴보자.
```
public class Gun{

String name; // 총 이름
int shot; // 총알 수

}

public class Police{

Gun gun; // 멤버객체로 총을 갖는다.

}
```

위와 같이 "경찰은 총을 가진다."의 구조로 경찰클래스안에 권총클래스의 객체를 멤버로 가지고 있는 경우를 HAS-A 관계라고 한다.

<br>

---
<br>

**상속을 코드 재사용의 개념으로 이해하면 안된다.** 

코드를 재사용할 수 있다고 마구잡이로 잘못 사용하는 경우가 있다. 상속을 사용하면 클래스간 결합도가 높아져 상위 클래스를 수정해야 할 때 하위 클래스에 미치는 영향이 매우 크다. 때문에 상속은 IS-A 관계에서 사용해야 한다.