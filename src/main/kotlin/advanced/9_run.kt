package advanced

/*
run같은 경우는 수신 객체 프로퍼티를 구성하거나 새로운 결과를 반환하고 싶을 때 사용
*/

class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    // DB에 접속하고 Boolean 결과를 반환
    fun connect(): Boolean {
        println("DB 접속 중 ...")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }
}

fun main() {
    
      // 전통적인 방식
//    val config = DatabaseClient()
//    config.url = "localhost:3306"
//    config.username = "mysql"
//    config.password = "1234"
//    val connected = config.connect()
//    println(connected) // true

    val connected: Boolean = DatabaseClient().run {
        // this.url = "localhost:3306" // this 자동 적용
        // 이 안의 수신자 객체는 DatabaseClient가 된다
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect() // let과 동일하게 함수의 마지막 부분리 run의 반환값이 된다
    }
    println(connected) // true

    // Boolean : connect()의 반환타입
    val connected2: Boolean = DatabaseClient().let {
        // let으로도 쓸 수 있지만, it을 붙여야 한다
        it.url = "localhost:3306"
        it.username = "mysql"
        it.password = "1234"
        it.connect() // let과 동일하게 함수의 마지막 부분리 run의 반환값이 된다
    }
    println(connected) // true


    // Boolean : connect()의 반환타입
    val result: Boolean =  with(DatabaseClient()) {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }
    println(result)

}