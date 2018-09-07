import java.util.*

object ChatHistory : ChatHistoryObservable {

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


    override fun toString(): String {
        return super.toString()
    }
}
