class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

// kotlin에서는 interface에 property도 존재할 수 있다
interface Cart : Wheel {

    // 추상 property
    // 구현 클래스에서 필수로 추가해야 한다
    var coin: Int

    // interface의 경우 backing field 사용 시 compile error 발생
    val weight: String
        get() = "20KG"

    fun add(product: Product)

    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다")
        }
    }

    // interface가 다른 interface를 상속 가능
    // Wheel.roll 구현
    override fun roll() {
        println("카트가 굴러갑니다")
    }

    fun printId() = println("1234")
}

interface Order {

    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다")
    }

    fun printId() = println("5678")

}

// 복수 개 interface 상속 가능
// interface 상속 시 "()" 제외
class MyCart(override var coin: Int) : Cart, Order {

    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가됐습니다")

        // 주문하기
        // 상위 클래스 호출
        super<Order>.add(product)
    }

    // 2개 이상의 interface에서 동일한 메서드를 가질 경우, 하위 클래스에서 재정의 필수
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }

}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId()
}