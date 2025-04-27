val arhivesMenu = mapOf(
    0 to "Создать архив",
    1 to "Открыть архив",
    2 to "Выйти из программы"
)
val arhives: MutableMap<Int, String> = mutableMapOf()
fun createArhive(text: String) {
    arhives.put(arhives.size, text)
}