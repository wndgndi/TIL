 # CPU의 구조와 기능

 
### [ CPU가 수행하는 세부적인 동작들의 순서 ]

​

(3)~(5) 과정은 명령어에 따라 필요한 경우에만 동작 수행한다.

 
**(1) 명령어 인출(Instruction Fetch)** : 기억장치로부터 명령어를 읽어옴


**(2) 명령어 해독(Instruction decode)**: 수행해야 할 동작을 결정하기 위해 명령어를 해독


**(3) 데이터 인출(Data Fetch)**: 명령어 실행을 위해 데이터가 필요한 경우, 기억장치(Main Memory-RAM) 혹은 I/O장치(키보드, 파일 등)로부터 데이터를 읽어옴


**(4) 데이터 처리(Data Process)**: 데이터에 대한 산술/논리 연산 수행


**(5) 데이터 저장(Data Store)**: 수행 결과를 저장

---

<Br>

### [ CPU의 기본 구조 ]

-  **ALU** (산술 논리 연산 장치 - Arithmetic and Logical Unit) : 덧셈, 뺄셈, 곱셈, 나눗셈 / AND, OR, NOT

<bre>

-  **Register** (레지스터) : 엑세스 속도가 컴퓨터의 기억장치들 중 가장 빠른 CPU 내부의 기억장치

<bre>

-  **Control Unit** (제어 유닛) : 명령어를 해석하고, 이를 실행하기 위한 제어 신호들을 순차적으로 발생
( 정보들의 전송 통로와 방향 지정, 동작 시간 결정 )

<bre>

-  **CPU internal bus** (CPU 내부 버스) : ALU와 레지스터들 간의 데이터 이동을 위한 데이터 선,  제어 유닛으로부터 발생되는 제어 신호 선들로 구성된 내부 버스  
( 외부 시스템 버스와는 반드시 버퍼 레지스터 혹은 시스템 버스 인터페이스 회로를 통하여 연결됨 )

---

<br>

### [ 명령어 실행 ]

<Br>

**● 명령어 사이클(instruction cycle)** : CPU가 한 개의 명령어를 실행하는 데 필요한 전체 처리 과정

1. 인출 사이클(fetch cycle) : CPU가 기억 장치로부터 명령어를 읽어 오는 단계

2. 실행 사이클(execution cycle) : 명령어를 실행하는 단계

<Br>
<br>

**● 명령어 실행에 필요한 CPU 내부 레지스터들**​

 

**1) PC** (프로그램 카운터 - Program Counter)

-  다음에 인출할 명령어의 주소를 가지고 있는 레지스터

-  각 명령어 인출 이후, 자동적으로 일정 크기(한 명령어의 길이-64비트, 32비트) 만큼 증가

-  분기(branch) 명령어가 실행되는 경우 목적지 주소로 갱신

​

**2) AC** (누산기 - Accumulator)

-  데이터를 일시적으로 저장하는 레지스터(tmp 변수를 담는 버퍼 역할)

-  레지스터의 길이는 CPU가 한 번에 처리할 수 있는 데이터 비트수(단어 길이)와 동일

​

**3) IR** (명령어 레지스터 - Instruction Register)

-  가장 최근에 인출된 명령어 코드가 저장되어 있는 레지스터

​

**4) MAR** (기억장치 주소 레지스터 - Memory Address Register)

-  PC에 저장된 명령어 주소가 시스템 주소 버스로 출력되기 전에 일시적으로 저장되는 주소 레지스터

​

**5) MBR** (기억장치 버퍼 레지스터 - Memory Buffer Register)

-  기억장치에 쓰여질 데이터, 혹은 읽혀진 데이터를 일시적으로 저장하는 버퍼 레지스터

<Br>
<br>

---

<br>

### ● 인출 사이클


1) MAR ← PC

2) MBR ← M[MAR], PC ← PC + 1

3) IR ← MBR 

---

<br>

### ● 실행 사이클

명령어 코드를 해독(decode)하고 그 결과에 따라 필요한 연산들을 수행

<Br>

 
**< 연산의 종류 >**

-  데이터 이동

-  데이터 처리

-  프로그램 제어
​
<br>


**< 기본적인 명령어 형식의 구성 >**

- 연산 코드(operation code)​: CPU가 수행할 연산을 지정

- 오퍼랜드(operand): 명령어 실행에 필요한 데이터가 저장된 주소(addr)

 

​

**< 어셈블리 프로그램의 실행 과정 예 >**

1. LOAD addr

2. ADD addr

3. JUMP addr

---

### ● 인터럽트 사이클

 

#### 인터럽트 

: 프로그램 실행 중에 CPU의 현재 처리 순서를 중단시키고 다른 동작을 수행하도록 요구하는 시스템 동작

​<br>

#### ISR (인터럽트 서비스 루틴 - Interrupt Service Routine) 
: 인터럽트를 처리하기 위해 수행되는 프로그램 루틴

 

-  인터럽트 처리 과정
-  인터럽트 사이클의 연산 과정 

 <br>
 
#### 다중 인터럽트(multiple interrupt) : ISR을 수행하는 동안에 또다른 인터럽트 발생

<br>

**< 다중 인터럽트의 처리 방법 >**

1. 새로운 인터럽트 수행 방지

2. 인터럽트의 우선 순위에 따라 처리

---

<br>

### ● 간접 사이클

명령어에 포함되어 있는 주소를 이용하여 그 명령어 실행에 필요한 데이터의 주소를 인출하는 사이클
*→ 간접 주소지정 방식(indirect addressing mode)에서 사용*

<br>
 
1) MAR ← IR(addr)
2) MBR ← M[MAR]
3) IR(addr) ← MBR

<br>

인출된 명령어의 주소 필드 내용을 이용하여 기억 장치로부터 데이터의 실제 주소를 인출하여 IR 주소 필드에 저장하는 방식이다.