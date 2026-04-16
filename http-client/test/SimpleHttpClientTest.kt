import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.MockResponse

class SimpleHttpClientTest {
    @Test
    fun fetchReturnsResponseBody() {
        val server = MockWebServer()
        server.enqueue(MockResponse().setBody("""{"message":"hello"}"""))
        server.start()

        val client = SimpleHttpClient()
        val result = client.fetch(server.url("/api/greeting").toString())

        assertEquals("""{"message":"hello"}""", result)
        server.shutdown()
    }

    @Test
    fun fetchSendsGetRequest() {
        val server = MockWebServer()
        server.enqueue(MockResponse().setBody("ok"))
        server.start()

        val client = SimpleHttpClient()
        client.fetch(server.url("/test").toString())

        val request = server.takeRequest()
        assertEquals("GET", request.method)
        assertEquals("/test", request.path)
        server.shutdown()
    }

    @Test
    fun fetchHandlesNon200Status() {
        val server = MockWebServer()
        server.enqueue(MockResponse().setResponseCode(404).setBody("not found"))
        server.start()

        val client = SimpleHttpClient()
        val result = client.fetch(server.url("/missing").toString())

        // Non-200 should still return the body
        assertEquals("not found", result)
        server.shutdown()
    }
}
