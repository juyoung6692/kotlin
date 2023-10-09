package generic

class PersonDtoKey

class PersonDto

/**
 * typealias: 적은 타이핑으로 깔끔하게 변수나 함수에 배치 할 수 있
 */
typealias PersonDtoStore = Map<PersonDtoKey, MutableList<PersonDto>>

fun handleCacheStore(store: PersonDtoStore){
}