package advanced

/*
지연초기화
대상에 대한 초기화를 미뤘다가 실제 사용시점에서 초기화하는 기법
초기화 과정에서 자원을 많이 쓰거나 오버헤드가 발생할 경우 지연초기화를 사용하느 ㄴ게 유리
- 웹페이지에서 특정 스크롤에 도달했을 때 컨텐츠를 보여주는 무한 스크롤
- 싱글톤 패턴의 지연초기화
- JPA의 엔티티 LazyLoading 기능
*/

class HelloBot {

    // var greeting: String? = null // var 보다는 val
    // val greeting: String by lazy { getHello() }
    // by lazy는 언제나 val
    // 멀티스레드 환경에서 안전하게 동작하는 것을 보장하기 위해서.
    val greeting: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        // by lazy로 초기화 된 로직은 한 번만 실행. 그 이후에는 실행된 값 다시 실행.
        println("초기화 로직 수행") // 1번만 실행
        getHello()
    }
    
    // LazyThreadSafetyMode.SYNCHRONIZED 
    // 디폴트

    // LazyThreadSafetyMode.None
    // 초기화 로직 여러 번 수행
    // 멀티스레드 환경 아닐 경우, 스레드에 대한 동기화가 오버헤드일 수 있다.
    
    // LazyThreadSafetyMode.PUBLICATION
    // 멀티스레드 환경이어도 동기화가 필요하지 않을 경우

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()
    // helloBot.greeing = getHello()

    // ...
    // ...
    for (i in 1..5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }

}