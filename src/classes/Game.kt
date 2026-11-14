package classes

class Game (
    private val character: Character,
    private val enemies: MutableList<Enemy>
) {

    fun start() {
        println()
        println("- Game start! -")

        while(character.alive) {

            if (enemies.isEmpty()) {
                println()
                println("- Game completed! Grats -")

                return
            }

            val enemy = enemies.first()
            printInfo(enemy)

            when(readCommand()) {
                "1" -> attackEnemy(enemy)
                "2" -> drinkHealtPotion()
                "3" -> drinkManaPotion()
                "4" -> castSpell(enemy)
                else -> println("Неизвестная команда")
            }

            if (!enemy.alive) {
                println("${enemy.type.displayName} сражен!")
                enemies.removeFirst()
            }

        }

        println()
        println("- Game over! Try again next time -")

        return

    }

    private fun printInfo(enemy: Enemy) {
        println()
        println("Дикий ${enemy.type.displayName}! ${enemy.getStrForCurrentHP()}")
        println("Против ${character.displayName}! ${character.getStrForCurrentHP()} ${character.getStrForCurrentMP()}")
        println("Cодержимое инвентаря: ${character.printInventory()}")
        println("1. Атаковать противника")
        println("2. Выпить зелье лечения")
        println("3. Выпить зелье маны")
        println("4. Кастануть фаербол")
        print("Ваш выбор: ")
    }

    private fun readCommand(): String = readlnOrNull()?.trim() ?: ""

    private fun attackEnemy(enemy: Enemy) {
        val dmg = (character.attackRate - enemy.defenceRate).coerceAtLeast(0)
        enemy.recieveRegularDmg(dmg)

        println("Вы нанесли $dmg урона врагу!")

        if (enemy.alive)
        {
            println("Враг все еще стоит на ногах...")
            attackCharacter(enemy)
        }
    }

    private fun attackCharacter(enemy: Enemy) {
        val dmg = enemy.attackRate
        character.recieveDmg(dmg)

        println("Вас бьют в ответ! Вам нанесли $dmg урона!")
        println(character.getStrForCurrentHP())
    }

    private fun drinkHealtPotion() {
        if (!character.inventory.contains(Item.HealthPotion)) {
            println("Вам нечего пить")

            return
        }

        if (character.currentHealth >= character.maxHealth) {
            println("Ваше HP уже полно")

            return
        }

        character.useItem(Item.HealthPotion)
        println("Вами было выпито зелье лечения. ${character.getStrForCurrentHP()}")
    }

    private fun drinkManaPotion() {
        if (!character.inventory.contains(Item.ManaPotion)) {
            println("Вам нечего пить")

            return
        }

        if (character.currentMana >= character.maxMana) {
            println("Ваше MP уже полно")

            return
        }

        character.useItem(Item.ManaPotion)
        println("Вами было выпито зелье маны. ${character.getStrForCurrentMP()}")
    }

    private fun castSpell(enemy: Enemy) {
        val spellCost = 10
        val spellDmg = 25

        if (character.currentMana == 0) {
            println("У вас нет MP")

            return
        }

        if (character.currentMana < spellCost) {
            println("У вас не хватает MP для чтения заклинания")

            return
        }

        character.currentMana -= spellCost
        enemy.recieveDmgFromSpell(spellDmg)
    }
}