package generic.functions

/**
 * java; List list = new ArrayList();
 * rawType: 제네릭 클래스에서 타입 매개 변수를 사용하지 않고 인스턴스화 하는 것
 * 코틀린에서는 사용 불가: 처음부터 제네릭 타입을 고려하여 만들어짐
 */

fun checkList(data: Any){
    if(data is List<*>){
        //StartProjection을 사용하여 list인지만 확인 가능 *이 어떤 타입인지는 모름
        //따라서 add는 안됨
        val hi: Any? = data[0]
    }
    //data is List<String> 은 런타임때 String 정보가 사라져 알수 없어 에러남
}