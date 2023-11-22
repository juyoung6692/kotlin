package delegate

interface Fruit {
    val name: String
    val color: String
    fun bite()
}

class Apple : Fruit {
    override val name = "사과"
    override val color: String
        get() = "빨간색"

    override fun bite() {
        println("한입~~")
    }
}

class GreenApple(
    private val apple: Apple
):Fruit by apple{
    override val color: String
        get() = "초록색"
}