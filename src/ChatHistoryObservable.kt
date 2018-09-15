import java.util.*

interface ChatHistoryObservable {
    fun registerObserber(observer: ChatHistoryObserver)
    fun deregisterObserver(observer: ChatHistoryObserver)
    fun norifyObservers (message: ChatMessage)

}