package delegate

import kotlin.reflect.KProperty

/**
 * lazy 원리
 * by 는 getValue나 setValue 함수가 있는 객체에 사용 할 수 있음
 * getter/setter가 호출될 때 위임 객체의 getValue/setValue가 호출된다
 */
class Person4 {
    private val name: String by LateInitProperty {
        Thread.sleep(2000)
        "이무개"
    }
}

class LateInitProperty<T>(val init: () -> T) {
    private var _value: T? = null
    private val value: T
        get(){
            if(_value == null){
                this._value = init()
            }
            return _value!!
        }

    operator fun getValue(thisRef: Any, property: KProperty<*>):T{
        return value
    }
}