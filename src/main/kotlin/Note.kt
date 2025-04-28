class Note(val name: String, val text: String)

fun createNote(key: Int, notes: Map<Int, Note>) {
    val name = scannerString("Создаём новую заметку!\nВведите название:")
    val text = scannerString("Введите текст заметки:")
    archives[key]!!.notes[notes.size] = Note(name, text)
    println("Заметка '$name' создана!\n")
}

fun notesMenu(key: Int, notes: Map<Int, Note>) {
    while (true) {
        when (val scanner = scannerInt("Мы находимся в архиве '${archives[key]!!.name}':", notesMenu)) {
            0 -> createNote(key, notes)

            1 -> if (notes.isNotEmpty()) notesActionMenu(key, notes) else println("Здесь ещё нет заметок!!!\nПопробуйте её создать...\n")

            2 -> break

            else -> println("Нет такого номера!\nПопробуйте ещё раз...\n")
        }
    }
}

fun notesActionMenu(key: Int, notes: Map<Int, Note>) {
    while (true) {
        notes.forEach { (key, note) -> println("'$key' - ${note.name}") }
        println("'${notes.size}' - 'Вернуться назад'\n")
        when (val scanner = scannerInt("Список ваших заметок в архиве '${archives[key]!!.name}':", null)) {
            in 0 until notes.size -> printNote(scanner, archives[key]!!.notes)
            notes.size -> break
            else -> println("Нет такого номера!\nПопробуйте ещё раз...\n")
        }
    }
}

fun printNote(key: Int, notes: Map<Int, Note>) {
    println("Заметка '${notes[key]!!.name}':\n'${notes[key]!!.text}'\n")
}