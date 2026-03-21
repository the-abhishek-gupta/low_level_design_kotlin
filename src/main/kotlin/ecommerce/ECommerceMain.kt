package ecommerce

import ecommerce.models.Product
import ecommerce.models.User
import ecommerce.models.order.OrderStatus

class ECommerceMain {
    fun main() {
        val service = EcommerceService()

        val user = User(name = "Abhishek")
        service.addUser(user)

        val p1 = Product(name = "iPhone", price = 80000.0)
        val p2 = Product(name = "Laptop", price = 120000.0)

        service.addProduct(p1, 5)
        service.addProduct(p2, 3)

        println("Search results: ${service.searchProducts("phone")}")

        service.addToCart(user, p1, 1)
        service.addToCart(user, p2, 1)

        println("Cart: ${service.getCart("U1")}")

        val order = service.placeOrder(user)
        println("Order placed: $order")

        service.updateOrderStatus(order!!.getOrderId(), OrderStatus.SHIPPED)
        println("Order after update: ${service.getOrder(order.getOrderId())}")
    }
}