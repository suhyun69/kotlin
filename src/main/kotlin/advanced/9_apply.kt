package advanced

/*
apply는 수신 객체 프로퍼티를 구성하고, 수신 객체 결과를 그대로 반환하고 싶을 때 사용
context 객체에 대한 내부 프로퍼티를 초기화/수정할 때 사용
*/

fun main() {

    val client: DatabaseClient = DatabaseClient().apply{
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }
    print(client) // DatabaseClient 객체

    val connected = client.connect()
    print(connected) // true

    DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }.connect()
        .run { println(this) }


}
