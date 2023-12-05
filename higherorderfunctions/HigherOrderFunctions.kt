package higherorderfunctions

fun main() {
    /*** 1-1 마지막 파라미터가 함수 호출부 일 떄의 람다식 ***/
    compute(1, 2) { num1, num2 -> num1 + num2 }
    compute(1, 2, fun(num1, num2) = num1 + num2)

    calculate(1, 2, Operator.MINUS)
}

fun compute(num1: Int, num2: Int, op: (Int, Int) -> Int): Int {
    return op(num1, num2)
}

fun calculate(num1: Int, num2: Int, op: Operator): Int = op.calcFunc(num1, num2)
fun calculateOperator(num1: Int, num2: Int, op: Operator): Int = op(num1, num2)//연산자 오버 로딩 사용 calculate와

enum class Operator(
    private val oper: Char,
    val calcFunc: (Int, Int) -> Int
) {
    PLUS('+', { num1, num2 -> num1 + num2 }),
    MINUS('-', { num1, num2 -> num1 - num2 }),
    MULTIPLY('*', { num1, num2 -> num1 * num2 }),
    DIVIDE(
        '/',
        { num1, num2 -> if (num2 != 0) num1 / num2 else throw IllegalArgumentException("0으로 나눌 수 없습니다.") });

    operator fun invoke(num1: Int, num2: Int) = this.calcFunc(num1, num2)
}