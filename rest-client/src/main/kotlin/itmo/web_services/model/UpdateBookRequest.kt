package itmo.web_services.model

data class UpdateBookRequest(
    val uid: Long,
    val title: String,
    val author: String,
    val publishingHouse: String,
    val language: String,
    val pages: Int
) : JsonObject()
