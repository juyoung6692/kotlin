package generic.functions

fun <T> List<T>.hasIntersection(other: List<T>) = (this.toSet() intersect other.toSet()).isNotEmpty()