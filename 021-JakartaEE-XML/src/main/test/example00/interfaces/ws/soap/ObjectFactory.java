
package example00.interfaces.ws.soap;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the example00.interfaces.ws.soap package. 
 * <p>An ObjectFactory allows you to programmatically 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: example00.interfaces.ws.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pago }
     * 
     * @return
     *     the new instance of {@link Pago }
     */
    public Pago createPago() {
        return new Pago();
    }

    /**
     * Create an instance of {@link PagoArray }
     * 
     * @return
     *     the new instance of {@link PagoArray }
     */
    public PagoArray createPagoArray() {
        return new PagoArray();
    }

}
