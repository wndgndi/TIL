List는 Collection 인터페이스를 확장한 자료형으로 동일한 데이터의 중복 입력이 가능하며 순차적이고 다량의 데이터를 입력할 때 주로 사용한다. 종류는 Vector, Arraylist, Linkedlist가 있다.

---

# ArrayList 

ArrayList는 List 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트이다. 
일반적인 배열과 같은 순차리스트이며 인덱스로 내부의 객체를 관리한다는 점 등이 유사하지만 한번 생성되면 크기가 변하지 않는 배열과는 달리 ArrayList는 객체들이 추가되어 저장 용량(capacity)을 초과한다면 자동으로 부족한 크기만큼 저장 용량(capacity)이 늘어난다는 특징을 가지고 있다.

```

// DEFAULT_CAPACITY=10 
// 기본 저장용량 10으로 리스트 생성 
List<String> list = new ArrayList<>();

 // 저장 용량을 100으로 설정해 ArrayList 생성 
List<String> list = new ArrayList<>(100);
```

ArrayList에서 특정 인덱스의 객체를 제거하게 되면, 제거한 객체의 인덱스부터 마지막 인덱스까지 모두 앞으로 1칸씩 앞으로 이동한다. 객체를 추가하게 되면 1칸씩 뒤로 이동하게 된다. 인덱스 값을 유지하기 위해서 전체 객체가 위치가 이동한다.
즉, 인덱스의 추가나 제거가 발생할 시, 그 인덱스의 위치부터 마지막 인덱스까지 1칸 씩 이동한다.
따라서 잦은 원소의 이동, 삭제가 발생할 경우 ArrayList보다 LinkedList를 사용하는 것이 좋다.
![arrayList](https://blog.kakaocdn.net/dn/qp1KU/btqEiLKhVVi/h1IfW46J1Ks7nu1DBvgUmk/img.png)

![arraylist2](https://blog.kakaocdn.net/dn/bpnfNy/btqD4yYYpRm/oJyzShR4aaqvFfz6Ol1YD0/img.jpg)

<br>

## ArrayList 사용법

#### [ ArrayList 선언 ]
```
ArrayList list = new ArrayList();  //타입 미설정 Object로 선언된다.
ArrayList<Student> members = new ArrayList<Student>();  //타입설정 Student객체만 사용가능
ArrayList<Integer> num = new ArrayList<Integer>();  //타입설정 int타입만 사용가능
ArrayList<Integer> num2 = new ArrayList<>();  //new에서 타입 파라미터 생략가능
ArrayList<Integer> num3 = new ArrayList<Integer>(10);  //초기 용량(capacity)지정
ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));  //생성시 값추가
```

ArrayList선언시 ArrayList list = new ArrayList()로 선언 후 내부에 임의의 값을 넣고 사용할수도 있지만 이렇게 사용할경우 값을 뽑아내기 위해서는 캐스팅(Casting) 연산이 필요하고 잘못된 타입으로 캐스팅을 한 경우에는 에러가 발생하기에 위와 같은 방식은 추천하지 않는다.

ArrayList를 사용할시에는 ArrayList에 타입을 명시해주는것이 좋다. JDK 5.0이후부터 자료형의 안정성을 위해 제너릭(Generic)라는 개념이 도입되었다. 

ArrayLIst<String> list = new ArrayList<String>(); 이라고 되어있다면 String객체들만 add되어질 수 있고 다른 타입의 객체는 사용이 불가능하다.

***※제네릭스는 선언할 수 있는 타입이 객체 타입이다. int는 기본자료형이기 때문에 들어갈수 없으므로 int를 객체화시킨 wrapper클래스를 사용해야 한다.***
<br>

#### [ ArrayList 값 추가 ]
```
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(3);  //값 추가
list.add(null);  //null값도 add가능
list.add(1,10);  //index 1에 10 삽입
```
<br>

```
ArrayList<Student> members = new ArrayList<Student>();
Student student = new Student(name,age);
members.add(student);
members.add(new Student("홍길동",15));
```
ArrayList에 값을 추가하려면 ArrayList의 add(index, value) 메소드를 사용하면 된다. 

index를 생략하면 ArrayList 맨 뒤에 데이터가 추가되며 index중간에 값을 추가하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 뒤로 밀려난다. 

![arraylist3](https://blog.kakaocdn.net/dn/bd9xgH/btqEiM3wKkP/k6YlzEPE3414PzuO1zse00/img.png)

이 경우 데이터가 늘어나면 늘어날 수록 성능에 악영향이 미치기에 중간에 데이터를 insert를 해야할 경우가 많다면 ArrayList보다는 LinkedList를 활용하시는 것도 좋은 방법이다.

![arraylist4](https://blog.kakaocdn.net/dn/lNXb3/btqNH0rE6R7/evmk6mbIYSDFS6YEyDHpek/img.png)

<br>

#### [ ArrayList 값 삭제 ]
```
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
list.remove(1);  //index 1 제거
list.clear();  //모든 값 제거
```

ArrayList에 값을 제거하려면 ArrayList의 remove(index) 메소드를 사용하면 된다. remove()함수를 사용하여 **특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다.** 
모든 값을 제거하려면 clear() 메소드를 사용하면 된다.

![arraylistdelete](https://blog.kakaocdn.net/dn/BnPnb/btqNJvEIuVp/AveRJgGkdykzqqLqfS6DP1/img.png)

<br>

#### [ ArrayLits 크기 구하기 ]
```
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
System.out.println(list.size()); //list 크기 : 3
```
ArrayList의 크기를 구하려면 ArrayList의 size() 메소드를 사용하면 된다.

<br>

#### [ ArrayList 값 출력 ]
```
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));

System.out.println(list.get(0));//0번째 index 출력
		
for(Integer i : list) { //for문을 통한 전체출력
    System.out.println(i);
}

Iterator iter = list.iterator(); //Iterator 선언 
while(iter.hasNext()){//다음값이 있는지 체크
    System.out.println(iter.next()); //값 출력
}
```

ArrayList의 get(index) 메소드를 사용하면 ArrayList의 원하는 index의 값이 리턴된다. 
전체출력은 대부분 for문을 통해서 출력을하고 Iterator를 사용해서 출력을 할 수도 있다.

<br>

#### [ ArrayList 값 검색 ]

```
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
System.out.println(list.contains(1)); //list에 1이 있는지 검색 : true
System.out.println(list.indexOf(1)); //1이 있는 index반환 없으면 -1
```
ArrayList에서 찾고자 하는 값을 검색하려면 ArrayList의 contains(value) 메소드를 사용하면 된다. 
만약 값이 있다면 true가 리턴되고 값이 없다면 false가 리턴된다. 값을 있는 index를 찾으려면 indexOf(value) 메소드를 사용하면 되고 만약 값이 없다면 -1을 리턴한다.

---

## 배열과 ArrayList 차이

-  배열은 크기가 고정되어있지만 arrayList는 사이즈가 동적인 배열이다.

-  배열은 primitive type (int, byte, char 등)과 object 모두를 담을 수 있지만, arrayList는 object element만 담을 수 있다.

-  배열은 제네릭을 사용할 수 없지만, arrayList는 타입 안정성을 보장해주는 제네릭을 사용할 수 있다.

-  길이에 대해 배열은 length 변수를 쓰고, arrayList는 size() 메서드를 써야한다.

-  배열은 element들을 할당하기 위해 assignment(할당) 연산자를 써야하고, arrayList는 add() 메서드를 통해 element를 삽입한다.
