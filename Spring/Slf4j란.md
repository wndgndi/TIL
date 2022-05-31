# Slf4j(Simple Logging Facade for Java) 란?

-  java.util.logging logback log4j 와 같은 다양한 로깅 프레임 워크에 대한 추상화 역할을 하는 라이브러리 이다.

-  추상 로깅 프레임워크 이기에 단독 사용은 하지 않는다.


-  compile 시 하나의 로깅 프레임워크와 바인딩 해준다.

<br>

## [ Slf4j 사용이유 ]

디버깅을 하면서 여러 이슈사항과 중요한 정보를 System.out.print() 구문을 익숙하게 사용해왔다.

하지만 이는 프로그램의 성능을 떨어트리고 로그를 파일에 저장하는 것이 불가능하다.

(운영시스템에서는 sysout 으로 로깅하지 않는다.)

이렇게 때문에 자바에서 지원하는 logging library 를 사용해서 로그를 관리한다.

​<Br>


## [ Slf4j 이점 ]

가장 큰 이점은 로깅 프레임워크를 라이브러리만 추가해서 바인딩 할 수 있습니다.
​
<br>
​
## [ 로그 레벨 ]

-  TRACE < DEBUG < INFO < WARN < ERROR

-  레벨에 따라서 로그 메세지가 달라진다.

-  TRACE: 추적 레벨은 DEBUG보다 좀 더 상세한 정보를 표시한다.

-  DEBUG: 프로그램을 디버깅하기 위한 정보를 표시한다.

-  INFO: 상태 변경과 같은 정보성 로그를 표시한다.

-  WARN: 처리 가능한 문제, 시스템 에러의 원인이 될 수 있는 경고성 메시지를 표시한다.

-  ERROR: 요청을 처리하는 중 오류가 발생한 경우를 표시한다.


<br>

## [ 기본적인 사용방법(application.yml 기준) ]

application.yml 파일에서 아래와 같이 작성

```

logging: 

      level: 

      root: error 

      #root: 전체 범위 레벨 설정가능 

      com.springboot.~ : error 

      #com.springboot.~: 패키지 별로 범위 설정가능
```

<br>

## [ 추가 사용방법 ]

-  기본적인 로깅사용법 외에도 규모가 커짐에따라서 xml파일을 세부적으로 설정해서 관리할 필요가 있다.

-  일반적으로는 src/main/resources 디렉토리 아래에 생성한 application.yml에서 지정한 yml파일을 작성한다.

-  Logger 객체를 사용하면 logger를 사용하고자하는 클래스에 설정을 할 수 있고, 간단하게 사용하고자 한다면 **@Slf4j 를 사용하면 된다.**

---

## [ loggin library 구현체 ]

### 1. log4j

-  기존에 표준으로 가장 많이 사용되던 라이브러리

-  2015년을 끝으로 개발 중단

​

### 2. logback

-  기존의 log4j 이후 같은 개발자가 개발하여 성능이 향상

-  Slf4j의 구현체로 spring boot에서 spring-boot-starter-logging 안에 기본적으로 포함되어 있어서 

    따로 dependency를 추가하지 않고 사용이 가능한 이점이 있다.

​

### 3. Slf4j

-  로깅을 간단하게 사용할 수 있도록 하는 Facade

-  로깅 라이브러리들을 하나의 통일된 방식으로 사용할 수 있는 방법이다.