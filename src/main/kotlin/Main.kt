
fun main(args: Array<String>) {
    println("Добро пожаловать в ваш архив заметок!")
    printMenu(arhivesMenu)
}

fun printMenu(menu: Map<Int, String>) {
    println("Что желаете выбрать?")
    menu.forEach {(key, name) -> println("'$key' - $name")}
}
