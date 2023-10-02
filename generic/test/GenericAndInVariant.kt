package generic.test

import generic.`class`.Cage2
import generic.`class`.Fish
import generic.`class`.GoldFish

fun testInvariant(){
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()
    fishCage.moveFrom(goldFishCage)
    //goldFish 와 Fish는 상속관계지만 Cage2<Fish> & Cage2<GoldFish>는 아무관계가 아님 out T로 바꿔주면 됨

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