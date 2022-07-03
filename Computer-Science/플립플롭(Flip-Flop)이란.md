# Flip-Flop이란?

플립플롭은 전원이 공급되고 있는 한, 상태의 변화를 위한 신호가 발생할 때까지 현재의 상태를 그대로 유지하는 논리회로 => 기억 기능을 가지고  있다.

한(1) 비트를 기억하는 메모리 소자이며 레지스터 구성회로로 널리 사용되고 있다.
플립플롭에 전류가 부가되면 현재의 반대 상태로 변하며 (0에서 1로 or 1에서 0으로), 그 상태를 계속 유지하므로 한 비트의 정보를 저장할 수 있는 능력을 가지고 있다.

​

여러개의 트랜지스터로 만들어지며, SRAM이나 하드웨어 레지스터 등을 구성하는데 사용한다.
종류는 RS플립플롭, D플립플롭, JK플립플롭, T플립플롭 등 여러 종류가 있다.

​

즉, 플립 플롭이란, 1bit를 기억할 수 있는 순서회로를 의미한다. 
또한 플립 플롭이 여러개 모여있는 장치가 레지스터다. 

​
![flpi](https://1.bp.blogspot.com/-pA_2kVX5CBI/XZsiYd5HDYI/AAAAAAAACa8/Gm72mfx9LoElAPqDU5Q7fBcOuJAXKsuRgCLcBGAsYHQ/s640/%25EC%25BA%25A1%25EC%25B2%2598.JPG)


#### [ 조합회로 ]

- 게이트로만 이루어진 논리회로

- 외부의 입력에 의해서만 출력이 발생하는 논리회로 

 

#### [ 순서회로 ]

- Flip-Flop과 게이트를 연결한 논리회로 

- 내부의 상태값에 따라 출력이 발생하는 논리회로

---
## Flip-Flop의 기본형태

​

### [ 1비트를 기억하는 기본적인 방법 ]
![1bit](https://blog.kakaocdn.net/dn/bKsj4L/btrbIHuOGAg/MzZsPZQMRmKdoxUz4oxZxk/img.jpg)

-  위의 회로는 loop(루프)를 도는 구조를 갖는다.   

-  무한히 순환하는 구조로 인하여 NOT과 NOT 사이에 1비트가 계속 살아있게 되는 구조다.   
-  즉, 1비트가 기억되는 것이다. 

<Br>

### [ Flip-Flop 회로도 ]

-  위에서 본 기본 형태를 기반으로 외부 입력에 따라 내부의 값이 변하는 회로로 확장시킨 것이 아래의 Flip-Flop 회로도다.   
![flip-flop](https://blog.kakaocdn.net/dn/FKFZZ/btrbvccB32z/Te1OVPxzWOnYuB2EXjSqv0/img.jpg)

-  당연한 이야기지만, Q와 Q바는 무조건 서로 반대되는 값을 가진다.    

-  CP는 Clock Pulse를 의미한다.   

-  CP는 컴퓨터 내부의 장치와 회로의 동작을 일정하게 유지 및 동기화 시키기 위해서 규칙적으로 발생하는 전기신호를 의미한다.  

<br>

### [ NAND 란 ]
![nand](https://blog.kakaocdn.net/dn/l2FUD/btrbIdtYxL9/YyMakMcHees4lXtU9kMwAK/img.jpg)

<br>

### [ RS Flip-Flop ]

- R과 S 값에 따라 Q의 상태에 변화한다.   

- 변화한 Q의 값에 따라 전기가 켜지고(1) 꺼지는(0) 결과가 정해진다.   

- 어떤 식으로 결과가 나오는지 예시를 살펴보자.    
---
<br>

## RS Flip-Flop 이해하기

​
### [ S = 0, R = 0, Q = 0인 경우 ]
![rs](https://blog.kakaocdn.net/dn/bg76um/btrbq4Z8WjU/VlVKLanTwaXNdYZZ6G2kT1/img.jpg)

- 위의 그림처럼, R과 S값을 기반으로 NAND 연산을 통해 다음 값을 구한다.   

- 현재의 Q와 Q바 값을 전달하여 최종적으로 현재 Q와 Q바의 변화된 값을 계산한다.   

- 위의 예시의 경우, Q와 Q바의 값이 그대로 유지되는 것을 확인할 수 있다.   

- Q와 Q바의 값이 서로 반대되어 있으므로, 유효한 값이라는 것 또한 알 수 있다.  

<br>

### [ RS Flip-Flop의 전체 경우의 수 ]
![rs2](https://blog.kakaocdn.net/dn/MGYaH/btrbyIaZ2sO/NwtqehioXWDvlApl1TZbW1/img.jpg)

<br>

### [ 결론 ]

- RS 플립플롭은 전기가 꺼져있을 때는 키고, 켜져있을 때는 끄는 두가지 기능을 갖는 논리회로다. 

---

## Flip-Flop의 종류

-  각 Flip-Flop은 각자의 기능을 가지고 있다. 그러므로 필요한 상황에 맞춰 사용한다.

<br>

### [ RS Flip-Flop ]
![flip](https://blog.kakaocdn.net/dn/ZNzKc/btrbyIa2dpY/p9FtzOk1AgYNmhpQNkU1r0/img.png)

<br>

### [ JK Flip-Flop ]
![jk](https://blog.kakaocdn.net/dn/cETY79/btrbq37V3PB/IMTzgFsetnb9dpRVzrdk71/img.png)

-  RS 플립플롭에서 S=1, R=1인 경우 불능 상태가 되는 것을 해결한 논리회로다.  

-  J는 S(set)에, K는 R(reset)에 대응하는 입력이다.  

-  J와 K의 입력이 동시에 1이 입력되면 플립플롭의 출력은 이전 출력의 보수 상태로 변화하게 된다.   

<br>

### [ D Flip-Flop ]
![D](https://blog.kakaocdn.net/dn/IBos0/btrbAJmO1vI/KNzxWTDK0lcOCiRJCXl0g1/img.png)

-  입력 단자 R과 S에 동시에 1이 입력되는 것을 회로적으로 차단한다.  

-  입력신호 D가 클럭펄스에 의해서 변화 없이 그대로 출력에 전달되는 특성을 가지고 있다.  

-  데이터(Data)를 전달하는 것과 지연(Delay)을 의미하는 D 플립플롭이라고 한다.  

<Br>

### [ T Flip-Flop ]
![T](https://blog.kakaocdn.net/dn/7rvoc/btrbuKfLFvW/hbGP4jwb3Jnx9412ahS9BK/img.png)

- JK 플립플롭의 J와 K 입력을 묶어서 하나의 입력신호 T로 동작시키는 플립플롭이다.  

- 입력이 0이 되면 이전상태(Q)의 값이 그대로 출력된다.  

- 입력이 1이 되면 이전상태(Q)의 보수 값이 출력된다.  