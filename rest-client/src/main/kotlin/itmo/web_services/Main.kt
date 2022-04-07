package itmo.web_services

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.config.DefaultClientConfig
import org.codehaus.jackson.jaxrs.JacksonJsonProvider


fun main() {
    val serverUrl = "http://localhost:8080/rest/books"
    try {
        val defaultClientConfig = DefaultClientConfig()
        defaultClientConfig.classes.add(JacksonJsonProvider::class.java)
        RestClient(Client.create(defaultClientConfig), serverUrl).run()
    } catch (e: Exception) {
        println("Something goes wrong =( ${e.message}")
    }

}