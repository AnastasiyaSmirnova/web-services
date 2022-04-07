package itmo.web_services.model

import itmo.web_services.model.annotation.NoArg
import javax.xml.bind.annotation.XmlRootElement


@NoArg
@XmlRootElement
data class BooksResponse(val book: List<Book?>?)

@NoArg
@XmlRootElement
data class BookResponse(val book: Book?)
