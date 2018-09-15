This is the simple and minimalist chat server, which was written in Kotlin.

You can start to chat with command telnet [server IP address] [server port] in our case port is 50000

default server port is 50000



Chat parser:
The user can use four basic commands for handling the chat session

:user [username] - When app starts user have to input own unique username 
:users - User can check all chat members with this command
:history - User can check all messages history with this command 

Chat server implementation:
    Design patterns: 
        -Singleton
        -Observer
