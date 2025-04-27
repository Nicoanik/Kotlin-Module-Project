import java.util.Scanner

fun main(args: Array<String>) {
    println("Добро пожаловать в архив заметок!")
    archiveMenu()
    println("Спасибо за заметки! :)\nДо cвидания!")
}

fun printMenu(menu: Map<Int, String>) {
    menu.forEach { (key, name) -> println("'$key' - $name") }
}

class Note(val name: String, val text: String)

class Archive(val name: String) {
    val notes = mutableMapOf<Int, Note>()
}

val archives = mutableMapOf<Int, Archive>()

fun createArchive() {
    val name = scannerString("Создаём новый архив!\nВведите название:")
    archives[archives.size] = Archive(name)
    println("Архив '$name' создан!")
}

fun createNote(key: Int, notes: Map<Int, Note>) {
    val name = scannerString("Создаём новую заметку!\nВведите название:")
    val text = scannerString("Введите текст заметки:")
    archives[key]!!.notes[notes.size] = Note(name, text)
    println("Заметка '$name' создана!")
}

fun scannerInt(message: String?, menu: Map<Int, String>?, text: String): Int {
    while (true) {
        if (message != null) println(message)
        if (menu != null) printMenu(menu)
        println(text)
        val scanner = Scanner(System.`in`).nextLine()
        if (scanner.matches(Regex("[0-9]+"))) {
            return scanner.toInt()
        } else {
            println("Нужно ввести цифру от '0' и выше!!!\nПопробуйте ещё раз...")
        }
    }
}

fun scannerString(text: String): String {
    while (true) {
        println(text)
        val scanner = Scanner(System.`in`).nextLine()
        if (scanner.isNotEmpty()) {
            return scanner
        } else {
            println("Поле не может быть пустым!!!\nВведите текст...")
        }
    }
}

fun archiveMenu() {
    while (true) {
        when (val scanner = scannerInt(null, archivesMenu, "Введите номер действия:")) {
            0 -> createArchive()

            1 -> if (archives.isNotEmpty()) archivesActionMenu() else println("Нужно создать хотя бы один архив!!!")

            2 -> break

            else -> println("Нет такого номера!\nПопробуйте ещё раз...")
        }
    }
}

fun archivesActionMenu() {
    while (true) {
        println("Список ваших архивов:")
        archives.forEach { (key, archive) -> println("'$key' - ${archive.name}") }
        println("'${archives.size}' - 'Вернуться назад'")
        when (val scanner = scannerInt(null, null, "Введите номер действия:")) {
            in 0 until archives.size -> notesMenu(scanner, archives[scanner]!!.notes)
            archives.size -> break
            else -> println("Нет такого номера!!!\nПопробуйте ещё раз...")
        }
    }
}

fun notesMenu(key: Int, notes: Map<Int, Note>) {
    while (true) {
        when (val scanner = scannerInt(
            "Мы находимся в архиве '${archives[key]!!.name}':",
            notesMenu,
            "Введите номер действия:"
        )) {
            0 -> createNote(key, notes)

            1 -> if (notes.isNotEmpty()) notesActionMenu(
                key,
                notes
            ) else println("Здесь ещё нет заметок!!!\nПопробуйте её создать...")

            2 -> break
        }
    }
}

fun notesActionMenu(key: Int, notes: Map<Int, Note>) {
    while (true) {
        println("Список заметок в архиве '${archives[key]!!.name}':")
        notes.forEach { (key, note) -> println("'$key' - ${note.name}") }
        println("'${notes.size}' - 'Вернуться назад'")
        when (val scanner = scannerInt(
            null,
            null,
            "Введите номер действия:"
        )) {
            in 0 until notes.size -> printNote(scanner, archives[key]!!.notes)
            notes.size -> break
            else -> println("Нет такого номера!!!\nПопробуйте ещё раз...")
        }
    }
}

fun printNote(key: Int, notes: Map<Int, Note>) {
    println("Заметка '${notes[key]!!.name}':\n'${notes[key]!!.text}'")
}

fun <T, U> actionMenu(message: String, key: Int, map: Map<T, U>) {
    while (true) {
        println(message)
        map.forEach { (key, name) -> println("'$key' - ${name.name}") }
        println("'${map.size}' - 'Вернуться назад'")
        when (val scanner = scannerInt(
            null,
            null,
            "Введите номер действия:"
        )) {
            in 0 until map.size -> printNote(scanner, archives[key]!!.notes)
            map.size -> break
            else -> println("Нет такого номера!!!\nПопробуйте ещё раз...")
        }
    }
}