fun main() {
    val client = SimpleHttpClient()
    val url = "https://httpbin.org/get"
    println("Fetching $url ...")
    val body = client.fetch(url)
    println(body)
}
