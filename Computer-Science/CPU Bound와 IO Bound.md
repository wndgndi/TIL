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

<Br>

---

## CPU Bound


CPU Bound는 프로세스가 진행될 때, CPU 사용 기간이 I/O Wating 보다 많은 경우다. 주로 행렬 곱이나 고속 연산을 할 때 나타나며 CPU 성능에 의해 작업 속도가 결정된다.

<br>

![cpu bound](https://velog.velcdn.com/images%2Fcarrykim%2Fpost%2F5b267c31-7456-4590-9102-354d1f531ea9%2Fimage.png)

<Br>

---

## I/O Bound

​
반면 I/O Bound는 프로세스가 진행될 때, I/O Wating 시간이 많은 경우다. 
파일 쓰기, 디스크 작업, 네트워크 통신을 할 때 주로 나타나며 작업에 의한 병목 (*다른 시스템과 통신할 때 나타남*)에 의해 작업 속도가 결정된다.

<Br>

![I/O Bound](https://velog.velcdn.com/images%2Fcarrykim%2Fpost%2F14e0a97d-0df8-40f1-a345-e5a57605eef6%2Fimage.png)

<br>

---

## CPU 성능 향상에 따른 작업 처리 성능

<br>

CPU의 성능이 향상되거나 개수가 추가되면 CPU Bound의 작업 처리 성능이 향상된다. 따라서 성능 향상을 위해 scale-up이 주로 사용된다.

<br>

![cpu Bound](https://velog.velcdn.com/images%2Fcarrykim%2Fpost%2F81cc6ea4-b8ec-462a-a2cb-d98c02c6b5cd%2Fimage.png)

<br>
<br>

반면, I/O Bound의 경우에는 CPU 성능보다 타 시스템과의 병목 부분(I/O Wating)에 큰 영향을 받기 

때문에 스레드 개수를 늘리거나 동시성을 활용한다. 따라서 성능 향상을 위해 scale-out을 주로 사용한다.

<br>

![IOBound](https://velog.velcdn.com/images%2Fcarrykim%2Fpost%2F9865edd3-7b1f-474a-9656-3555be1e92d9%2Fimage.png)

<br>

---

## 병렬 프로그래밍 방법 선택

​

### [ Multiprocessing 방식 ]

multiprocessing 방식은 Multiple processes를 사용하며 고가용성(CPU) Utilization와 같은 

CPU-bound Application 처리에 적합하다.

***→ 10개의 부엌, 10명의 요리사, 10개의 요리***

​

### [ Multithreading ]

multithreading 방식은 Single(Multi) process, Multiple threads를 사용하며 I/O Bound 중에서 

빠르게 처리해야하는 Application에 적합하다.

***→ 1개의 부엌, 10명의 요리사, 10개의 요리***

​

### [ Async IO ]

Async IO는 Single process, single thread를 활용하며 I/O Bound 중 천천히 처리해도 괜찮은 Application에 적합하다.

***→ 1개의 부엌, 1명의 요리사, 10개의 요리***

<br>


