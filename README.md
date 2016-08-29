# Chat-for-2-users
Application for conversation between two users.
Users have to enter a username before the chat could start.
Uses a terminal as "chat window".

Bugs :
  - while typing a message, if the other user sends a message, the output would be :
        "user1 : partOfYourMessage + user2 : user2's sent message"

Observation :
  If you want to make this application work with computers other then those from your LAN you must :
    1) In ChatClient.java you must replace "localhost" with your public IP address (type "what is my IP" in your browser).
    2) On the machine where you hold the Server port forword port 8888 ( in this case ).
    3) Chat!
