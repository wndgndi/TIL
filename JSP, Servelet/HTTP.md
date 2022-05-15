# HTTP란

## [ HTTP (HyperText Transfer Protocol) ]


- 인터넷에서 클라이언트와 서버가 데이터를 주고받을 수 있는 프로토콜(규칙)이다.
<br>
-   HTTP통신은 Connectionless와 Stateless 통신의 특징을 갖고 있어 초기에는 인터넷 통신에 가장 적합한 통신 구조로 인정 받았다
<br>

-  클라이언트(client)는 HTTP를 통해 데이터를 서버로 요청(Request)하는 요청자이며, 흔히 엣지, 크롬, FireFox 같은 웹 브라우저가 그 역할을 한다. 응용 프로그램에서는 Http요청을 위해 사용하는 라이브러리가 그 역할을 한다.
<br>



-  서버(Server)는 클라이언트가 요청한 데이터를 제공하는 제공자이며 이미지, HTML파일처럼 파일을 제공하는 서버, 요청 주소에 따라 다른 내용을 제공하는 API서버 등 다양하게 있다. HTTP통신에서는 서버가 제공하는 결과를 응답(Response)라고 한다.
<br>
-  80번 port 이용

<br>

```
비연결성 (Connectionless Protocol)

  HTTP는 한번의 요청에 대해 TCP통신을 설정한 후 한번의 요청에 대한 응답이 처리되면 

  바로 TCP연결을 끊어 버리는 형태의 통신으로 연속적인 통신에는 부적합 하지만,

  인터넷과 같이 다수의 사용자를 대상으로 한 Pull방식의 사용자가 필요한 문서 서비스를 

  전달 받는 구조에는 적합한 통신 구조였다.

​

​

무상태 (Stateless)

  한번의 요청에 대해 한 번의 응답으로 트랜잭션이 종료되므로 연속적인 작업 처리에 

  필요한 트랜잭션 상태 정보를 관리하기 위한 Overhead가 없다. 그러한 구조로 인해 

  현재는 CGI통신에 Overhead를 부여하고 클라이언트 세션관리에 문제가 발생하고 

  있다. 

  이는 각 명령이 이전의 명령과 무관하게 독립적으로 실행된다는 의미이다. 이것이 사용자의 입력값에 

  지능적으로 반응하는 웹 사이트를 구현하는 것이 어려운 이유이며, 이와 같은 HTTP의 단점으로 인해 자바, 

   자바스크립트, 쿠키 등이 등장했다.

  즉, 웹서버가 웹 클라이언트의 상태 정보를 유지하지 않는다.
  ```


---

## HTTP 메시지 구조

### [ HTTP Request 구조 ]
<br>

***HTTP Request 메시지는 크게 3부분으로 구성된다. RequestLine / Header / Body***
<br>
    

 **●  Request Line : GET/HTTP/1.1/**

       -  HTTP request의 첫 라인으로 이 부분도 3부분으로 구성되어 있다.  

       -  HTTP Method : GET/POST/PUT/DELETE  해당 request가 의도한 action을 정의하는 부분

       -  Requst target(요청 URL): ex)/login

       -  HTTP 버전

         
<br>


**●  Header**

       -  해당 request에 대한 추가 정보를 담고 있는 부분

       -  Key:Value 값으로 되어 있다.   ex)HOST:google.com

<Br>
<br>

```
Accept: */* 

Accept-Encoding: gzip, deflate 

Connection: keep-alive 

Content-Type: application/json 

Content-Length: 257 

Host: google.com 

User-Agent: HTTPie/0.9.3
```


<br>

 ●  Body

      -  해당 request의 실제 메세지/내용

      -  body가 없는 request도 많다. 

         ( Get Request들은 대부분 body가 없는 경우가 많다. )

​
### [ HTTP Reuqest Method / Get ] 

<br>

1. 입력 데이터를  URI에 덧붙여서 전송하므로 헤더에 바디가 없다.

2. 전송하는 자료량에 한계가 있다.

3. 주로 정보를 가져오기 위해 설계

4. 보안성이 Post 방식보다 약하다.

5. 주문,DB내용을 갱신하는 경우 GET방식은 위험

6. Get 명령을 이용한 요청 데이터.

    GET /examples/servlets/bitcamp?time=hour

​

​

### [ HTTP Request Method / Post ]

​

1. HTTP요청의 일부로 입력 데이터를 Encoding하여 입력 메시지 바디를 서버에  

    소켓 접속하여 스트림으로 전송 (GET방식 보다 보안우수)

2. 주로 정보를 올리기 위해 설계

3. Page가 BookMark,전자메일화 불가

4. 일부의 경우엔 Reload 불허(사용자 카드번호)

5. Client나 URL에 전혀 보이지 않는다.


---

### [ HTTP Response 구조 ]

​

***Response도 Request와 마찬가지로 크게 3부분으로 구성되어 있다.*** 

***Status(Response) Line / Header / Body***

​

**●  Status(Response) Line : HTTP/1.1 404 Not Found**

          -  Response의 상태를 간략하게 나타내주는 부분으로 3부분으로 구성되어 있다.

          -  HTTP 버전

          -  status code : 응답 상태를 나타내는 코드. 숫자로 되어 있는 코드. 404

          -  status text: 응답 상태를 간략하게 설명해주는 부분. Not Found

​

**●  Header**

         -  Response의 header와 동일하다.

         -  다만 response에서만 사용되는 header값들이 있다. ex User-Agent대신 Server헤더가 사용된다.

​

**●  ​Body**

         -  Response의 body와 일반적으로 동일하다.

         -  Request와 마찬가지로 모든 response가 body가 있지는 않다. 

             데이터를 전송할 필요가 없을 경우 body가 비어있게 된다.


---

## 자주 쓰이는 HTTP Methods

### GET

-  이름 그대로 어떠한 데이터를 서버로부터 받아(GET)올때 주로 사용하는 Method

-  데이터 생성/수정/삭제 없이 받아오기만 할때 사용됨

-  가장 간단하고 많이 사용되는 HTTP Method

-  언급한대로 주로 데이터를 받아올때 사용되기 때문에 request에 body를 안 보내는 경우가 많다.

​<br>

### POST

-  데이터를 생성/수정/삭제 할때 주로 사용되는 Method   

-  데이터를 생성 및 수정 할때 많이 사용하기 때문에 대부분의 경우 request body가 포함되서 보내진다.








