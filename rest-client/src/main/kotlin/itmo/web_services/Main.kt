package itmo.web_services

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.config.DefaultClientConfig
import org.codehaus.jackson.jaxrs.JacksonJsonProvider

fun main() {
    startClientForStandaloneApp()
//    startClientForJavaEEApp()
}

private fun startClientForStandaloneApp() {
    val serverUrl = "http://localhost:8080/rest/books"
    try {
        val defaultClientConfig = DefaultClientConfig()
        defaultClientConfig.classes.add(JacksonJsonProvider::class.java)
        RestClient(Client.create(defaultClientConfig), serverUrl).run()
    } catch (e: Exception) {
        println("Something goes wrong =( ${e.message}")
    }
}

private fun startClientForJavaEEApp() {
    val serverUrl = "http://localhost:8080/java-ee-rest-application-books-rest/rest/books"
}
