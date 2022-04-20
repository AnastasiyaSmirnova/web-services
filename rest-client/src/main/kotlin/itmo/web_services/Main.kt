package itmo.web_services

fun main() {
//    RestClient(ServerType.STANDALONE, ClientService()).run()
    RestClient(ServerType.JAVA_EE, ClientService()).run()
}
