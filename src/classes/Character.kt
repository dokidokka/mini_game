package classes

enum class CharacterClass { Warrior, Mage, Rogue }

class Character(
    val displayName: String,
    val characterClass: CharacterClass,
    var attackRate: Int,
    val maxHealth: Int,
    var currentHealth: Int,
    val maxMana: Int,
    var currentMana: Int,
    var inventory: MutableList<Item>
) {

    val alive: Boolean get() = currentHealth > 0

    fun recieveDmg(dmg: Int) {
        currentHealth = (currentHealth - dmg).coerceAtLeast(0)
    }

    fun useItem(item: Item): Boolean {
        if (!inventory.remove(item)) return false
        when (item) {
            Item.HealthPotion -> currentHealth = (currentHealth + item.restoreAmount).coerceAtMost(maxHealth)
            Item.ManaPotion -> currentMana = (currentMana + item.restoreAmount).coerceAtMost(maxMana)
        }
        return true
    }

    fun create(name: String, characterClass: CharacterClass): Character = when (characterClass) {
        CharacterClass.Warrior -> Character(
            displayName = name,
            characterClass = characterClass,
            attackRate = 10,
            currentHealth = 200, maxHealth = 200,
            currentMana = 0, maxMana = 0,
            inventory = mutableListOf(Item.HealthPotion, Item.HealthPotion)
        )
        CharacterClass.Rogue -> Character(
            displayName = name,
            characterClass = characterClass,
            attackRate = 30,
            currentHealth = 100, maxHealth = 100,
            currentMana = 0, maxMana = 0,
            inventory = mutableListOf(Item.HealthPotion)
        )
        CharacterClass.Mage -> Character(
            displayName = name,
            characterClass = characterClass,
            attackRate = 20,
            currentHealth = 50, maxHealth = 50,
            currentMana = 100, maxMana = 100,
            inventory = mutableListOf(Item.HealthPotion, Item.ManaPotion)
        )
    }

}