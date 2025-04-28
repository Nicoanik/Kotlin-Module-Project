import java.util.Scanner

fun scannerInt(menu: Map<Int, String>?): Int {
    while (true) {
        if (menu != null) printMenu(menu)
        println("Введите номер действия:")
        val scanner = Scanner(System.`in`)
        if (scanner.hasNextInt()) return scanner.nextInt() else println(Message.NOT_NUMBER.text)
    }
}

fun scannerString(message: String): String {
    while (true) {
        println(message)
        val scanner = Scanner(System.`in`).nextLine()
        if (scanner.isNotEmpty()) return scanner else println(Message.EMPTY.text)
    }
}