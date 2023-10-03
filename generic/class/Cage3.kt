package generic.`class`

/**
 * declaration-site variance: 선언하는 지점에 변성을 줌(Class)
 * use-site variance: 사용하는 지점에 변성을 줌(function, variable declaration)
 * out: @UnsafeVariance
 * out은 생산만 할 수 있지만 타입세이프하다고 판단하는 타입파라미터앞에 @UnsafeVariance 를 붙여서 소비를 할 수 있음
 */
class Cage3<out T> {
    private val animals = mutableListOf<T>()

    fun getFirst(): T{
        return this.animals.first()
    }

    fun getAll(): List<T>{
        return this.animals
    }
}

class Cage4<in T> {
    private val animals = mutableListOf<T>()

    fun put(animal: T){
        this.animals.add(animal)
    }

    fun putAll(animals: List<T>){
        this.animals.addAll(animals)
    }
}