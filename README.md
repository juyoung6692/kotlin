# kotlin

- 제네릭
- 지연과 위임

Iterable & Sequence

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
