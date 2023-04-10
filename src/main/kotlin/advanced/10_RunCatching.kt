package advanced

/*
코틀린은 try~catch 외에도 함수형 스타일의 result 패턴을 구현한 runCatching을 제공
result 패턴 : 함수가 성공하면 캡슐화된 결과를 반환하거나 예외가 발생하면 지정한 작업을 수행하는 패턴.
runCatching 안에서 사용하는 코드는 try 안에서 사용하는 코드와 동일하다
*/

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {

    val result1 = try {
        getStr()
    } catch (e: Exception) {
        println(e.message) // 예외 발생 기본 값으로 초기화
        "기본값"
    }
    println(result1) // 기본값

    val result = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"
        }
    println(result)

    val result2 = runCatching { "성공" }
        .getOrNull() // 성공인 경우 그 값을 그대로 받고, 실패인 경우 null 반환
    println(result2) // null

    val result3: Throwable? = runCatching { getStr() }
        .exceptionOrNull() // 성공일 때 null, 실패일 때 throwable
    result3?.let {
        println(it.message)
        throw it
    }

    val result4 = runCatching { getStr() }
        .getOrDefault("기본 값")
    println(result4)

    val result5 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본 값"
        }
    println(result5)

    val result6: String = runCatching { "성공" }
        .getOrThrow()
    println(result6)

    // 성공인 경우 원하는 값으로 변경 가능
    val result7 = runCatching { "안녕" }
        .map {
            "${it}하세요"
        }.getOrThrow()
    println(result7)

    // map 안에서 예외가 발생하면 getOrDefault로 수정할 수 없다
    var result75 = runCatching { "안녕" }
        .map {
            throw Exception("예외")
        }.getOrDefault("기본 값")
    
    // mapCatching을 사용하면 map 안에서 예외가 발생해도 수정 가능
    val result8 = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }.getOrDefault("기본 값")
    println(result8)

    // map은 성공 시 원하는 값으로 변경
    // recover는 실패 시 원하는 값으로 변경
    val result9 = runCatching { getStr() }
        .recover {
            "복구"
        }
        .getOrNull()
    println(result9)

    val result10 = runCatching { getStr() }
        .recoverCatching {
            throw Exception("예외")
        }
        .getOrDefault("복구")
    println(result10)
}
// 예외 발생 기본 값으로 초기화
// 기본값
