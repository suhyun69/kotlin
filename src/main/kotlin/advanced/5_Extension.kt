/*
확장 함수
kotlin은 상속이나 데코레이터 패턴을 사용하지 않아도 클래스 확장이 가능하다
 */

// "확장의 대상이 되는 클래스"."변수 및 함수"
// 문자열의 첫 요소를 가져와서 char 형으로 리턴하는 확장 함수
fun String.first() : Char {
    return this[0] // this -> 확장이 되는 대상에 대한 참조. receiver or 수신자 객체.
}

fun String.addFirst(char: Char) : String {
    return char + this.substring(0)
}

class MyExample {
    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage() = println("1234")
fun MyExample.printMessage(message:String) = println(message)

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {
    var myExample: MyExample? = null
    myExample.printNullOrNotNull()

    myExample = MyExample()
    myExample.printNullOrNotNull()

    MyExample().printMessage() // 클래스 출력 -> 원본 메서드 실행
    // MyExample().printMessage("확장 출력") // 확장 출력

    // println("ABCD".first())
    // println("ABCD".addFirst('Z'))
}