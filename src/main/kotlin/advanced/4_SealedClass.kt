/*
Sealed Class
하나의 상위 클래스 또는 인터페이스에서 하위 클래스로의 정의를 제한할 수 있는 방법
 */

// abstract에서 sealed로 변경하면, when 구문에서 else가 없어도 컴파일 오류 없음
// sealed class -> compile 시점에 오류 결정
// 같은 패키지 및 모듈 안에 있어야 적용
sealed class Developer {

    abstract val name: String
    abstract fun code(language: String)

}

data class BackendDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용합니다")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다 ${language}를 사용합니다")
    }
}

object OtherDeveloper : Developer() {

    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not yet implemented")
    }

}

data class AndroidDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다 ${language}를 사용합니다")
    }
}


data class IosDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 Ios 개발자입니다 ${language}를 사용합니다")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper ->  pool[developer.name] = developer
        is IosDeveloper ->  pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지않는 개발자종류입니다")
        else -> {} // sealed 클래스 때문에 else 필요없다고 했는데, 왜 이러지
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name="토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name="카즈야")
    DeveloperPool.add(frontendDeveloper)

    val androidDeveloper = AndroidDeveloper(name="안드로")
    DeveloperPool.add(androidDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("카즈야"))
    println(DeveloperPool.get("안드로"))


}