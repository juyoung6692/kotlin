package OperatorOverloading

import java.time.LocalDate

data class Point(
    val x: Int,
    val y: Int,
) {
    operator fun unaryMinus(): Point = Point(-x, -y)
    operator fun inc(): Point = Point(x + 1, y + 1)
}

fun main() {
    var point = Point(1, 2)
    println(-point)
    println(++point )

    //응용
    LocalDate.now().plusDays(3)
    LocalDate.now() + Days(3)
    LocalDate.now() + 3.d
}

val Int.d: Days
    get() = Days(this.toLong())
data class Days(val day: Long)

operator fun LocalDate.plus(days: Days): LocalDate = this.plusDays(days.day)