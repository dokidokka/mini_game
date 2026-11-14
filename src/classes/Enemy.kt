package classes

enum class EnemyType (val displayName: String) {
    Rat("Крысюк"),
    Boar("Кабан"),
    Goblin("Гоблин"),
    Orc("Орк"),
    Skeleton("Скелет")
}

class Enemy(
    val type: EnemyType,
    val maxHealth: Int,
    var currentHealth: Int,
    val attackRate: Int,
    val defenceRate: Int
) {

    val alive: Boolean get() = currentHealth > 0

    fun recieveDmg(dmg: Int) {
        currentHealth = (currentHealth - dmg).coerceAtLeast(0)
    }

}