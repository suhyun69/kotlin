import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun main() {

    // immutable
    val currencyList = listOf("달러", "유로", "원")


    // mutable
    // val mutableCurrencyList: MutableList<String> = mutableListOf<String>()
    val mutableCurrencyList: MutableList<String> = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    mutableCurrencyList.add("파운드")


    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }


    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2)

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    mutableNumberMap["two"] = 2
    mutableNumberMap["three"] = 3
    mutableNumberMap.put("four", 4) // 추천 안 함



    // 컬렉션 빌더는 내부에선 mutable 반환은 immutable
    val numberList: List<Int> = buildList{
        add(1)
        add(2)
        add(3)
        add(4)
    }


    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }


//    val iterator = currencyList.iterator()
//    while (iterator.hasNext()) {
//        println(iterator.next())
//    }
//
//    println("===============")
//
//    for (currency in currencyList) {
//        println(currency)
//    }
//
//    println("===============")
//
//    currencyList.forEach {
//        println(it) // it: 람다?
//    }

    // for loop -> map
    val lowerList = listOf("a","b","c")
    //val upperList = mutableListOf<String>()

//    for (lowerCase in lowerList) {
//        upperList.add(lowerCase.uppercase())
//    }

    val upperList = lowerList.map { it.uppercase() }

    //val filteredList = mutableListOf<String>()
//    for (upperCase in upperList) {
//        if (upperCase == "A" || upperCase == "C" ) {
//            filteredList.add(upperCase)
//        }
//    }
    val filteredList = upperList
        .asSequence() // java8 stream과 유사
        .filter { it == "A" || it == "C" }
        .filter { it == "D" } // chain이나 다루는 데이터가 많을 경우 asSequence를 사용하는 게 메모리 절약에 좋다
        .filter { it == "D" }
        .filter { it == "D" }
        .filter { it == "D" }
        .filter { it == "D" }
        .toList() //

    // 이 방식도 동작한다.
    // val filteredList = upperList.filter { it == "A" || it == "C" }

    println(filteredList)






}