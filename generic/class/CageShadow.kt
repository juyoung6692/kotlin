package generic.`class`

fun main(){
    val cage = CageShadow<GoldFish>()
    cage.addAnimal(GoldFish(""))
    cage.addAnimal(Carp(""))
}

/**
 *  똑같은 T 타입 파라미터 문자지만 다른 것으로 간주
 *  클래스 T가 함수 T에 의해 섀도잉 되는 것
 *  피하기 위해서 T와 다른 문자를 쓰거나 사용하지 않음
 */
class CageShadow<T: Animal> {
    fun <T: Animal> addAnimal(animal: T){}
}