package higherorderfunctions

inline fun repeat(times: Int, exec: () -> Unit) {
    for (i in 1..times) {
        exec()
    }
}

inline fun repeat2(times: Int, noinline exec: () -> Unit) {
    for (i in 1..times) {
        exec()
    }
}

inline fun iterable(numList: List<Int>, crossinline exec: (Int) -> Unit) {
    numList.forEach { exec(it) }
}

fun main() {
    repeat(2) { println("hi") } //println 까지 인라이닝 됨.
    call { println("hi") } //exec 을 알 수 없기 때문에 인라이닝 되지 않는

    iterable(listOf(1, 2, 3, 4, 5)) { num ->
        if (num == 3) {
            return@iterable
            /***inline 함수 사용 시 non-local return 이 가능 하지만 가장가까운 fun 키워드를 종료 하기 때문에 main function이 종료됨
             * non-local return 금지 하고 싶을 경우 crossinline을 사용 하면됨
             * inline 없이 return@iterable을 사용할 수도 있음
             */
        }
        println(num)
    }
}

fun call(exec: () -> Unit) {
    repeat(2, exec)
}