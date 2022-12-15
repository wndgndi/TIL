readLine() 을 들어가 보았다.

![readLine](https://blog.kakaocdn.net/dn/9w1xj/btqEW4Khtqz/CGQ5C4yuueLBu7fSdKuOQ0/img.png)

<br>

일단 리턴타입이 boolean 이다.

synchronized(lock)  은 쉽게 동시에 호출되는것을 막아주는 메서드인데, lock을 걸고 한번에 한 사용자만 readLine 메서드에 접근해서 InputStreamReader가 열렸는지를 확인받는다.   


그래서 synchronized 가 호출하고있는 ensureOpen() 메서드를 까보았다.
<br>

![ensureOpen](https://blog.kakaocdn.net/dn/ccTYOA/btqEVXSy1oc/JHi45kjx0l9wy95QTG0hB0/img.png)

<br>

in == null 이면 IOException 을 던지는 구조이다.

in이 null이라는건 Reader(여기서는 키보드와의 connection) 가 프로그램에 인식되지 않는다는 의미이고, 이때 예외처리를 던진다.
자원이 없는데 강제로 read 시키면 프로그램 장애를 유발하는데, 미리 예외처리를 해서 막는것이다.
키보드 입력이 null 이라는게 접근 객체가 없다는 의미라고 생각했는데, 그건 inputstream=0 인것이고 inputstream=null 은 아예 자원이 인식이 되지 않는것을 의미했다.

혼자 개발할 때는 없는 일이지만, 실서비스로 넘어가면 종종 생기는 예외라고한다.


<br>

#### 결론 : readLine() 에서 throwsException 하는 이유는 InputStream==null 일때의 장애를 대비해서 미리 예외처리를 해줘야했던것.

​