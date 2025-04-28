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
        when (val scanner = scannerInt("Основное меню:", archivesMenu)) {
            0 -> createArchive()

            1 -> if (archives.isNotEmpty()) archivesActionMenu() else println("Нужно создать хотя бы один архив!!!\n")

            2 -> break

            else -> println("Нет такого номера!\nПопробуйте ещё раз...\n")
        }
    }
}

fun archivesActionMenu() {
    while (true) {
        archives.forEach { (key, archive) -> println("'$key' - ${archive.name}") }
        println("'${archives.size}' - 'Вернуться назад'\n")
        when (val scanner = scannerInt("Список ваших архивов:", null)) {
            in 0 until archives.size -> notesMenu(scanner, archives[scanner]!!.notes)
            archives.size -> break
            else -> println("Нет такого номера!\nПопробуйте ещё раз...\n")
        }
    }
}
