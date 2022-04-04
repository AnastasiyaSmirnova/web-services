
package itmo.web_services.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itmo.web_services.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBooksByTitleAndAuthorResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByTitleAndAuthorResponse");
    private final static QName _GetBooksByTitleAndPublishingHouse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByTitleAndPublishingHouse");
    private final static QName _GetBooksByPagesRange_QNAME = new QName("http://service.web_services.itmo/", "getBooksByPagesRange");
    private final static QName _GetBooksByAuthorAndPublishingHouse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthorAndPublishingHouse");
    private final static QName _GetBooksByPublishingHouse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByPublishingHouse");
    private final static QName _GetBooksByTitle_QNAME = new QName("http://service.web_services.itmo/", "getBooksByTitle");
    private final static QName _GetBooksByTitleAndPublishingHouseResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByTitleAndPublishingHouseResponse");
    private final static QName _GetBooksByPublishingHouseResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByPublishingHouseResponse");
    private final static QName _GetBooksByTitleResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByTitleResponse");
    private final static QName _GetBooksByAuthorAndMaxPagesResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthorAndMaxPagesResponse");
    private final static QName _GetBooksByAuthorAndMinPagesResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthorAndMinPagesResponse");
    private final static QName _GetBooks_QNAME = new QName("http://service.web_services.itmo/", "getBooks");
    private final static QName _GetBooksByAuthorAndMinPages_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthorAndMinPages");
    private final static QName _GetBooksByAuthorAndPublishingHouseResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthorAndPublishingHouseResponse");
    private final static QName _GetBooksResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksResponse");
    private final static QName _GetBooksByAuthorAndMaxPages_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthorAndMaxPages");
    private final static QName _GetBooksByAuthor_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthor");
    private final static QName _GetBooksByAuthorResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByAuthorResponse");
    private final static QName _GetBooksByTitleAndAuthor_QNAME = new QName("http://service.web_services.itmo/", "getBooksByTitleAndAuthor");
    private final static QName _GetBooksByPagesRangeResponse_QNAME = new QName("http://service.web_services.itmo/", "getBooksByPagesRangeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itmo.web_services.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBooksByAuthorAndPublishingHouseResponse }
     * 
     */
    public GetBooksByAuthorAndPublishingHouseResponse createGetBooksByAuthorAndPublishingHouseResponse() {
        return new GetBooksByAuthorAndPublishingHouseResponse();
    }

    /**
     * Create an instance of {@link GetBooks }
     * 
     */
    public GetBooks createGetBooks() {
        return new GetBooks();
    }

    /**
     * Create an instance of {@link GetBooksByAuthorAndMinPages }
     * 
     */
    public GetBooksByAuthorAndMinPages createGetBooksByAuthorAndMinPages() {
        return new GetBooksByAuthorAndMinPages();
    }

    /**
     * Create an instance of {@link GetBooksByAuthorAndMinPagesResponse }
     * 
     */
    public GetBooksByAuthorAndMinPagesResponse createGetBooksByAuthorAndMinPagesResponse() {
        return new GetBooksByAuthorAndMinPagesResponse();
    }

    /**
     * Create an instance of {@link GetBooksByAuthorAndMaxPagesResponse }
     * 
     */
    public GetBooksByAuthorAndMaxPagesResponse createGetBooksByAuthorAndMaxPagesResponse() {
        return new GetBooksByAuthorAndMaxPagesResponse();
    }

    /**
     * Create an instance of {@link GetBooksByPagesRangeResponse }
     * 
     */
    public GetBooksByPagesRangeResponse createGetBooksByPagesRangeResponse() {
        return new GetBooksByPagesRangeResponse();
    }

    /**
     * Create an instance of {@link GetBooksByAuthor }
     * 
     */
    public GetBooksByAuthor createGetBooksByAuthor() {
        return new GetBooksByAuthor();
    }

    /**
     * Create an instance of {@link GetBooksByAuthorResponse }
     * 
     */
    public GetBooksByAuthorResponse createGetBooksByAuthorResponse() {
        return new GetBooksByAuthorResponse();
    }

    /**
     * Create an instance of {@link GetBooksByTitleAndAuthor }
     * 
     */
    public GetBooksByTitleAndAuthor createGetBooksByTitleAndAuthor() {
        return new GetBooksByTitleAndAuthor();
    }

    /**
     * Create an instance of {@link GetBooksByAuthorAndMaxPages }
     * 
     */
    public GetBooksByAuthorAndMaxPages createGetBooksByAuthorAndMaxPages() {
        return new GetBooksByAuthorAndMaxPages();
    }

    /**
     * Create an instance of {@link GetBooksResponse }
     * 
     */
    public GetBooksResponse createGetBooksResponse() {
        return new GetBooksResponse();
    }

    /**
     * Create an instance of {@link GetBooksByPublishingHouse }
     * 
     */
    public GetBooksByPublishingHouse createGetBooksByPublishingHouse() {
        return new GetBooksByPublishingHouse();
    }

    /**
     * Create an instance of {@link GetBooksByTitle }
     * 
     */
    public GetBooksByTitle createGetBooksByTitle() {
        return new GetBooksByTitle();
    }

    /**
     * Create an instance of {@link GetBooksByAuthorAndPublishingHouse }
     * 
     */
    public GetBooksByAuthorAndPublishingHouse createGetBooksByAuthorAndPublishingHouse() {
        return new GetBooksByAuthorAndPublishingHouse();
    }

    /**
     * Create an instance of {@link GetBooksByPagesRange }
     * 
     */
    public GetBooksByPagesRange createGetBooksByPagesRange() {
        return new GetBooksByPagesRange();
    }

    /**
     * Create an instance of {@link GetBooksByTitleAndAuthorResponse }
     * 
     */
    public GetBooksByTitleAndAuthorResponse createGetBooksByTitleAndAuthorResponse() {
        return new GetBooksByTitleAndAuthorResponse();
    }

    /**
     * Create an instance of {@link GetBooksByTitleAndPublishingHouse }
     * 
     */
    public GetBooksByTitleAndPublishingHouse createGetBooksByTitleAndPublishingHouse() {
        return new GetBooksByTitleAndPublishingHouse();
    }

    /**
     * Create an instance of {@link GetBooksByTitleResponse }
     * 
     */
    public GetBooksByTitleResponse createGetBooksByTitleResponse() {
        return new GetBooksByTitleResponse();
    }

    /**
     * Create an instance of {@link GetBooksByPublishingHouseResponse }
     * 
     */
    public GetBooksByPublishingHouseResponse createGetBooksByPublishingHouseResponse() {
        return new GetBooksByPublishingHouseResponse();
    }

    /**
     * Create an instance of {@link GetBooksByTitleAndPublishingHouseResponse }
     * 
     */
    public GetBooksByTitleAndPublishingHouseResponse createGetBooksByTitleAndPublishingHouseResponse() {
        return new GetBooksByTitleAndPublishingHouseResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitleAndAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByTitleAndAuthorResponse")
    public JAXBElement<GetBooksByTitleAndAuthorResponse> createGetBooksByTitleAndAuthorResponse(GetBooksByTitleAndAuthorResponse value) {
        return new JAXBElement<GetBooksByTitleAndAuthorResponse>(_GetBooksByTitleAndAuthorResponse_QNAME, GetBooksByTitleAndAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitleAndPublishingHouse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByTitleAndPublishingHouse")
    public JAXBElement<GetBooksByTitleAndPublishingHouse> createGetBooksByTitleAndPublishingHouse(GetBooksByTitleAndPublishingHouse value) {
        return new JAXBElement<GetBooksByTitleAndPublishingHouse>(_GetBooksByTitleAndPublishingHouse_QNAME, GetBooksByTitleAndPublishingHouse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByPagesRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByPagesRange")
    public JAXBElement<GetBooksByPagesRange> createGetBooksByPagesRange(GetBooksByPagesRange value) {
        return new JAXBElement<GetBooksByPagesRange>(_GetBooksByPagesRange_QNAME, GetBooksByPagesRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthorAndPublishingHouse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthorAndPublishingHouse")
    public JAXBElement<GetBooksByAuthorAndPublishingHouse> createGetBooksByAuthorAndPublishingHouse(GetBooksByAuthorAndPublishingHouse value) {
        return new JAXBElement<GetBooksByAuthorAndPublishingHouse>(_GetBooksByAuthorAndPublishingHouse_QNAME, GetBooksByAuthorAndPublishingHouse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByPublishingHouse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByPublishingHouse")
    public JAXBElement<GetBooksByPublishingHouse> createGetBooksByPublishingHouse(GetBooksByPublishingHouse value) {
        return new JAXBElement<GetBooksByPublishingHouse>(_GetBooksByPublishingHouse_QNAME, GetBooksByPublishingHouse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByTitle")
    public JAXBElement<GetBooksByTitle> createGetBooksByTitle(GetBooksByTitle value) {
        return new JAXBElement<GetBooksByTitle>(_GetBooksByTitle_QNAME, GetBooksByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitleAndPublishingHouseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByTitleAndPublishingHouseResponse")
    public JAXBElement<GetBooksByTitleAndPublishingHouseResponse> createGetBooksByTitleAndPublishingHouseResponse(GetBooksByTitleAndPublishingHouseResponse value) {
        return new JAXBElement<GetBooksByTitleAndPublishingHouseResponse>(_GetBooksByTitleAndPublishingHouseResponse_QNAME, GetBooksByTitleAndPublishingHouseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByPublishingHouseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByPublishingHouseResponse")
    public JAXBElement<GetBooksByPublishingHouseResponse> createGetBooksByPublishingHouseResponse(GetBooksByPublishingHouseResponse value) {
        return new JAXBElement<GetBooksByPublishingHouseResponse>(_GetBooksByPublishingHouseResponse_QNAME, GetBooksByPublishingHouseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByTitleResponse")
    public JAXBElement<GetBooksByTitleResponse> createGetBooksByTitleResponse(GetBooksByTitleResponse value) {
        return new JAXBElement<GetBooksByTitleResponse>(_GetBooksByTitleResponse_QNAME, GetBooksByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthorAndMaxPagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthorAndMaxPagesResponse")
    public JAXBElement<GetBooksByAuthorAndMaxPagesResponse> createGetBooksByAuthorAndMaxPagesResponse(GetBooksByAuthorAndMaxPagesResponse value) {
        return new JAXBElement<GetBooksByAuthorAndMaxPagesResponse>(_GetBooksByAuthorAndMaxPagesResponse_QNAME, GetBooksByAuthorAndMaxPagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthorAndMinPagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthorAndMinPagesResponse")
    public JAXBElement<GetBooksByAuthorAndMinPagesResponse> createGetBooksByAuthorAndMinPagesResponse(GetBooksByAuthorAndMinPagesResponse value) {
        return new JAXBElement<GetBooksByAuthorAndMinPagesResponse>(_GetBooksByAuthorAndMinPagesResponse_QNAME, GetBooksByAuthorAndMinPagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooks")
    public JAXBElement<GetBooks> createGetBooks(GetBooks value) {
        return new JAXBElement<GetBooks>(_GetBooks_QNAME, GetBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthorAndMinPages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthorAndMinPages")
    public JAXBElement<GetBooksByAuthorAndMinPages> createGetBooksByAuthorAndMinPages(GetBooksByAuthorAndMinPages value) {
        return new JAXBElement<GetBooksByAuthorAndMinPages>(_GetBooksByAuthorAndMinPages_QNAME, GetBooksByAuthorAndMinPages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthorAndPublishingHouseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthorAndPublishingHouseResponse")
    public JAXBElement<GetBooksByAuthorAndPublishingHouseResponse> createGetBooksByAuthorAndPublishingHouseResponse(GetBooksByAuthorAndPublishingHouseResponse value) {
        return new JAXBElement<GetBooksByAuthorAndPublishingHouseResponse>(_GetBooksByAuthorAndPublishingHouseResponse_QNAME, GetBooksByAuthorAndPublishingHouseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksResponse")
    public JAXBElement<GetBooksResponse> createGetBooksResponse(GetBooksResponse value) {
        return new JAXBElement<GetBooksResponse>(_GetBooksResponse_QNAME, GetBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthorAndMaxPages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthorAndMaxPages")
    public JAXBElement<GetBooksByAuthorAndMaxPages> createGetBooksByAuthorAndMaxPages(GetBooksByAuthorAndMaxPages value) {
        return new JAXBElement<GetBooksByAuthorAndMaxPages>(_GetBooksByAuthorAndMaxPages_QNAME, GetBooksByAuthorAndMaxPages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthor")
    public JAXBElement<GetBooksByAuthor> createGetBooksByAuthor(GetBooksByAuthor value) {
        return new JAXBElement<GetBooksByAuthor>(_GetBooksByAuthor_QNAME, GetBooksByAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByAuthorResponse")
    public JAXBElement<GetBooksByAuthorResponse> createGetBooksByAuthorResponse(GetBooksByAuthorResponse value) {
        return new JAXBElement<GetBooksByAuthorResponse>(_GetBooksByAuthorResponse_QNAME, GetBooksByAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByTitleAndAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByTitleAndAuthor")
    public JAXBElement<GetBooksByTitleAndAuthor> createGetBooksByTitleAndAuthor(GetBooksByTitleAndAuthor value) {
        return new JAXBElement<GetBooksByTitleAndAuthor>(_GetBooksByTitleAndAuthor_QNAME, GetBooksByTitleAndAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByPagesRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web_services.itmo/", name = "getBooksByPagesRangeResponse")
    public JAXBElement<GetBooksByPagesRangeResponse> createGetBooksByPagesRangeResponse(GetBooksByPagesRangeResponse value) {
        return new JAXBElement<GetBooksByPagesRangeResponse>(_GetBooksByPagesRangeResponse_QNAME, GetBooksByPagesRangeResponse.class, null, value);
    }

}
