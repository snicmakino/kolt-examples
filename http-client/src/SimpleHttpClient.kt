import okhttp3.OkHttpClient
import okhttp3.Request

class SimpleHttpClient {
    private val client = OkHttpClient()

    fun fetch(url: String): String {
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().use { response ->
            return response.body?.string() ?: ""
        }
    }
}
