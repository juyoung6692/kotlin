package generic

/**
 * fun <T> T.toSuperString(){
    println("${T::class.java.name}") T::class에서 오류남
}
 *제네릭 함수는 런타임때 클래스 정보가 소실 되어 가져올 수 없음
 * inline 함수를 사용(함수가 호출되는게 아니라 코드 본문을 호출 지점으로 이동 시켜서 컴파일 되므로)
 * reified T 가 제네릭으로 간주 되지 않음
 *
 */

inline fun <reified T> T.toSuperString(){
    println(T::class.java.name)
}

fun main(){
 //예제
    val number = listOf(1, 1.0, 1.23f)
    number.filterIsInstance<Int>()//특점 타입만 필터링 , inline - reified를 사용한 함수
}

