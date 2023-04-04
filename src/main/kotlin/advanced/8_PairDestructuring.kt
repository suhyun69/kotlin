package advanced

// f((1, 3)) = 1 + 3 = 4
// f(1, 3) = 1 + 3 = 4

//data class Tuple(val a : Int, val b: Int)

fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    //println(plus(1,3))
    val plus = plus(Pair(1, 3))
    println(plus)

    val pair = Pair("A", 1)
    // pair.first = "B" -> 오류
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList() // 확장함수. immutable 형태 불변 리스트 제공
    println(list)

    val triple = Triple("A","B","C")
    println(triple)
    triple.first
    triple.second
    val newTriple = triple.copy(third = "D")
    println(newTriple)

    println(newTriple.component3())

    // 구조 분해 할당 : 한 줄에 변수 3개 할당 가능
    // val (a, b, c) = newTriple // 가능
    val (a: String, b: String, c: String) = newTriple
    println("$a, $b, $c")

    val list3: List<String> = newTriple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")

    // 리스트는 5개의 ComponentN 함수 제공
    list3.component1()
    list3.component2()
    list3.component3()
//    list3.component4()
//    list3.component5()

    val map = mutableMapOf(Pair("이상훈", "개발자"))
    for ( (key, value) in map ) {
        println("${key}의 직업은 $value")
    }
}