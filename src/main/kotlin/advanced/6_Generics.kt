package advanced

class MyGenerics<out T>(val t: T) {

}

class Bag<T> {

    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {

    // T는 String
    val bag = Bag<String>()
    // to: MutableList<T>
    // 컴파일 오류 발생
    // 반공변성 도입
    // Consumer. Generic을 사용하는 측
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))

    // MyGenerics<T>
    // CharSequence는 String의 상위개념.
    // CharSequence를 넣어도 이슈 없을 것 같지만, 컴파일 오류 발생
    // MyGenerics<out T> // 공변성 도입 -> 오류 없음
    // Producer. Generic을 제공하는 측
    val generics = MyGenerics<String>("테스트")
    val charGenerics : MyGenerics<CharSequence> = generics

    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 타입아규먼트를 제공
    val generics2 = MyGenerics<String>("테스트")

    //  타입아규먼트 생략가능
    val generics3 = MyGenerics("테스트")

    //변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()
    // 타입아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    // 어떤 타입이 들어올 지 모를 때 : star projection?
    val list3 : List<*> = listOf<String>("테스트")
    val list4: List<*> = listOf<Int>(1, 2, 3, 4)

    // 변성.
    // PECS는 Producer-Extends, Consumer-Super
    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    // 반공변성은 자바 제네릭의 super 코틀린에선 in
    // 무공변성

}