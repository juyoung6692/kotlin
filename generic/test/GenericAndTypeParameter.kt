package generic.test

import generic.`class`.Cage
import generic.`class`.Cage2
import generic.`class`.Carp
import generic.`class`.GoldFish
import java.lang.IllegalArgumentException

fun testGenericAndTypeParameter() {
    val cage = Cage()
    cage.put(GoldFish("금붕어"))
    val carpTypeCast: Carp =
        cage.getFirst() as Carp //Type Cast로 받을 경우 cage.put에서 GoldFish를 추가할 경우 컴파일시에는 에러 발생X 런타임 때 에러 발생O
    val carpSafeTypeCast: Carp = cage.getFirst() as? Carp
        ?: throw IllegalArgumentException() //Type Cast 에 실패할 경우 null 반환 후 throw


}