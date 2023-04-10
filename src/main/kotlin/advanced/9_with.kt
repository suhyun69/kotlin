package advanced

/*
with는 결과 반환 없이 내부에서 수신 객체를 이용해 다른 함수를 호출하고 싶을 때 사용한다
확장 함수가 아니다
with에 객체를 전달해줘야 한다
*/
fun main() {

    val str = "안녕하세요"

    with(str) {
        println("length=$length")
    }

    val length: Int = with(str) {
        length // 함수의 마지막에 작성한 코드가 반환값.
    }
    println(length) // 5
}