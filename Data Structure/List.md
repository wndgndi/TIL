# Array(배열)

-  여러 데이터를 하나의 이름으로 그룹핑해서 관리 하기 위한 자료구조. index와 값의 쌍으로 구성
<br>

-  index는 값에 대한 유일무이한 식별자 (마치 주민번호)
( 리스트에서 인덱스는 몇 번째 데이터인가 정도의 의미를 가짐 )
<br>

-  논리적 저장 순서와 물리적 저장 순서가 일치 => index로 해당 원소에 접근할 수 있다. (O(1))
<br>

-  연속된 메모리의 공간으로 이루어져 있다
<br>

-  배열은 정의와 동시에 길이를 지정하며 길이를 바꿀 수 없다.

<br>

### [ 장점 ]
-  인덱스를 통한 검색이 용이함.

-  연속적이므로 메모리 관리가 편하다.

<br>

### [ 단점 ]
-  크기가 고정되어 있기 때문에 어떤 엘리먼트가 삭제되면, 삭제된 상태를 빈 공간으로 남겨두어야 한다.    
  =>  메모리 낭비
<br>
-  정적이므로 배열의 크기를 컴파일 이전에 정해주어야 한다.
<br>
-  컴파일 이후 배열의 크기를 변동 할 수 없다.

---

# List

-  리스트는 순서가 있는 엘리먼트의 모임으로 배열과는 다르게 빈 엘리먼트는 절대 허용하지 않는다.
<br>

-  리스트는 배열이 가지고 있는 인덱스라는 장점을 버리고 대신 빈틈없는 데이터의 적재 라는 장점을 취함.
<Br>

-  리스트에서 인덱스는 몇 번째 데이터인가 정도(순서)의 의미를 가진다. 
(배열-Array에서의 인덱스는 값에 대한 유일무이한 식별자)
<br>

-  빈 엘리먼트는 허용하지 않는다. => java에서는 허용하는 경우가 있음
<br>

-  순차성을 보장하지 못하기 때문에 spacial locality 보장이 되지 않아서 cash hit가 어렵다.
<br>

-  데이터 갯수가 확실하게 정해져 있고, 자주 사용된다면 array가 더 효율적이다.
<br>

-  불연속적으로 메모리 공간을 차지.
<br>

-  포인터를 통한 접근



<br>

### [ 장점 ]
-  포인터를 통하여 다음 데이터의 위치를 가리키고 있어 삽입, 삭제의 용이.
<br>

-  동적이므로 크기가 정해져 있지 않다.
<br>

-  메모리의 재사용 편리
<Br>

-  불연속적이므로 메모리 관리의 편리

​
### [ 단점 ]
- 검색 성능이 좋지 않다.
<br>

- 포인터를 통해 다음 데이터를 가르키므로 추가적인 메모리 공간 발생.

<br>

||추가/삭제|조회|
|---|---|---|
Array|느림|빠름|
List|빠름| 느림|

<br>
<br>

***● 배열 : 데이터의 크기가 정해져 있고, 추가적인 삽입 삭제가 일어 나지 않으며 검색을 필요로 할 때 유리함.***

​
***● 리스트 : 데이터의 크기가 정해져 있지 않고, 삽입 삭제가 많이 일어나며, 검색이 적은 경우 유리함.***



<br>


### [ List 자료구조의 대표 기능 ]

 자료구조에서 가장 중요한 점은, 해당 자료구조가 어떠한 기능을 가지고 있느냐는 것이다. 

- 처음, 끝, 중간에 엘리먼트를 추가/삭제 하는 기능
<br>

- 리스트에 데이터가 있는지를 체크하는 기능
<Br>

- 리스트의 모든 데이터에 접근할 수 있는 기능

<br>

#### List 추가

리스트명.add("값")
<br>
#### List 삭제 

리스트명.remove("값");<br>
리스트명.remove(인덱스)
 <br>

**List 값 변경**

리스트명.set(인덱스, "바꿀값");
<br>
 

**List 크기 확인**

리스트명.size();
<br>
 

**List에 특정 값 들었는지 확인**

리스트명.contains("값");

<br>
 

**List가 비었는지 확인**

리스트명.isEmpty();