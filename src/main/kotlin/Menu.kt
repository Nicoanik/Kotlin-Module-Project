val archivesMenu = mapOf(
    0 to "Создать архив",
    1 to "Открыть архив",
    2 to "Выйти из программы"
)

val notesMenu = mapOf(
    0 to "Создать заметку",
    1 to "Открыть заметку",
    2 to "Вернуться назад"
)

fun printMenu(menu: Map<Int, String>) {
    menu.forEach { (key, name) -> println("'$key' - $name") }
    println()
}
