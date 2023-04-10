package advanced

fun main() {

    val list = mutableListOf(printHello)
    list[0]() // 리스트 첫 번째 요소가 함수. Hello

    // 함수도 타입이다
    // () -> Unit
    // () -> String
    val func: () -> Unit = list[0]
    func()
    // 리스트에서 빼서, 변수에 대입해서 실행 가능

    // 함수를 다른 함수의 인자로 넣을 수도 있다
    call(printHello)

    // fun으로 선언한 함수는 1급 객체의 특성인 함수를 인자로 넘기거나 결과로 반환하거나 값처럼 취급한다는 특징을 가지지 않으므로 에러 발생
    // 함수형 프로그래밍에 1급 객체의 특성을 사용하려면 val을 사용할 것
//    val func = printNo
//    val list = mutableListOf(printNo)
//    call(printNo)

    val result: Int = plus(1, 3, 5)
    println(result)

    /*
        고차함수 : 함수를 인자로 받거나 결과로 돌려주는 함수
    */
    val abcList = listOf("a", "b", "c")
    val printStr : (String) -> Unit = { println(it) }
    forEachStr(abcList, printStr)

    // 후행 람다 전달
    // 함수의 마지막 인자가 함수일 때 사용
    forEachStr(abcList) {
        println(it.length)
    }

    // foreach도 고차함수
    abcList.forEach {
        println(it)
    }

    abcList.filter {
        it == "a"
    }

    outerFunc() // 내부 익명함수를 호출한 게 아니다 -> 2번 호출해야 함
    outerFunc()() // 이것은 익명함수!

    val func2 = outerFunc()
    func2() // 이것은 익명함수!

    arg1{
        it.length
        it.first()
    }

    // 인자가 2개이므로 it 사용 불가
    arg2 { a: String, b: String ->
        a.length
        b.first()
    }

    // 람다 레퍼런스
    // 가독성 좋게 함수를 인자로 넘길 수 있다
    val callReference1 : () -> Unit = { printHello() }
    callReference1()  // Hello

    // :: -> 람다 레퍼런스 구문
    val callReference2 = ::printHello
    callReference2()() // 2번 호출

    val numberList = listOf("1", "2", "3")
    //numberList.map { it.toInt() }.forEach { println(it) }

    numberList.map(String::toInt).forEach(::println)

}

val printHello : () -> Unit = { println("Hello") }

fun arg1(block: (String) -> Unit) {}

fun arg2(block: (String, String) -> Unit) {}

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
val sum_: (Int, Int) -> Int = { x, y -> x + y } // 인자 타입이 어딘가에는 정의되어야 함

// 최대한 생략한 람다 식
val sum2 = {x: Int , y: Int  -> x + y }

/*
fun outerFunc() : () -> Unit {
    return fun() {
        println("이것은 익명함수!");
    }
}
 */
// 람다로 바꾸면 (return fun 빼고 함수 블록만 선언)
fun outerFunc() : () -> Unit = { println("이것은 익명함수!") }


val printMessage: (String) -> Unit = { message: String -> println(message) }
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }

val plus : (Int, Int, Int) -> Int = { a, b, c -> a + b + c }


val func : () -> String = { "" }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

fun printNo() = println("No!")