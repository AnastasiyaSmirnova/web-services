
package itmo.web_services.service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for language.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="language">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RUSSIAN"/>
 *     &lt;enumeration value="ENGLISH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "language")
@XmlEnum
public enum Language {

    RUSSIAN,
    ENGLISH;

    public String value() {
        return name();
    }

    public static Language fromValue(String v) {
        return valueOf(v);
    }

}
