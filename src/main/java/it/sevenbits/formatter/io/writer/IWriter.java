package it.sevenbits.formatter.io.writer;

/**
 * Interface that declares a functionality for output character stream.
 */
public interface IWriter {
    /**
     * Overload of method that writes to stream a single character represented by Unicode code.
     *
     * @param character Unicode character code to be written.
     * @throws WriterException Exception that can be thrown during the method work.
     */
    void write(int character) throws WriterException;

    /**
     * Overload of method that writes to stream a {@link String} instance.
     *
     * @param string {@link String} instance to be written.
     * @throws WriterException Exception that can be thrown during the method work.
     */
    void write(String string) throws WriterException;

    /**
     * Overload of method that writes to stream an array of characters.
     *
     * @param charArray Array of characters to be written.
     * @throws WriterException Exception that can be thrown during the method work.
     */
    void write(char[] charArray) throws WriterException;
}
