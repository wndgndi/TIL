# 해시(Hash)란

●  해시란 임의의 크기를 가진 데이터를 고정된 크기의 데이터로 변화시켜 저장하는것이다. 이 과정은 해시함수를 통해 진행되며 해시값 자체를 index로 사용하기에 평균 시간복잡도가 O(1)으로 매우 빠르다.

● 키(key) 1개와 값(value) 1개가 1:1로 연관되어 있는 자료구조이다. 따라서 키(key)를 이용하여 값(value)을 도출할 수 있다.

![hash](https://blog.kakaocdn.net/dn/LvrrR/btq9uAYTVIw/S1OuQc9dSGRegld1ksjct1/img.png)



ArrayList는 내부 인덱스를 이용하여 검색이 한번에 이루어지기 때문에 빠른 검색 속도를 보장하는 반면 데이터의 추가/삭제시 많은 데이터가 밀리거나 당겨지기 때문에 많은 시간이 소요된다.


LinkedList는 추가/삭제시 인근 노드들의 참조값만 수정해 줌으로써 빠른 처리가 가능하지만 데이터를 검색할 경우 해당 노드를 찾기 위해 처음부터 순회 검색을 해야 하기 때문에 데이터 수가 많아질수록 효율이 떨어지는 구조이다.


*이러한 한계를 극복하기 위해서 제시된 방법이 Hash이다.

Hash는 내부적으로 배열을 사용하여 데이터를 저장하기 때문에 빠른 검색속도를 갖는다.

그리고 데이터 추가/삭제시 기존 데이터를 밀어내거나 당기는 작업이 필요없도록 특별한 알고리즘을 이용하여 데이터와 연관된 고유한 숫자를 만들어 낸 뒤 이를 인덱스로 사용한다.


특정 데이터가 저장되는 인덱스를 그 데이터만의 고유한 위치로 정하여서 데이터 추가/삭제시 데이터의 이동이 없도록 만들어진 구조이다.

Hash가 내부적으로 사용하는 배열을 Hash Table 이라고 하며 크기에 따라 성능차이가 날 수 있다.

즉, Hash는 ArrayList의 추가/삭제 시 속도가 느려지는 단점과 LinkedList의 검색시 처음부터 끝까지 다 찾아봐야하는 비효율성을 해결하고자 나온 방법이다.  
<br>

---
## [ 해시 테이블 (Hash Table) ]

​

key-value 에서 key를 테이블에 저장할 때 key값을 Hash Method를 이용해 계산을 수행한 후, 그 결과값을 

배열의 인덱스로 사용하여 저장하는 방식이다. 여기서 key값을 계산하는 것이 Hash Method 이다.


또한 우리는 Key와 Value의 쌍을 Hash Table이라고 한다.
Key는 Hash에서 매핑할 때 사용하는 인덱스라고 생각하면 된다. Key는 절대로 중복되지 않는다는 특징을 가지고 있다.

만약 같은 Key에 값을 넣으면 이전 값은 사라지고 나중에 들어온 값만 남는다. 
Value는 Key로 매핑했을 때 나오는 값을 말한다.
Hash는 배열의 인덱스와 다르게 순차적으로 저장되는 것이 아니라 전 영역에 고루 분포된다는 특징을 가지고 있다.

따라서, 배열보다 빠르게 값을 찾을 수 있다는 장점을 가지고 있다.
<br>

---
## [ 해시 메소드 (Hash Method) ]

Hash는 특별한 알고리즘을 이용하여 데이터의 고유한 숫자값을 만들어 인덱스로 사용한다. 이 알고리즘을 구현한 메소드를 Hash Method라고 하며 Hash Method에 의해 반환된 데이터의 고유 숫자값을 Hash Code 라고 한다.


-  자바에서는 Object 클래스의 hashCode() 메소드를 이용하여 모든 객체의 Hash Code를 쉽게 구할 수 있다.

-  Hash Method를 이용해서 데이터를 Hash Table에 저장하고 검색하는 기법을 Hashing이라 한다.


Hash Method는 데이터가 저장되어 있는 곳을 알려주기 때문에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.
Hash 함수란 데이터의 효율적 관리를 위해 임의의 길이를 가진 데이터를 고정된 길이를 가진 데이터를 매핑해주는 함수이다.

예를 들어 군대에서는 언어를 모스부호로 바꿔 암호화하여 전달한다. 여기서 모스부호로 바꾸는 과정을 '해시 함수'라고 이해하면 쉽다.

![hash2](https://velog.velcdn.com/images%2Fkkw9312%2Fpost%2F4db203d2-1f3b-4bcb-bfd7-c28b2ac5bafd%2Fimage.png)

---
## [ 해시코드 (Hash Code) ]

Hash로 값을 생성하면 고유의 주소 값이 생기는데 이것을 숫자로 변환한 것을 해시코드라고 부른다.
즉, 자바에서 해시코드는 Heap 영역의 인스턴스에 대한 참조 값이라고도 부를 수 있다.
<br>

---

## [ 해싱 (Hashing) ]

**HashMethod를 써서 HashTable에 저장하는 것**



HashMap과 같이 Hashing을 구현한 컬렉션 클래스에서는 Object 클래스에 정의된 hashCode()를 Hash Method로 사용한다. 
​

Object 클래스에 정의된 hashCode()는 객체의 주소를 이용하는 알고리즘으로 해시 코드를 만들어내기 때문에 모든 객체에 대해 중복되지 않는 값을 제공한다.
​

String 클래스의 경우 Object로 부터 상속받은 hashCode()를 오버 라이딩하여 문자열의 내용으로 해시 코드를 
만들어 낸다. 서로다른 String 인스턴스 일지라도 같은 내용의 문자열을 가졌다면 hashCode()를 호출했을 때 같은 값을 얻는다.

```
String s = "string";
String s1 = "string";
System.out.println(s.hashCode()); // -891985903
System.out.println(s1.hashCode()); // -891985903
System.out.println(s.equals(s1)); // true
```
서로 다른 두 객체에 대해 hashCode() 반환값이 같고 equals()로 비교한 결과가 true이면 같은 객체로 인식한다.

<Br>

HashMap도 같은 방법으로 객체를 구별하기 때문에 이미 존재하는 키와 동일한 값을 저장하면 기존의 값을  새로운 값으로 덮어쓴다.
```
HashMap<String,Integer> testMap = new HashMap<String,Integer>();
testMap.put("s",2);
testMap.put("s",1);
testMap.put("s1",2);
System.out.println(testMap); // {s=1, s1=2}
```

---

## [ 해시 충돌 (Hash Collision) ]

​

같은 Key에 값을 넣으면 이전 값은 사라지고 나중에 들어온 값만 남는 이러한 문제를 해시 충돌(Hash Collision)이라고 부른다.
해시 충돌이 발생하게 되면 검출 속도를 느리게 만들고 버킷 오버플로우를 발생시키는 문제가 나타난다.
( 버킷 오버플로우: 버킷의 크기가 작으면 서로 다른 키를 해시함수하여 같은 해시 값이 나와 버킷이 크기를 넘을 수 있음 ) 

![hash3](https://blog.kakaocdn.net/dn/CMGrO/btq9nhGdvS6/8tYDrod4tS5G6yhqNFlzG1/img.png)

**즉, 무한한 값(KEY)을 유한한 값(HashCode)으로 표현하면서 서로 다른 두 개 이상의 유한한 값이 동일한 출력 값을 가지게 된다는 것이다.**

 

key가 될 수 있는 경우는 무한하고 해시테이블은 유한하니 소위 비둘기집 원리라고 부르는 문제가 발생한다. 이런 문제로 인해 우리는 해시함수의 중요성을 느낄 수 있다. 최대한 겹치지 않고 다양한 값을 보장하는 해시 함수라면 이런 문제를 조금 개선할 수 있지만 그래도 근본적으로는 불가능하다. 따라서 우리는 해시 충돌을 해결한 방법이 필요하다. 
크게 두 가지의 해결 방법이 있는데 Separate Chaining기법과 Open Addressing(개방 주소법)이 있다.
<br>

---

### 1. Chaining 기법

**해시 충돌이 일어나면 연결 리스트를 이용해 데이터들을 연결하는 방식.**

Chaining은 추가적인 메모리를 이용해 동일한 Bucket에 연결 리스트로 하나씩 순차적으로 저장하는 것을 의미한다. ( Ex: 꼬리잡기 게임처럼 연결 리스트 내에서 하나의 노드가 되어 차례대로 연결되는 것을 의미한다 )

​

#### 장점

-  한정된 저장 공간을 효율적으로 사용할 수 있다.

-  해시 함수에 대한 의존성이 상대적으로 적다.

-  메모리 공간을 미리 잡아 놓을 필요가 없다.(그때그때 이어 붙이기 때문)

-  연결리스트만 사용하면 돼서 복잡하지 않고 같은 주소 값을 그대로 사용할 수 있다.

​

#### 단점

-  한 hash에만 자료가 계속 들어간다면(쏠린다면) 검색 효율이 떨어진다. (최악의 경우 O(n))

-  외부 저장공간을 사용한다.

-   많은 메모리 공간을 잡아 먹는다는 단점이 있다.

​![hash4](https://blog.kakaocdn.net/dn/bOyBVn/btq9uBwKvoB/307EOPWeKy9uL4FqesLxLK/img.png)


<br>

### 2. Open Addressing 

**해시 충돌이 일어나면 다른 Bucket에 삽입하는 방식**
개방 주소법은 대표적으로 3가지의 방법을 추가적으로 가지고 있다.

```
-  Linear Probing : 해시 충돌 발생 시 다음 bucket이나 몇 개의 bucket을 건너 뛰어 데이터를 삽입하는 방식

-  Quadratic Probing : 해시 충돌 발생 시 제곱만큼 건너 뛰어 데이터를 삽입하는 방식

-  Double Hashing : 해시 충돌 시 다른 해시함수를 한번 더 적용시킴
```
<br>

#### 장점

-  추가 공간이 필요 없다. ( 추가적인 메모리가 필요 없다 )

-  데이터를 직접 모두 읽어 오기 때문에, 포인터를 쓸 일이 없어 포인터를 사용함으로써 나타나는 오버헤드를 방지할 수 있다.
<br>

#### 단점

-  해시 함수의 성능에 전체 해시테이블의 성능이 좌지우지 된다.

-  데이터의 길이가 늘어나면 그에 해당하는 저장소를 마련해 두어야한다.

![hash5](https://blog.kakaocdn.net/dn/tFeQk/btq9mlvIP1O/WnWu2K9SQVeKOUiquscQ41/img.png)

---

#### < 선형 탐사 (Linear Probing) > 

![hash6](https://user-images.githubusercontent.com/48986787/132778287-a99e4969-e696-486d-8497-64db2f2bb9c0.png)

가장 간단한 충돌 해결 밥법이다.
충돌이 일어난 자리에서 i에 관한 일차 함수의 보폭으로 점프한다. (비어있는 부분을 찾아서 한칸씩 이동)
테이블의 경계를 넘어갈 경우에는 맨 앞으로 돌아간다.
채워져 있는 구간이 커지면 커질 수록 연산하는 횟수가 늘어난다는 단점이 있다.

<br>

#### < 제곱 탐사 (Quadratic Probing) >

![hash7](https://user-images.githubusercontent.com/48986787/132778382-b5d2b71c-e838-406b-846b-bf04c422bf3a.png)

한칸씩 이동하는 대신 보폭을 이차 함수로 넓혀가면서 본다.
즉, i번째 해시 함수를 h(x) 에서 i^2만큼 떨어진 자리로 잡는다.
특정 영역에 원소가 몰려도 그 영역을 빨리 벗어날 수 있다.

<br>


#### < 더블 해싱 (Double Hashing) >

![hash8](https://user-images.githubusercontent.com/48986787/132778432-d99912d6-4239-4a32-80b2-c4e75f29d0de.png)

두 개의 함수를 사용한다.
하나의 함수는 최초의 해시값을 얻을 때, 다른 하나의 함수는 해시 충돌이 일어났을 때 이동할 폭을 얻을 때 사용한다.
두 원소의 첫 번째 해시값이 같더라도 두 번째 해시값까지 같을 확률은 매우 적으므로, 서로 다른 보폭으로 이동하게 된다.
​