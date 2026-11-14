package classes

enum class Item(
    val displayName: String,
    val restoreAmount: Int = 0
) {
    HealthPotion(restoreAmount = 100, displayName = "Зелье лечения"),
    ManaPotion(restoreAmount = 70, displayName = "Зелье маны")
}