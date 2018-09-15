import java.io.PrintStream
import java.util.*

class HelpList(val printOut: PrintStream) {
    fun show() {
        printOut.println("Input :exit for exit")
        printOut.println("Input :users to see all users in this chat")
        printOut.println("Input :history to see all chat history")
    }
}
