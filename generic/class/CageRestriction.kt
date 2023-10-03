package generic.`class`

fun main() {
    val cage = Cage6(mutableListOf(Eagle(), Sparrow()))
    cage.printAfterSorting()
}

abstract class Bird(
    name: String,
    private val size: Int,
) : Animal(name), Comparable<Bird> {
    override fun compareTo(other: Bird): Int {
        return this.size.compareTo(other.size)
    }
}

class Sparrow : Bird("참새", 100)
class Eagle : Bird("독수리", 500)

/**
 * 제네릭 타입에 제약을 줄 수 있음
 */
class Cage5<T : Animal> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        animals.add(animal)
    }

    fun moveFrom(cage: Cage5<out T>) {
        this.animals.addAll(cage.animals)
    }

    fun moveTo(cage: Cage5<in T>) {
        cage.put(this.getFirst())
    }
}

class Cage6<T>(
    private val animals: MutableList<T> = mutableListOf()
) where T : Animal, T : Comparable<T> {

    //Comparable<T>가 구현하고 있기 때문에 간단하게 함수로서 기능 할 수 있음
    fun printAfterSorting() {
        animals.sorted()
            .map { it.name }
            .let(::println)
    }

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        animals.add(animal)
    }

    fun moveFrom(cage: Cage6<out T>) {
        this.animals.addAll(cage.animals)
    }

    fun moveTo(cage: Cage6<in T>) {
        cage.put(this.getFirst())
    }
}