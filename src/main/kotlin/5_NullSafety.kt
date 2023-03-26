fun main() {

//    val a : String = null
//    var b : String = "aabbcc"
//    b = null

    var a : String? = null
    // a.length
    a?.length
    println(a?.length) // "null"

    var b: Int = if (a != null) a.length else 0
    println(b)

    // 엘비스 연산자
    var c  = a?.length ?: 0
    println(c)
}