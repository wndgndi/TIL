CPU Bound 프로세스는 I/O보다 연산으로 이루어진 CPU Burst 가 큰 프로세스를 의미한다.
I/O Bound 프로세스는 I/O가 많은 즉, I/O Burst 가 큰 프로세스를 의미한다.


**`여기서 Bound를 ~위주의 라고 해석하면 쉽게 알아들을 수 있다.`**

 

I/O Bound 프로세스는 예를 들어 게임이 있다. *( 항상 사용자 입력을 필요로 하기 때문 )*

​
​

### CPU Burst 와 I/O Burst

- 실제 프로그램은 CPU 와 I/O 가 번갈아가면서 작업이 이루어지게 된다.

​

***CPU Burst 와 I/O Burst 는 각각이 실행되는 시간을 의미***

<br>

```
● CPU Burst

 :  CPU 명령을 실행하는 시간

​

● I/O Burst

 :  I/O 를 요청한 뒤 기다리는 시간
 ```