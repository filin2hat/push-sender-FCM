import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    if (FirebaseApp.getApps().isEmpty()) {
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
            .build()

        FirebaseApp.initializeApp(options)
    }

    while (true) {
        println(
            """
        Choose action:
        1 - Send LIKE,
        2 - Send SHARE,
        3 - Send NEW POST
        9 - Send ERROR
        0 - Exit
    """.trimIndent()
        )

        val userInput = readln().toIntOrNull()

        when (userInput) {
            1 -> {
                println("Send LIKE!")
                try {
                    sendLike()
                } catch (e: Exception) {
                    println("Error sending LIKE: ${e.message}")
                }
            }

            2 -> {
                println("Send SHARE!")
                try {
                    sendShare()
                } catch (e: Exception) {
                    println("Error sending SHARE: ${e.message}")
                }
            }

            3 -> {
                println("Send NEW POST!")
                try {
                    sendNewPost()
                } catch (e: Exception) {
                    println("Error sending NEW POST: ${e.message}")
                }
            }

            9 -> {
                println("Send ERROR!")
                try {
                    sendError()
                } catch (e: Exception) {
                    println("Error sending ERROR: ${e.message}")
                }
            }

            0 -> {
                println("Bye!")
                break
            }
        }
    }
}

fun sendError() {
    val message = Message.builder()
        .putData("act.,mion", "ERkljROR")
        .putData(
            "weklefwkfwjkfejk", "ewfffokf"
        )
        .setToken(token)
        .build()

    try {
        FirebaseMessaging.getInstance().send(message)
    } catch (e: Exception) {
        throw Exception(e.message)
    }
}

fun sendNewPost() {
    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData(
            "content", """{
            "userId": 3,
            "userName": "Amanda Smith",
            "postId": 4,
            "postText" : "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."}""".trimMargin()
        )
        .setToken(token)
        .build()

    try {
        FirebaseMessaging.getInstance().send(message)
    } catch (e: Exception) {
        throw Exception(e.message)
    }
}

fun sendShare() {
    val message = Message.builder()
        .putData("action", "SHARE")
        .putData(
            "content", """{            
            "userId": 2,
            "userName": "Mike Smith",
            "postId": 3,
            "postAuthor": "Your"}""".trimMargin()
        )
        .setToken(token)
        .build()

    try {
        FirebaseMessaging.getInstance().send(message)
    } catch (e: Exception) {
        throw Exception(e.message)
    }
}

fun sendLike() {
    val message = Message.builder()
        .putData("action", "LIKE")
        .putData(
            "content", """{            
            "userId": 1,
            "userName": "John Doe",
            "postId": 2,
            "postAuthor": "Netology"}""".trimMargin()
        )
        .setToken(token)
        .build()

    try {
        FirebaseMessaging.getInstance().send(message)
    } catch (e: Exception) {
        throw Exception(e.message)
    }
}
