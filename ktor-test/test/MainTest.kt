import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun getExistingUserReturnsTypedBody() = testApplication {
        application { module() }
        val jsonClient = createClient { install(ContentNegotiation) { json() } }

        val response = jsonClient.get("/users/1")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(User(id = 1, name = "Alice"), response.body())
    }

    @Test
    fun getMissingUserReturns404() = testApplication {
        application { module() }

        val response = client.get("/users/999")

        assertEquals(HttpStatusCode.NotFound, response.status)
    }
}
