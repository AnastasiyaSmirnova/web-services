package itmo.web_services.model

import itmo.web_services.model.annotation.NoArg
import org.codehaus.jackson.annotate.JsonProperty
import javax.xml.bind.annotation.XmlRootElement

@NoArg
@XmlRootElement
data class Book(
    var id: Long,
    val title: String,
    val author: String,
    @JsonProperty("publishing_house")
    val publishingHouse: String,
    val language: String,
    val pages: Int
)
