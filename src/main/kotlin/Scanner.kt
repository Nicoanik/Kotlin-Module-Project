import java.util.Scanner

fun scannerInt(message: String?, menu: Map<Int, String>?): Int {
    while (true) {
        if (message != null) println(message)
        if (menu != null) printMenu(menu)
        println("Введите номер действия:")
        val scanner = Scanner(System.`in`)
        if (scanner.hasNextInt()) return scanner.nextInt() else println("Необходимо вводить только цифры!!!\nПопробуйте ещё раз...\n")
    }
}

fun scannerString(message: String): String {
    while (true) {
        println(message)
        val scanner = Scanner(System.`in`).nextLine()
        if (scanner.isNotEmpty()) return scanner else println("Поле не может быть пустым!!!\nВведите текст...\n")
    }
}