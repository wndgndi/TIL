## RAM Memory의 물리적 동작

Memory는 이렇게 생겼다.
![ram](https://postfiles.pstatic.net/MjAyMjA2MjRfMTMy/MDAxNjU2MDU0OTExOTk4.lxzQrVKv3op3s76XRwmEC4MC7ipSRnAJqP56nV8XqMgg.YXmUXUpehon4F0pbabp_hJEElNIPYP7KRqybhRIzVIAg.PNG.wndgndi/image.png?type=w773)

<br>

Address Pin과 Data pin으로 구성되어 있으며, 나머지는 RD (Read), WR (Write) pin으로 구성되어 

있다. 

RD는 Memory로부터 Data를 읽을 때, WR은 Memory에 Data를 Write할 때 사용하는 pin이고, **A[0]~ A[7]은 Address pin, D[0]~D[7]은 Data pin이다.** 


Address는 개수가 8개니까, 2^8 가지 *(각 pin 마다 0 아니면 1을 가질 수 있기 때문)* Address를 나타낼 수 있다. 0 ~ 2^8-1 주소만큼을 Memory가 처리할 수 있는 것이다. 
( 0x0~ 0xFF까지, 256 Byte만큼의 크기이다 )


메모리 마다 처리할 수 는 양에 따라 Address pin의 개수가 다르다. 1MB까지 처리 할 수 있는 것은 Address pin이 20개 있으면 된다. (2^20이 1MB이기 때문)
Data는 0~7까지 8bit를 처리할 수 있다. 한번에 Data를 담을 수 있는 양이라고 보면 된다. 쓸 때도 1 Byte만큼, 읽을 때도 1 Byte 만큼을 한번에 처리할 수 있는 것이다. 한번에 처리 가능한 양 만큼씩이니 꼭 8 bit씩이라고 생각하면 곤란하다.

 
자, 그러면 이제 Memory가 어떻게 동작하는지 한번 보자.   
0xAB (10101011)번지의 Data를 Write할 때의 Memory 상태는 이렇다. 
Write할 것이기 때문에 WR에 1을 주고, RD에는 0을 준다.

 

그러면 0xAB번지를 Address pin에 주고, 쓰고 싶은 Data인 0x7C (1111100) 를 Data pin으로 주게 되면 0xAB번지에 0x7C가 써지는 것이다.

<br>

![ram2](https://postfiles.pstatic.net/MjAyMjA2MjRfMTU2/MDAxNjU2MDU0ODU5MzAw.rVxk4oShs_B90ghLKmv3OBWdop0m0h58pIM5WkPvdCEg.Ga04l8URZ-zcJ0rJBaadDfrWklhrXQMKMc5nYux9lLog.PNG.wndgndi/image.png?type=w773)

<br>

그럼 반대로 읽을 때는 어떻게 할까? 0x7C가 잘 써져 있는지 확인해 보자.  
RD를 1로 주고, WR을 0으로 주고, Address에 0xAB를 준다.
그러면 Data pin으로 0x7C가 튀어 나오게 되는 것이다.

![ram3](https://postfiles.pstatic.net/MjAyMjA2MjRfMTUw/MDAxNjU2MDU0ODc5NDcy.coFyx2fWScnw1HHQPV10IYocEX6doJyuTgi3tKW2fq8g.kHfsPXbnawGwoqDslkwQXFjk33uKRgmbssB7bg-UmdUg.PNG.wndgndi/image.png?type=w773)

<Br>

Memory에는 이런 식으로 Data가 저장되고, 읽어들일 수도 있다.   
여기에서 RD나 WR은 다른 형식으로도 control될 수 있지만,  Address와 Data에 관련된 건 똑같으므로 이것만 알아둬도, Memory란 이런 거구나 하고 알 수 있을 것이라 생각한다.


Address Bus Width가 16 bit이면 최대로 나타낼 수 있는 Memory Size는 얼마 인가?  
일단은 Address Bus Width가 16 bit이면 2^16 만큼 Address를 표현 할 수 있다.
왜냐하면 1byte당 address를 1을 차지하기 때문이다. 그러니까 2 byte면 0x2만큼의 Address가 필요하고, 4byte면 0x4만큼의 Address가 필요한 것이다. 

​
그러면 얼마 인가?  2^16만큼의 Address를 표현 하는 것이다. 
즉, 64KB이다.  
그러면 한번에 16 bit씩 Access하는 (즉, word가 16bit씩인 System) System에서 나타낼 수 있는  Address 크기는 두 배가 될 것이다. 
한번에 2 byte씩 Access하니까 굳이 1 byte씩 표현 할 이유가 없다. 
그러니까 64KB를 나타 낼 수 있는 Address line에서 그런 경우라면 128KB 인 것이다. 
이런 configuration에서는 dataline이 16개 나와 있을 것이다.
