package delegate

/**
 * lateinit: 인스턴스화 시점과 변수 초기화 시점을 분리하는것
 * 컴파일 과정에서 nullable 변수로 바뀌고 변수에 접근시 null이면 예외를 발생시킴
 * !!!primitive 타입에 사용할 수 없다
 * Int? -> Integer
 * Int -> int
 * ex) testcode 작성
 */
class Person {
    private lateinit var name: String

    val isLee: Boolean
        get() = name.startsWith('이')

    val maskingname: String
        get() = name[0] + (1 until name.length).joinToString("") { "*" }
}

fun main(){
    val person = Person()
    person.isLee
}

/**
 * backing property를 초기화 해서 비싼 비용의 코드는 딱 한번만 필요할 때 호출
 * 하지만!!! 매번 긴 코드를 작성해야 이럴 때 by lazy 사용
 */
class Person2{
    private var _name: String? = null

    val name: String
        get(){
            if(_name != null){
                Thread.sleep(2000)
                this._name = "이무개"
            }
            return this._name!!
        }
}

/**
 * by lazy 아주 간결
 * getter가 호출 될떄 한번 실행되고 기본적으로 Thread-safe 함ㅣ
 */
class Person3{
    val name: String by lazy {
        Thread.sleep(2000)
        "이무개"
    }
}