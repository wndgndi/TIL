# 싱글톤 패턴(Singleton Pattern)이란

<br>

싱글톤 패턴이란 객체의 인스턴스가 1개만 생성되는 것을 보장하는 디자인 패턴이다. 
생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고 최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다. 

**이와 같은 디자인 유형을 싱글톤 패턴이라고 한다.**

→ 객체 인스턴스를 2개 이상 생성하지 못하도록 막아야 하고 private를 사용해서 외부에서 new 키워드를 사용해서 객체를 인스턴스 생성하는 것을 못하도록 막아야 한다.

---

## [ 웹 애플리케이션과 싱글톤 ]


웹 애플리케이션은 특정한 목적이 아닌 경우, 여러 고객이 동시에 서비스를 요청한다. (ex. 여러 사용자가 같은 페이지 동시 클릭)

  

만약 싱글톤 패턴이 아닌 고객의 요청마다 새로운 객체를 생성한다면,서버 자원의 소모가 매우 심할 것이다.

 
그렇기 때문에 웹 애플리케이션을 개발할 때,우리가 생성할 객체(ex.여러 사용자에게 공유되는 service 등)는 싱글톤 패턴을 적용하여 작성하여야 한다.

---

## 싱글톤 패턴 만드는 방법

```
package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 static으로 선언하면 클래스 레벨에 올라가기 때문에 딱 하나만 생성됨
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 SingletonService를 생성하지 못하게(위에서 자기 자신을 하나만 생성함)
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
```

<br>

1.  static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.

 <br>

2.  이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.

 <br>

3.  딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.



<br>

**이제 싱글톤 패턴을 사용하는 테스트 코드를 보자.**

```
package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
```

<Br>

위에서 생성한 singletonService 객체를 2개 생성하고 같은 객체를 반환하는지 확인해보자.


![singleton](https://blog.kakaocdn.net/dn/sg05e/btrrlS87JA4/bFR8GZcOhU2QgWPdBWZbzk/img.png)

호출할 때마다 같은 객체 인스턴스를 반환하는 것을 확인할 수 있다.

---

## [ 싱글톤 패턴의 문제점 ]

-  싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
<br>

-  의존 관계 클라이언트가 추상화 클래스에 의존하는 게 아니라 구체 클래스에 의존하게 되면서 객체지향 설계 5원칙인 SOLID 중 DLP를 위반하고 OCP원칙을 위반할 가능성이 높다.
​
-  내부 속성을 변경하고 초기화하는 게 어렵고 private 생성자로 자식 클래스를 만들기가 어렵다. 
이러한 문제점을 해결하기 위해서는 스프링 컨테이너를 사용한다.

​

​


## [ 스프링 컨테이너 ]

-  스프링 컨테이너는 싱글톤 패턴의 문제를 해결하면서 객체의 인스턴스를 싱글톤으로 관리한다.

<br>

-  스프링 빈이 싱글톤으로 관리되는 빈이다.

<Br>

-  싱글톤 패턴을 적용하지 않아도 객체 인스턴스를 싱글톤으로 관리한다.
​

-  스프링 컨테이너는 싱글톤 컨테이너 역할을 하고 이렇게 싱글톤 객체를 생성하고 관리하는 기능을 싱글톤 레지스트리라 한다.
*→ 스프링 컨테이너의 이런 기능 덕분에 싱글톤 패턴의 모든 단점을 해결하면서 객체를 싱글톤으로 유지할 수 있다.*

<br>

- 스프링의 기본 빈 등록은 싱글톤이다.


---
## [ 싱글톤 패턴 사용 시 주의할 점 및 알아야할 점 ]

-  객체 인스턴스를 2개 이상 생성하지 못하도록 막아야함

<br>​

-  Private 생성자를 사용해서 외부에서 임의로 new 키워드를 사용하지 못하도록 막아야함

<br>

-  스프링 컨테이너를 사용하면 컨테이너에 등록되는 빈들을 알아서 싱글톤으로 관리

<br>

-  하나의 인스턴스를 생성해서 공유하는 형식이므로 객체의 상태를 유지하게 설계하면 안됨

<br>

-  가급적 읽기만 가능해야함

<br>

-  특정 클라이언트에 의존적이거나 값을 변경할 수 있는 필드가 있으면 안됨

<br>

-  필드 대신 공유되지 않는 지역변수, 파라미터, ThreadLocal 을 쓰자

<br>

-  무상태로 설계를 해야 한다.

---

## [ 상태 유지 설계 코드 ]

```
public class Stateful {
    private String name;

    String studentAddress(String name, String address) {
        System.out.println(name + "학생의 주소는 " + address);
        this.name = name;
        return name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        //스프링 컨테이너에 설정 정보에 등록된 빈을 등록
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Test.class);

        // ac.getBean을 하여 스프링 컨테이너에 등록된 빈을 반환
        Stateful stateful1 = ac.getBean(Stateful.class);

        Stateful stateful2 = ac.getBean(Stateful.class);

        stateful1.studentAddress("hoestory","대한민국");

        stateful2.studentAddress("hoe", "미국");

        System.out.println("stateful1.getName = " + stateful1.getName());
        // stateful1.getName = hoe

    }

    static class Test {

        @Bean
        public Stateful    stateful() {
            return new Stateful();
        }

    }
}
```
결과값은 "hoestory"가 나와야 되는데 "hoe"가 나올 것이다.
이유는 상태가 유지된 상태 stateful2.studentAddress("hoe", "미국"); 을 하여 name 부분에 "hoestory"에서 "hoe"로 변경되었기 때문이다. 

이렇게 되는 이유는 스프링 컨테이너에 빈으로 등록된 stateful 빈이 객체의 인스턴스를 한 번만 생성하기 때문에 stateful1과 stateful2는 같은 인스턴스이다.

​

​​

## [ 무상태 설계 ]


특정 클라이언트에 의존적인 필드가 있으면 안된다.
특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
필드 대신 자바에서 공유되지 않는 지역변수 파라미터 등을 사용해야 한다.

```
public class Stateful {
   
    String studentAddress(String name, String address) {
        System.out.println(name + "학생의 주소는 " + address);
       
        return name;
    }

    public static void main(String[] args) {

        //스프링 컨테이너에 설정 정보에 등록된 빈을 등록
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Test.class);

        // ac.getBean을 하여 스프링 컨테이너에 등록된 빈을 반환
        Stateful stateful1 = ac.getBean(Stateful.class);

        Stateful stateful2 = ac.getBean(Stateful.class);

        String student1 = stateful1.studentAddress("hoestory","대한민국");

        String student2 = stateful2.studentAddress("hoe", "미국");

        System.out.println("statefu1.getName() = " + student1);
        // stateful1.getName() = hoestory

    }

    static class Test {

        @Bean
        public Stateful    stateful() {
            return new Stateful();
        }
    }
}
```

결과값은 상태 유지 코드의 결과값과 달리 상태가 유지 안되어서 "hoestory"가 나올 것이다.