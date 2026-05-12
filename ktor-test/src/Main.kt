import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: Int, val name: String)

private val users = mapOf(
    1 to User(1, "Alice"),
    2 to User(2, "Bob"),
)

fun Application.module() {
    install(ContentNegotiation) { json() }
    routing {
        get("/users/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val user = id?.let { users[it] }
            if (user == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                call.respond(user)
            }
        }
    }
}

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}
