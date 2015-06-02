package gospodarka.elektroniczna.services.document.content;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

/**
 * Serwis konwertujący zawartość dokumentu na strumień bajtów i na odwrót.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentContentSerialization implements Serializable, IDocumentContentSerialization {
    /**
     * UID.
     */
    private static final long serialVersionUID = -8978730963194666185L;
    
    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Serializable> T convertToDocumentContent(final byte[] stream) {
        return (T) SerializationUtils.deserialize(stream); 
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> byte[] convertToStream(final T documentContent) {
        return SerializationUtils.serialize(documentContent);
    }
}