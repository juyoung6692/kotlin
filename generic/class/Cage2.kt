package generic.`class`

//GoldFish만 들어갈수있는 케이지, Carp만 들어갈수 있는 케이지 클래스 작성
class Cage2<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T{
        return  animals.first()
    }

    fun put(animal: T){
        animals.add(animal)
    }

    fun moveFrom(cage: Cage2<out T>){
        this.animals.addAll(cage.animals)
    }

    fun moveTo(cage: Cage2<in T>){
        cage.put(this.getFirst())
    }
}