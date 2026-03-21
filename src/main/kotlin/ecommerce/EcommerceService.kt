package ecommerce

import com.azul.crs.client.Inventory
import ecommerce.models.CartItem
import ecommerce.models.InventoryItem
import ecommerce.models.Product
import ecommerce.models.User
import ecommerce.models.order.Order
import ecommerce.models.order.OrderItem
import ecommerce.models.order.OrderStatus
import ecommerce.strategy.PaymentStrategy
import ecommerce.strategy.PaymentStrategyImpl

class EcommerceService(
    private val paymentStrategy: PaymentStrategy = PaymentStrategyImpl()
) {
    private val usersMap = mutableMapOf<String, User>()
    private val productsMap = mutableMapOf<String, Product>()
    private val inventoryMap = mutableMapOf<String, InventoryItem>()
    private val cartsMap = mutableMapOf<String, Cart>()
    private val ordersMap = mutableMapOf<String, Order>()

    fun addUser(user: User) {
        usersMap[user.getUserId()] = user
        cartsMap[user.getUserId()] = Cart()
    }

    fun addProduct(product: Product, quantity: Int) {
        productsMap[product.getProductId()] = product
        inventoryMap[product.getProductId()] = InventoryItem(product, quantity)
    }

    fun searchProducts(keyword: String): List<Product> {
        return productsMap.values.filter { it.name.contains(keyword, ignoreCase = true) }
    }

    fun addToCart(user: User, product: Product, quantity: Int) {
        val cart = cartsMap[user.getUserId()] ?: Cart()
        cart.addItem(product, quantity)
    }

    fun getCart(userId: String): List<CartItem> {
        return cartsMap[userId]?.getCartItems() ?: emptyList()
    }

    fun placeOrder(user: User): Order? {
        val cart = cartsMap[user.getUserId()] ?: return null
        val items = cart.getCartItems()
        if (items.isEmpty()) return null
        for (each in items) {
            val stock = inventoryMap[each.item.getProductId()]?.quantity ?: 0
            if (stock < each.quantity) {
                println("Insufficient stock for ${each.item.name}")
                return null
            }
        }
        for (item in items) {
            inventoryMap[item.item.getProductId()]?.let {
                it.quantity -= item.quantity
            }
        }
        val orderItems = items.map {
            OrderItem(it.item, it.quantity, it.item.price)
        }
        val totalAmount = paymentStrategy.calculateTotal(items)
        val order = Order(
            user = user,
            items = orderItems,
            amount = totalAmount,
        )
        ordersMap[order.getOrderId()] = order
        cart.clearCart()
        return order
    }

    fun updateOrderStatus(orderId: String, status: OrderStatus) {
        val order = ordersMap[orderId] ?: return
        order.status = status
    }

    fun getOrder(orderId: String): Order? = ordersMap[orderId]
}