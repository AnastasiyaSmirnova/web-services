package itmo.web_services.model

import org.codehaus.jackson.annotate.JsonProperty

data class AddBookRequest(
    val title: String,
    val author: String,
    @JsonProperty("publishing_house")
    val publishingHouse: String,
    val language: String,
    val pages: Int
) : JsonObject()