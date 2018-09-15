import java.io.PrintStream
import java.net.ServerSocket
import java.util.*

class ChatServer {

    fun serve() {

        try {
            val serverSocket = ServerSocket(50000)
            println("We have port " + serverSocket.localPort)

            while (true) {
                val s = serverSocket.accept()
                println("new connection " + s.inetAddress.hostAddress + " " + s.port)
                val t = Thread(CommandInterpreter(s.getInputStream(), s.getOutputStream(), client = s))
                t.start()
            }

        } catch (err: Exception) {
            println("Error : $err")
        }

    }
}