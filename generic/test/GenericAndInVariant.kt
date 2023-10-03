package generic.test

import generic.`class`.Cage2
import generic.`class`.Fish
import generic.`class`.GoldFish

fun testInvariant(){
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()
    fishCage.moveFrom(goldFishCage)
    goldFishCage.moveTo(fishCage)

    /** goldFish 와 Fish는 상속관계지만 Cage2<Fish> & Cage2<GoldFish>는 아무관계가 아님 out T나 in T로 바꿔주면 됨
     * out T
     * variance annotation 데이터를 꺼내는 것만 되고 넣는 것은 안 됨(생산자, 공변)
     * 타입 안전성이 깨질 수 있기 때문에
     *
     * in T
     * contra-variant 데이터를 넣는 것만 되고 꺼내는 것은 안됨(소비자, 반공변)
     */

    /**
     * Jave의 배열과 리스트
     * String Objet 상속관계에서
     * String[] Object[] 배열로 바뀌 더라도 상속관계는 유지(co-variant)
     * List<String> List<Object> 유지 안됨(in-variant)
     *
     * 배열 공변 (타입 안전하지 않음)
     * 리스트 무공변
      */
}