class Coffee(
    // var 변수는 getter/setter 자동 적용
    // val 변수는 getter 없이 setter만.
    var name: String = "",
    var price: Int = 0,
    var iced: Boolean = false,
) {

    // custom getter 함수
    // 새로운, 변경 불가능한 val 변수
    val brand: String
        get() {
            return "스타벅스"
        }

    // custom setter 함수
    // 새로운, 변경 가능한 var 변수
    var quantity : Int = 0
        set(value) {
            if (value > 0) { // 수량이 0 이상인 경우에만 할당
                field = value // field : getter/setter에서 사용하는 식별자. quantity에 해당 (Backing Field)
                // quantity = value // StackOverFlow 에러
            }
        }
}

class EmptyClass

fun main() {
    val coffee = Coffee()
    coffee.name = "아이스 아메리카노" // 자동 setter 적용
    coffee.price = 2000 // 자동 setter 적용
    coffee.quantity = 1 // custom setter 동작
    coffee.iced = true

    if (coffee.iced) {
        println("아이스 커피")
    }
    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")
}