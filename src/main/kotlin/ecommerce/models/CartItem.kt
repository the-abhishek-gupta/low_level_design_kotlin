package ecommerce.models

data class CartItem(val item: Product, var quantity: Int = 0)