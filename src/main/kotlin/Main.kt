import java.awt.Menu

fun main(args: Array<String>) {
    println("Добро пожаловать!\nДавайте сохраним ваши мысли! :)")
    val menu = Menu()
    menu.
}

class Menu{
    private val arhivesMenu = mapOf(
        0 to "Создать архив",
        1 to "Открыть архив",
        2 to "Выйти из программы"
    )

    private val notesMenu = mapOf(
        0 to "Создать заметку",
        1 to "Открыть заметку",
        2 to "Вернуться назад"
    )

    private val notesActionMenu = mapOf(
        0 to "Редактировать заметку",
        1 to "Прочитать заметку",
        2 to "Вернутся назад"
    )
    fun printMenu(menu: Map<Int,String>) {
        for(key in menu) {
            println("'$key' - $menu")
        }
    }
}