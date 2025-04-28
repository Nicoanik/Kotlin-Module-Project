class Note(val name: String, val text: String)

fun createNote(key: Int, notes: Map<Int, Note>) {
    val name = scannerString("Создаём новую заметку!\nВведите название:")
    val text = scannerString("Введите текст заметки:")
    archives[key]!!.notes[notes.size] = Note(name, text)
    println("Заметка '$name' создана!\n")
}

fun notesMenu(key: Int, notes: Map<Int, Note>) {
    while (true) {
        println("Мы находимся в архиве '${archives[key]!!.name}':")
        when (val scanner = scannerInt(notesMenu)) {
            0 -> createNote(key, notes)

            1 -> if (notes.isNotEmpty()) notesActionMenu(key, notes) else println("Здесь ещё нет заметок!!!\nПопробуйте её создать...\n")

            2 -> break

            else -> println(Message.WRONG_NUMBER.text)
        }
    }
}

fun notesActionMenu(key: Int, notes: Map<Int, Note>) {
    while (true) {
        println("Список ваших заметок в архиве '${archives[key]!!.name}':")
        notes.forEach { (key, note) -> println("'$key' - ${note.name}") }
        println("\n'${notes.size}' - 'Вернуться назад'\n")
        when (val scanner = scannerInt(null)) {
            in 0 until notes.size -> printNote(scanner, archives[key]!!.notes)
            notes.size -> break
            else -> println(Message.WRONG_NUMBER.text)
        }
    }
}

fun printNote(key: Int, notes: Map<Int, Note>) {
    println("Заметка '${notes[key]!!.name}':\n'${notes[key]!!.text}'\n")
}