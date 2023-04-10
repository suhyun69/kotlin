package advanced

/*
스코프함수

코틀린의 표준 라이브러리에는 객체의 컨텍스트 내에서 코드 블록을 실행하기 위해서만 존재하는 몇가지 함수가 포함되어 있는데 이를 스코프 함수라고 부른다
스코프 함수를 제대로 사용하면 불필요한 변수 선언이 없어지며 코드를 더 간결하고 읽기 쉽게 만든다
스코프 함수의 코드 블록 내부에서는 변수명을 사용하지 않고도 객체에 접근할 수 있는데 그 이유는 수신자 객체에 접근할 수 있기 때문이다
수신자 객체는 람다식 내부에서 사용할 수 있는 객체의 참조이다
스코프 함수를 사용하면 수신자 객체에 대한 참조로 this 또는 it을 사용한다

스코프 함수 선택 방법
코틀린은 5개의 유용한 스코프 함수를 제공하며 각 스코프 함수들은 본질적으로 유사한 기능을 제공한다

함수명	수신자 객체 참조 방법		반환값			확장 함수 여부
let		it 						함수의 결과		O
run		this					함수의 결과		O
with	this					함수의 결과		X
apply	this					컨텍스트 객체 	O
also	it 						컨텍스트 객체 	O

기본적으로 let은 null이 아닌 경우 사용될 로직을 작성하고, 거기에 따른 새로운 결과를 반환하고 싶을 때 사용
*/

fun main() {

    val str: String? = "안녕"

    val result: Int? = str?.let {
        println(it) // null이 아닌 경우에만 동작

        /*
        // let 안에 let 쓸 수도 있다
        val abc: String? = "abc"
        abc?.let{
            val def: String? = "def"
            def?.let{
                println("abcdef가 null 아님")
            }
        }
        */

        // let 안에 let 쓰는 건 가독성이 떨어지므로 전통적인 방식이 나을 수도 있다
        val abc: String? = "abc"
        val def: String? = "def"
        if (!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {
            println("abcdef가 null 아님")
        }


        1234 // return을 쓰진 않았지만 함수 마지막 1234가 반환값으로 여겨짐
    }
    println(result) // `1234


//    val this: String? = null // this는 변수명으로 사용 불가
//    val it : String? = null // it은 사용 가능


    val hello = "hello"
    val hi = "hi"

    // 중첩되 it을 사용할 때에는 별도로 변수를 지정
    hello.let { a : String ->

        //println(a.length)

        hi.let{ b ->
            println(a.length)
            println(b.length)
        }
    }

}