// kotlin에서 모든 클래스의 조상은 Any
// kotlin의 클래스는 기본적으로 final (상속 불가)
// 따라서 kotlin의 클래스는 기본적으로 상속이 불가하나, open이라는 키워드로 상속 허용

// open : 상속이 가능한 상태
open class Dog { 
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

/*
open class BullDog : Dog() {
    override  var age  : Int = 0
    
    override fun bark() {
        println("컹컹")
    }
}

->
open class Bulldog(override var age : Int = 0): Dog() {
    override fun bark() {
        println("컹컹")
    }
}
*/

// kotlin에서, override 된 변수나 메서드는 자동으로 open이 적용된다
// fianl 키워드 추가
open class Bulldog(final override var age: Int = 0) : Dog() {

    final override fun bark() {
        // println("컹컹")
        super.bark() // 하위 클래스에서 상위 클래스 접근
    }
}

/*
// 추상 클래스 : abstract
abstract class Developer {

    abstract var age: Int
    abstract fun code(language: String)

}

class BackendDeveloper(override var age : Int) : Developer() {

    override fun code(language: String) {
        println("I code with $language")
    }
}

fun main() {
    val backendDeveloper = BackendDeveloper(age = 20)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")


    val dog = Bulldog(age = 2)
    println(dog.age)
    dog.bark()

}

 */