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

    fun recieveRegularDmg(dmg: Int) {
        currentHealth = (currentHealth - dmg).coerceAtLeast(0)
    }
    fun recieveDmgFromSpell(dmg: Int) {
        currentHealth -= dmg
    }

    fun getStrForCurrentHP(): String = "HP: ${currentHealth}/${maxHealth}"

}