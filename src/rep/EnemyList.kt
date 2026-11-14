package rep

import classes.Enemy
import classes.EnemyType

object EnemyList {
    fun createEnemyList(): MutableList<Enemy> = mutableListOf(
        Enemy(EnemyType.Rat, maxHealth = 10, currentHealth = 10, attackRate = 3, defenceRate = 1),
        Enemy(EnemyType.Boar, maxHealth = 20, currentHealth = 20, attackRate = 5, defenceRate = 3),
        Enemy(EnemyType.Goblin, maxHealth = 30, currentHealth = 30, attackRate = 7, defenceRate = 4),
        Enemy(EnemyType.Skeleton, maxHealth = 15, currentHealth = 15, attackRate = 5, defenceRate = 1),
        Enemy(EnemyType.Orc, maxHealth = 50, currentHealth = 50, attackRate = 15, defenceRate = 5)
    )
}