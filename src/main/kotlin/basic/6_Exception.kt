fun main() {

    try {
        throw Exception()
    } catch (e: Exception) {
        println("에러 발생!")
    } finally {
        println("finally 실행!")
    }

    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생 !")
    }
    println(a)

    //throw Exception("예외 발생!")

    val b: String? = null
    val c: String = b ?: failFast("a is null")

    // 엘비스 연산자와 Noting 타입을 같이 사용하면 null이 나오지 않음을 보장한다
    // c?.length (X)
    println(c.length)


}

fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}