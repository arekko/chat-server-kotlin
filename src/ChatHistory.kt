import java.util.*

object ChatHistory : ChatHistoryObservable {

    // Observer pattern methods

    val observers: MutableList<ChatHistoryObserver> = mutableListOf()

    override fun registerObserber(observer: ChatHistoryObserver) {
        observers.add(observer)
    }

    override fun deregisterObserver(observer: ChatHistoryObserver) {
        observers.remove(observer)
    }

    override fun norifyObservers(message: ChatMessage) {
        observers.forEach { it.newMessage(message) }
    }



    private val messageHistory: MutableList<ChatMessage> = mutableListOf()

    fun insert(message: ChatMessage) {
            messageHistory.add(message)

    }

    fun returnMessageList(): List<ChatMessage> {
        return messageHistory.toList()
    }


}
