// data : 데이터를 보관/전달하는 목적을 가진 객체
// ex) dto
// data를 선언하면 Compiler가 자동으로 생성해주는 함수가 있다.
// equals,  hashcode, toString, componentN, copy 등등

// 필요한 이유?
// equals,  hashcode, toString 자동 생성
// equals : 객체에 대한 동등성 비교

// class Person(val name: String, val age: Int) { }

data class Person(var name: String, val age: Int) {

}

fun main() {
    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)
    print(person1 == person2) // true

    val set = hashSetOf(person1)
    println(set.contains(person2)) // true

    println(person1.toString()) // Person(name=tony, age=12)

    person1.name = "strange"
    println(set.contains(person1)) // false -> 값이 변경되었으므로, hashSet도 달라진다

    val person3 = person1.copy() // name = "tony", age = 12
    // var person3 = person1.copy(name="strange") // name = "strange", age = 12

    // componentN -> N은 숫자
    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    // 구조분해 할당
    val (name, age) = person1
    println("이름=${name}, 나이=${age}")
}