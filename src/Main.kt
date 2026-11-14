import classes.CharacterClass
import classes.Character
import classes.Game
import rep.EnemyList

fun main() {

    println("- Welcome! -")
    println("Необходимо создать персонажа")
    print("Введите имя: ")
    val characterName = readlnOrNull()?.trim().orEmpty()

    if (characterName.isEmpty()) {
        println("Было введено пустое имя, пока!")

        return
    }

    print("Введите класс (Warrior, Mage, Rogue): ")
    val characterClassInput = readlnOrNull()?.trim().orEmpty().lowercase().replaceFirstChar { it.uppercase() }
    val characterClass = runCatching { CharacterClass.valueOf(characterClassInput) }
        .getOrElse {
            println("Неизвестный класс: $characterClassInput")

            return
        }

    val myCharacter = Character.create(characterName, characterClass)
    val enemies = EnemyList.createEnemyList()
    Game(character = myCharacter, enemies = enemies).start()
}