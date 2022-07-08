# AOP란?(Aspect Oriented Programming)

Spring은 IoC, AOP, PSA의 3가지 개념을 제공한다.
AOP는 Aspect Oriented Programming의 약자로 '관점/측면/양상 지향적인 프로그래밍'이라는 의미이다.

관점 지향은 쉽게 말해 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화하겠다는 것이다. 여기서 모듈화란 어떤 공통된 로직이나 기능을 하나의 단위로 묶는 것을 말한다. 

AOP에서 각 관점을 기준으로 로직을 모듈화한다는 것은 코드들을 부분적으로 나누어서 모듈화하겠다는 의미이다. 이때, 소스 코드상에서 다른 부분에 계속 반복해서 쓰는 코드들을 발견할 수 있는 데 이것을 흩어진 관심사 (Crosscutting Concerns)라 부른다. 

<br>

![aop](https://postfiles.pstatic.net/MjAyMjA2MDhfMjIy/MDAxNjU0NjkxMjQ5Nzk3.n_32EEVXYIrqFeNsHtcWINd7fUlz6ni6EcKBb4eJtPcg.uX20r9rHIfJt-ahzAj1LbJpAxM-W1S2V671AE2_Txtsg.PNG.wndgndi/image.png?type=w773)

<Br>

**위와 같이 흩어진 관심사를 Aspect로 모듈화하고 핵심적인 비즈니스 로직에서 분리하여 재사용하겠다는 것이 AOP의 취지이다.**

---

​<br>

## AOP 주요 개념



**Aspect :**  위에서 설명한 흩어진 관심사를 모듈화 한 것. 하나의 모듈. Advice와 Point Cut이 들어간다.

**Target :**  Aspect를 적용하는 곳 *(주로 클래스나 메소드)*

**Advice :**  실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체이다


**JointPoint :**  Advice가 적용될 위치, 끼어들 수 있는 지점. 메서드 진입 지점, 생성자 호출 시점, 필드에서 값을 꺼내올 때 등 다양한 시점에 적용가능하다

**PointCut :**  JointPoint의 상세한 스펙을 정의한 것. 'A란 메서드의 진입 시점에 호출할 것'과 같이 더욱 구체적으로 Advice가 실행될 지점을 정할 수 있다

---

<br>

## 스프링 AOP 특징

​

-  프록시 패턴 기반의 AOP 구현체, 프록시 객체를 쓰는 이유는 접근 제어 및 부가기능을 추가하기 위해서임

<bre>

-  스프링 빈에만 AOP를 적용 가능

<bre>

-  모든 AOP 기능을 제공하는 것이 아닌 스프링 IoC와 연동하여 엔터프라이즈 애플리케이션에서 가장 흔한 문제 *(중복코드, 프록시 클래스 작성의 번거로움, 객체들 간 관계 복잡도 증가 ...)* 에 대한 해결책을 지원하는 것이 목적

---

<br>

## AOP 적용 방법

​

### ▶ 컴파일 타임에 적용

컴파일 시점(.java 파일을 .class 파일로 만들 때)에 바이트 코드를 조작하여 조작된(AOP가 적용된) 바이트코드를 생성.

​

### ▶ 로드 타임에 적용

순수하게 컴파일한 뒤, 클래스를 로딩하는 시점에 클래스 정보를 변경(Load Time Weaving, 로드타임 위빙).

​

### ▶ 런타임에 적용

스프링 AOP가 사용하는 방법. A 클래스 타입의 Bean을 만들 때 A 타입의 Proxy Bean을 만들어 Proxy Bean이 Aspect 코드를 추가하여 동작.

---

<br>

### 프록시 패턴

<br>

![proxy](https://yadon079.github.io/assets/img/study/aop02.png)

프록시 패턴에는 interface가 존재하고 Client는 이 interface 타입으로 Proxy 객체를 사용하게 된다.
Proxy 객체는 기존의 타겟 객체(Real Subject)를 참조하고 있다. Proxy 객체와 Real Subject의 타입은 같고, Proxy는 원래 해야 할 일을 가지고 있는 Real Subject를 감싸서 Client의 요청을 처리한다.

​
**왜? 이렇게 해서 패턴을 사용하는 걸까?**
→ 그 이유는 기존 코드의 변경 없이 접근 제어 또는 부가 기능 추가를 위해서다.