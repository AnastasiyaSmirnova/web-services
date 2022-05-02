package itmo.web_services.model

data class User(
    val username: String,
    val password: String
) : JsonObject()