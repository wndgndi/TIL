## DI(Dependency Injection) : 의존관계, 의존성 주입

-  애플리케이션 실행 시점에 실제 생선된 객체 인스턴스의 참조가 연결되는 것을 의존관계 주입이라고 한다.

<br>

-  스프링은 DI로 다형성 + OCP, DIP를 가능하게 지원 (DI 컨테이너 제공)

<br>

-  클라이언트 코드의 변경 없이 기능 확장

<br>

-  쉽게 부품을 교체하듯이 개발

<br>

-  의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 인스턴스를 변경할 수 있다.

<br>

-  의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다. 

​

*예) 의존관계 코드를 손대지 않고  구현코드만 설정해서 동적인 연결을 구현*

<br>

```
Ex:

눈길에 가야할 일이 생겼을때, 자동차의 일반타이어를 스노우타이어로 교체하여 
눈길을 무사히 갈수 있게 된다면 스노우타이어만의 교체로 인해 눈길을 갈 수 있게 문제가 해결된다.
```

---

## 제어의 역전 IoC (Inversion of Control)

<br>

구현 객체가 프로그램의 제어 흐름을 스스로 컨트롤하는 것은 개발자 입장에서는 당연한 자연스러운 흐름이지만 외부에서 관리하는 것을 제어의 역전이라고 한다.
프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞지만 내가 작성한 
코드가 직접 제어의 흐름을 담당하면 그것은 라이브러리이다.



**한마디로, 스프링 프레임워크가 프로그램을 제어하는 것을 제어의 역전이라 한다.**
스프링에서 개발자의 편의를 위해 제공되는 프로그램의 역할을 말하는 거라 생각면 된다.

<br>

---

## 컨테이너 Container

<br>

IoC or DI 컨테이너 - 의존관계 주입을 대신 객체를 생성하고 관리하면서 의존관계를 연결해주는 것이다.
(최근에는 IoC가 아닌 DI컨테이너 용어를 자주 사용한다. 또는 어샘블러, 오브젝트 팩토리 등으로 부르기도 한다.)

 
**@Configuration :** 구성정보를 담당하는것을 설정할때 @Configuration 을 붙여준다. <br>
**@Bean :** 각 메서드에 @Bean을 붙이면 스프링 컨테이너에 자동으로 등록이 된다.<br>

ApplicationContext (스프링 컨테이너) :
스프링 컨테이너는 @Configuration이 붙은  클래스를 설정 정보로 사용한다.
여기서 @Bean이 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
**이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라고 한다.**
스프링 빈은 applicationContext.getBean() 메서드를 사용해서 찾을 수 있다.

<Br>

![context](https://blog.kakaocdn.net/dn/Xkij6/btrnqlgALm0/d09uwEjZT2dqU2jRL2Vcl0/img.png)

<br>

---

## 스프링 컨테이너란

 

**ApplicationContext를 스프링 컨테이너라고 한다.** <br>

ApplicationContext는 인터페이스이다.
(구현할때는 new AnnotationConfigApplicationContext(클래스이름.class) 를 사용한다.) <br>

스프링 컨테이너는 XML을 기반으로 만들 수 있고,​ Annotation 기반의 자바 설정 클래스로 만들 수 있다.
(편리함으로 보통 자바 기반으로 설정된다.)

 

스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다.
예) new AnnotationConfigApplicationContext(스프링.class) 이라 하면 스프링에 있는 @Bean의 메서드를 등록한다. <br>


스프링 빈 조회에서 상속관계가 있을 시에, 부모타입으로 조회하면, 자식 타입도 함께 조회한다.
그래서 모든 자바 객체의 최고 부모인 object타입으로 조회하면 모든 스프링 빈을 조회한다.
예) getBean(스프링.class)

---

## BeanFactory vs ApplicationContext

```
BeanFactory   <   ApplicationContext   <   AnnotationConfig ApplicationContext
```
<br>

### [ BeanFactory ]

스프링 컨테이너의 최상위 인터페이스이다.
스프링 빈을 관리하고 조회하는 역할을 담당한다.

<Br>

### [ ApplicationContext ]

BeanFactory 기능을 모두 상속받아서 제공한다.
빈을 관리하고 검색하는 기능을 BeanFactory가 제공해주지만 이외에 부가기능을 제공한다. <br>

**- MessageSource :** 메세지소스를 활용한 국제화 기능 (한국어,영어 등)

**- EnvironmentCapable :** 환경변수 (로컬,개발,운영등을 구분해서 처리)

**- ApplicationEventPublisher :** 이벤트를 발행하고 구독하는 모델을 편리하게 지원

**- ResourceLoader :** 파일, 클래스패스, 외부 등 리소스를 편리하게 조회

 

​

### [ 정리 ]

-  ApplicationContext는 BeanFactory의 기능을 상속 받는다.

-  ApplicationContext는 빈 관리기능 + 편리한 부가 기능을 제공한다.

-  BeanFactory를 직접 사용하는 일은 거의 없으며, 부가기능이 포함된 ApplicationContext를 사용한다.

-  BeanFactory나 ApplicationContext를 스프링 컨테이너라고 한다.