# 큐(Queue)란?

큐는 먼저 들어온 데이터가 먼저 나가는 구조로, 선입 선출(FIFO:First-Int First-Out)이라고 한다.

큐는 뒤에서 새로운 데이터가 추가되고 앞에서 데이터가 하나씩 삭제되는 구조를 가지고 있다.
한쪽은 프론트(front)로 정하여 삭제연산만 수행하고 한쪽은 리어(rear)로 정하여 삽입 연산만 수행하도록 제한한다. 
큐에서 이루어 지는 삽입연산을 enQueue라 하고 삭제연산을 deQueue라 한다.

### 큐의 구조 

![que](https://postfiles.pstatic.net/MjAyMjA1MDFfMTM2/MDAxNjUxMzg2ODk0NDE0.Ay82RqHlEhaBhhihSwP4V1x049FxW3r_HF-rgZxMGvgg.T2LbrSxQaiYmtPBSOAA0EMWkBujMEQ-sLACfO92e-A0g.PNG.wndgndi/qqq.png?type=w773)

```
enqueue :  큐에서 데이터를 넣는 작업 

dequeue :  큐에서 데이터를 꺼내는 작업 

front :  큐에서 데이터를 꺼내올 수 있는 위치 

rear :  큐에서 데이터를 넣을 수 있는 위치 

overflow :  큐가 꽉 차서 인큐할 수 없는 경우 
(큐(Queue)의 크기만큼 데이터가 꽉 차서 데이터를 넣지 못할 때)

underflow :  큐가 비어있어 데이터를 디큐할 수 없는 경우
(큐(Queue)가 비어있는데, 데이터를 꺼내려고 하는 경우)
```

---

### 큐의 연산

**아래의 3개는 큐(Queue)에서 오버플로우(Overflow)나 언더플로우(Underflow)가 발생하면 예외를 던진다.**

1) add(A) : A를 큐(Queue)에 넣는다.
2) remove() : 맨 처음에 들어간 데이터를 제거한다.
3) element() : 큐(Queue)에서 가장 앞에 있는 것을 반환한다.

<br>

**아래의 3개는 큐(Queue)에서 오버플로우(Overflow)나 언더플로우(Underflow)가 발생하면 null 또는 false를 반환한다.**
4) offer(A) : A를 큐(Queue)에 넣는다. 
5) poll() : 맨 처음에 들어간 데이터를 제거한다.
6) peek() : 큐(Queue)에서 가장 앞에 있는 것을 반환한다.
7) isEmpty() : 큐(Queue)가 
비어있으면 true, 비어있지 않으면 false를 반환한다.

*->자바의 Queue관련 API를 살펴보면 인터페이스로 구현되어 있기 때문에, 큐 인터페이스를 상속하여 구현해놓은 LinkedList<E>클래스를 이용하여 객체를 생성한다.*

※이외에도 큐는 여러 방면으로 활용되는 경우가 많아, 우선순위큐(PriorityQueue)등의 다른 클래스들을 이용하여 객체를 생성하고 활용할수도 있다.

---

### 큐의 특성

-  가장 먼저 들어간 것이 먼저 나오는 FIFO(First In First Out) 구조

-  큐는 한쪽 끝을 Front로 정해 삭제 연산만이 수행됨

-  큐의 다른 쪽 끝을 Rear로 정하여 삽입 연산만 수행됨

-  그래프의 넓이 우선 탐색(BFS)에 사용됨

---

### 큐의 사용 사례

-  큐(Queue)는 우리가 실생활에서도 사용되는 사례를 볼 수 있다.

-  프린터를 할 때 먼저 프린터를 한 사람이 문서가 프린터가 된다던지.

-  너비 우선 탐색(BFS, Breadth-First Search)

-  캐시(Cache)

-  티켓 카운터(먼저 줄 선 사람이 티켓을 가져가는 것처럼)

-  윈도우 시스템 메시지 처리기

-  프로세스 관리
---
### 큐의 종류

**1) 선형 큐**

- 선형 큐(Queue)는 스택처럼 생긴 큐(Queue)를 말한다.

- 크기가 제한되어 있고, 큐(Queue)에서 삭제가 일어나면 삭제된 자리는 비어있게 된다.

- 그렇기에 비어있는 자리를 옮겨야 하는 단점을 가지고 있다.

 

**2) 원형 큐**
- 선형 큐(Queue)의 단점을 보완하기 위해 만들어진 큐(Queue)

- 큐(Queue)에서 front가 큐의 크기가 되면 데이터를 다시 앞으로 보내어 원형으로 큐(Queue)구현

 

**3) 링크드 큐**

- 연결리스트로 구현한 큐(Queue)로, 큐의 크기를 쉽게 늘릴 수 있는 장점을 가지고 있다.

- 큐(Queue)의 크기를 쉽게 늘릴 수 있어 삽입, 삭제가 용이하고, 오버플로우가 발생하지 않는다.
---

### 링크드리스트를 사용한 큐 구현

#### 1) 큐(Queue) 선언

- 큐(Queue)는 링크드리스트(LinkeList)를 사용하여 생성해야 하기 때문에, 아래를 import해야 한다.

- import java.util.LinkedList;

- import java.util.Queue;

```
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // LinkedList를 이용한 Int형 Queue 선언 
        Queue<Integer> int_Queue = new LinkedList<>();
		
        //LinkedList를 이용한 String형 Queue 선언
        Queue<String> string_Queue = new LinkedList<>();
    }
}
```
<br>

#### 2)큐(Queue)의 추가
```
// LinkedList를 이용한 Int형 Queue 선언 
        Queue<Integer> int_Queue = new LinkedList<>();
				
        int_Queue.add(1); //int_Queue에 1추가
        int_Queue.add(2); //int_Queue에 2추가
        int_Queue.add(3); //int_Queue에3추가
```

<br>

#### 큐의(Queue)의 삭제
```
// LinkedList를 이용한 Int형 Queue 선언 
		Queue<Integer> int_Queue = new LinkedList<>();
				
		int_Queue.add(1); //int_Queue에 1추가
		int_Queue.add(2); //int_Queue에 2추가
		int_Queue.add(3); //int_Queue에 3추가
		
		int_Queue.poll(); //int_Queue 앞에 삭제
		int_Queue.remove(); //int_Queue 앞에 삭제
```

---

### 우선순위 큐(PriorityQueue) 구현

```
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) {
		//int형 PriorityQueue
		PriorityQueue<Integer> int_PriorityQueue = new PriorityQueue<>();

		//int형 PriorityQueue(우선순위 높은 순)
		PriorityQueue<Integer> int_PriorityQueue = new PriorityQueue<>(Collections.reverseOrder());

		//String형 PriorityQueue
		PriorityQueue<String> string_PriorityQueue = new PriorityQueue<>(); 

		//String형 PriorityQueue(우선순위 높은 순)
		PriorityQueue<String> string_PriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```
