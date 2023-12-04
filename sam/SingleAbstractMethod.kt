package sam

fun interface Filter<T>{
    fun predicate(t: T)
}

fun main(){
    //val filter:StringFilter = {s -> s.startWith("A")}
    val filter = StringFilter {s -> s.startsWith("A")}
    testFilter (StringFilter{ s -> s.startsWith("A") })
}

fun testFilter(filter: StringFilter){}
fun <T> testFilter(filter: Filter<T>){}