import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Greeting(val name: String, val count: Int)

fun main() {
    val original = Greeting(name = "world", count = 3)
    val encoded = Json.encodeToString(Greeting.serializer(), original)
    val decoded = Json.decodeFromString(Greeting.serializer(), encoded)

    println("encoded: $encoded")
    println("decoded: $decoded")
    check(decoded == original) { "round-trip mismatch: $decoded != $original" }
    println("round-trip ok")
}
