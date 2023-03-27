/*
싱글톤
싱글톤 패턴은 클래스의 인스턴스를 하나의 단일 인스턴스로 제한하는 디자인 패턴이다
싱글톤 패턴을 구현할 때는 몇 가지 제약사항을 통해 구현한다
> 직접 인스턴스화 하지 못하도록 생성자를 private으로 숨긴다
> getInstance()라는, 클래스의 단일 인스턴스를 반환하는 static 메서드를 제공한다
> 멀티-스레드 환경에서도 안전하게 유일한 인스턴스를 반환해야 한다

다양한 구현 방법들
> DCL(Double Check Locking) : JVM 환경에선 거의 사용 안함
> Enum 싱글톤 : 이펙티브 자바에서 소개
> 이른 초기화(Eager)
> 지연 초기화(Lazy)
*/

import java.time.LocalDateTime

/*
// kotlin은 객체 선언이라는 문법을 통해 singleton을 기본 지원
// object 키워드 사용 -> singleton 객체 생성
object Singleton {

    val a = 1234

    fun printA() = println(a)
}

fun main() {
    println(Singleton.a)
    Singleton.printA()
}
*/

/*
// singleton 기반의 Utility 생성
object DatetimeUtils {

    val now : LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime) : Boolean {
        return a == b
    }
}

fun main() {
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)

    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))
}
*/

// 동반 객체
// companion object 키워드 사용
// 클래스 내부에서 생성되는 객체
class MyClass {

    private constructor() // 생성자를 private으로 묶어서, 직접 생성 못 하게

    // 동반 객체는 이름을 가질 수 있다 : MyCompanion
    companion object MyCompanion { 
        val a = 1234

        fun newInstance() = MyClass() // MyClass 생성자 역할

    }
}

fun main() {
    println(MyClass.a)
    println(MyClass.newInstance())

//    println(MyClass.Companion.a)
//    println(MyClass.Companion.newInstance())

    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())
}