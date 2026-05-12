import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MainTest {
    @Test
    fun greetReturnsJson() = testApplication {
        application { module() }
        val response = client.get("/greet?name=cio")
        assertEquals(HttpStatusCode.OK, response.status)
        val body = response.bodyAsText()
        assertTrue(body.contains("\"message\""), "expected JSON field 'message', got: $body")
        assertTrue(body.contains("cio"), "expected 'cio' in body, got: $body")
    }
}
