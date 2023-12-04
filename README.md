# kotlin

- 제네릭
- 지연과 위임

<h3>Iterable & Sequence</h3>

Iterable 
- 연산 중간에 collection을 만듦
- 아래 예제에서 200만건이 있다면 모두 필터링</br>
ex) list.filter{it.name == "iterable"}.map{it.price}.take(10_000)

Sequence
- 각 단계가 모든 원소에 적용되지 않을 수 있음
- 한 원소에 대해 모든 연산을 수행 후 다음 원소로 넘어감
- 최종 연산이 나오기전까지 계산을 미리 하지 않음(ex: average()) *지연연산
- 연산 순서가 바뀌면 처리해야 하는 양이 바뀌기 때문에 연산 순서 주의!!
- 아래 예제에서 200만건이 있을 경우 "iterable" 10_000만건을 찾고 다면 그 뒤에 원소에 대한 연산을 수행하지 않음</br>
ex) list.asSequence().filter{it.name == "iterable"}.map{it.price}.take(10_000)

~~~
그렇다면 Sequence가 항상 Iterable 보다 빠를까?
정답은? 아니다.
컬렉션의 크기가 크지 않다면 sequence의 지연연산에서 약간의 오버헤드가 있기 떄문에 Iterable이 더 빠를 수 있음
~~~

***

<h3>고차함수(Higher-Order functions)[[HigherOrderFunctions.kt](higherorderfunctions%2FHigherOrderFunctions.kt)]</h3>

*** 파라미터를 함수로 받거나 함수를 반한하는 함수 ***
- 함수의 마지막 파라미터가 함수인 경우 lambda 식은 함수 호출부 바깥으로 뺄 수 있음
~~~
  컴파일 과정에서 Function 객체가 만들어지며 함수를 변수처럼 사용 할떄마다 객체가 생성 됨
  - 오버헤드 발생
  - 함수에서 밖의 변수를 포획할 경우에도 Ref라는 객체로 한번 더 감싸기 때문에 오버헤드 발생
~~~
장점: 편리함 </br>
단점: 성능 부담(호출 시 계속 되는 객체 생성) </br>
</br>
<b>***inline 함수를 써보자**</b>
[Inline.kt](higherorderfunctions%2FInline.kt)
- 받고있는 함수 파라미터까지 inline 시킬 수 있음
- non local return 허용(가장 가까운 fun 키워드 종료)
- 받고있는 함수를 확실히 알 수 없을 경우는 인라이닝 안됨.
- 인라이닝 제외 시키고 싶을 경우 noinline 사용
- crossinline: non-local return 허용 안함
- *프로퍼티에도 inline을 사용 할 수 있음

***
