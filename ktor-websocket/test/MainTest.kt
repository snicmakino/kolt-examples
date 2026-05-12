import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.server.testing.testApplication
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun echoesTextFrame() = testApplication {
        application { module() }
        val wsClient = createClient { install(WebSockets) }

        wsClient.webSocket("/echo") {
            send("hello")
            val received = (incoming.receive() as Frame.Text).readText()
            assertEquals("hello", received)
        }
    }
}
