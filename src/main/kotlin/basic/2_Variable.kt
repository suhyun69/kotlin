// TopLevel 변수
var x = 5

fun main() {

    x += 1
    println(x)

    val a : Int = 1
    val b = 1

    // 지연 할당
    val c : Int
    c = 3

    // val(value) : 한 번 갑을 초기화 한 이후에는 초기화 불가. Read Only
    // var(variable) : 가변, 재할당 가능

    var e : String = "Hello"
    e = "World"

    // 한 번 타입이 고정되면, 타입은 변경 불가
    var f = 123
    // f = "hi"

}