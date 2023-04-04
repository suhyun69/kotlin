package advanced

/*
LateInit
가변 프로퍼티에 대한 지연초기화 제공
항상 가변 프로퍼티에 대해서 non-null 속성일 때에만.
*/

class `7_LateInit` {

    lateinit var text: String

    val textInitialized: Boolean
        get() = this::text.isInitialized // 내부에서만 사용 가능, 변수 새로 만들어서 쓰자

    fun printText() {
        /*
        if(this::text.isInitialized) {
            println("초기화됨")
        } else {
            println("안녕하세요"
        }
         */
        println(text)
    }
}

fun a (str:String, block: (String) -> Unit) {
    block(str)
}
fun main() {

    "".let {  }
    a("") {
        it.length
    }
    val test = `7_LateInit`()

    if (!test.textInitialized) {
        test.text = "하이요"
    }
    // test.text.isInitialized -> 실패
    test.printText()

}