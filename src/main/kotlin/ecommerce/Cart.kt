package ecommerce

import ecommerce.models.CartItem
import ecommerce.models.Product

class Cart {

    private val items = mutableMapOf<String, CartItem>()

    fun addItem(product: Product, quantity: Int) {
        val itemInCart = items[product.getProductId()]
        if (itemInCart == null) {
            items[product.getProductId()] = CartItem(product, quantity)
        } else {
            itemInCart.quantity += quantity
        }
    }

    fun removeItem(productId: String) {
        items.remove(productId)
    }

    fun getCartItems(): List<CartItem> = items.values.toList()

    fun clearCart() {
        items.clear()
    }

}