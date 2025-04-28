fun main(args: Array<String>) {
    println("Добро пожаловать в архив заметок!\n")
    archiveMenu()
    println("Спасибо за заметки! :)\nДо cвидания!")
}

enum class Message(val text: String) {
    WRONG_NUMBER("Нет такого номера!\nПопробуйте ещё раз...\n"),
    EMPTY("Это поле не может быть пустым!!!\nВведите текст...\n"),
    NOT_NUMBER("Необходимо вводить только цифры!!!\nПопробуйте ещё раз...\n")
}