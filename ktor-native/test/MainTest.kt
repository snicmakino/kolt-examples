import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun greetingSerializesToJson() {
        val json = Json.encodeToString(Greeting("Hello, native!"))
        assertEquals("""{"message":"Hello, native!"}""", json)
    }

    @Test
    fun greetingRoundTripsThroughJson() {
        val original = Greeting("Hello, native!")
        val json = Json.encodeToString(original)
        val parsed = Json.decodeFromString<Greeting>(json)
        assertEquals(original, parsed)
    }
}
