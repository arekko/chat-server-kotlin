class ChatMessage (val username: String, val message: String) {

    fun getMessageInOneLine(): String {
        return "${username} : ${message}"
    }
}
