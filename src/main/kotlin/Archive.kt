class Archive(val name: String) {
    val notes = mutableMapOf<Int, Note>()
}

val archives = mutableMapOf<Int, Archive>()

fun createArchive() {
    val name = scannerString("Создаём новый архив!\nВведите название:")
    archives[archives.size] = Archive(name)
    println("Архив '$name' создан!\n")
}

fun archiveMenu() {
    while (true) {
        println("Основное меню:")
        when (val scanner = scannerInt(archivesMenu)) {
            0 -> createArchive()

            1 -> if (archives.isNotEmpty()) archivesActionMenu() else println("Нужно создать хотя бы один архив!!!\n")

            2 -> break

            else -> println(Message.WRONG_NUMBER.text)
        }
    }
}

fun archivesActionMenu() {
    while (true) {
        println("Список ваших архивов:")
        archives.forEach { (key, archive) -> println("'$key' - ${archive.name}") }
        println("\n'${archives.size}' - 'Вернуться назад'\n")
        when (val scanner = scannerInt(null)) {
            in 0 until archives.size -> notesMenu(scanner, archives[scanner]!!.notes)
            archives.size -> break
            else -> println(Message.WRONG_NUMBER.text)
        }
    }
}
