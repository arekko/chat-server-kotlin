import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.net.Socket
import java.util.*
import kotlin.system.exitProcess

class CommandInterpreter(inputStream: InputStream, output: OutputStream, client: Socket) : ChatHistoryObserver, Runnable {

    override fun newMessage(message: ChatMessage) {
        if (message.username != username) {
            printOut.println("${message.username} : ${message.message}")
        }

    }

    private val client: Socket = client
    val scanner: Scanner = Scanner(inputStream)
    val printOut: PrintStream = PrintStream(output)
    var username: String = " "
    var exit = false


    override fun run() {
        ChatHistory.registerObserber(this)

        printOut.println("Welcome to private chatMessager")

        var command = ""


        do {


            while (username == " ") {
                printOut.println("Use the command :user to set the username ")
                val command = scanner.nextLine()
                if (command.split(' ')[0] == ":user") {
                    val inputCommand = command.substringAfter(' ')
                    if(Users.addUsername(inputCommand)) {
                        username = inputCommand
                        printOut.println("Your username is $username")
                        printOut.println("Now you can chat with your friends or use :help for help")
                    } else {
                        printOut.println("This username is already taken!")
                    }
                }
            }

            command = scanner.nextLine()

            when (command.split(' ')[0]) {

                ":users" -> printOut.println(Users.toString())
                ":help" -> CommandList(printOut).show()
                ":exit" -> shutdown()
                ":history" -> printOut.println(ChatHistory.toString())

                else -> {
                    ChatHistory.insert(ChatMessage(username, command))
                    ChatHistory.norifyObservers(ChatMessage(username, command))
                }
            }


        } while (!exit)

    }

    fun shutdown() {
        ChatHistory.norifyObservers(ChatMessage(username, "Goodbye, I am done!"))
        client.close()
        Users.removeUsername(username)
        exit = true
    }
}
