package gospodarka.elektroniczna.services.document.content;

import gospodarka.elektroniczna.documents.TestDocument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

/**
 * Obiekt serializujący i desarializujący zawartość dokumentu testowego.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
public class TestDocumentContentService implements IDocumentContentService<TestDocument>, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 960726184925354245L;

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] toByteStream(final TestDocument documentContent) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            out.write(ByteBuffer.allocate(Integer.BYTES).putInt(documentContent.getNumber()).array());
            out.write(ByteBuffer.allocate(Long.BYTES).putLong(documentContent.getDate().getTime()).array());
        }
        catch (IOException e) {
            throw new RuntimeException("Nieudana próba serializacja testowego dokumentu.", e);
        }

        return out.toByteArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestDocument toDocument(final byte[] stream) {
        TestDocument test = new TestDocument();

        test.setNumber(ByteBuffer.allocate(Integer.BYTES).wrap(stream, 0, Integer.BYTES).getInt());
        test.setDate(new Date(ByteBuffer.allocate(Long.BYTES).wrap(stream, Integer.BYTES, Long.BYTES).getLong()));

        return test;
    }
}