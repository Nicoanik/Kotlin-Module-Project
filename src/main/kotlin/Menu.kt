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

val notesActionMenu = mapOf(
    0 to "Редактировать заметку",
    1 to "Прочитать заметку",
    2 to "Вернутся назад"
)

fun printMenu(menu: Map<Int, String>) {
    menu.forEach { (key, name) -> println("'$key' - $name") }
    println()
}

fun <Int, U> printActionMenu(menu: Map<Int, U>) {
    menu.forEach { (key, text) -> println("'$key' - ${text.name}") }
}
