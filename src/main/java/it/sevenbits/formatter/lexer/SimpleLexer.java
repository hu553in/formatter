package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.ReaderException;
import it.sevenbits.formatter.lexer.token.IToken;
import it.sevenbits.formatter.lexer.token.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link ILexer} interface implementation that provides lexical analysis of Java source code.
 */
public class SimpleLexer implements ILexer {
    private final IReader reader;
    private final Map<String, String> lexemeForName;
    private int charBuffer;

    /**
     * Class constructor that initializes {@link #lexemeForName} and puts in it
     * all known pairs of lexemes and token names.
     * <p>
     * Also this method initializes private {@link #reader} field with passed {@link IReader} instance
     * and performs initial filling of private {@link #charBuffer} field.
     *
     * @param reader {@link IReader} instance that provides data input process.
     * @throws LexerException Exception that can be thrown during the method work.
     */
    public SimpleLexer(final IReader reader) throws LexerException {
        this.reader = reader;
        lexemeForName = new HashMap<>();

        lexemeForName.put("{", "OPENING_CURLY_BRACE");
        lexemeForName.put("}", "CLOSING_CURLY_BRACE");
        lexemeForName.put(";", "SEMICOLON");
        lexemeForName.put("\n", "NEWLINE");
        lexemeForName.put("\t", "TAB");
        lexemeForName.put(" ", "WHITESPACE");

        if (reader.hasNext()) {
            try {
                charBuffer = reader.read();
            } catch (ReaderException e) {
                throw new LexerException("Unable to read from reader", e);
            }
        }
    }

    /**
     * Method that reports whether single {@link IToken} instance is available for reading.
     *
     * @return Boolean value that indicates the result of method work.
     */
    @Override
    public boolean hasMoreTokens() {
        return charBuffer != -1;
    }

    /**
     * Method that returns a single {@link IToken} instance.
     *
     * @return Single {@link IToken} instance.
     * @throws LexerException Exception that can be thrown during the method work.
     */
    @Override
    public IToken readToken() throws LexerException {
        if (!hasMoreTokens()) {
            throw new LexerException("No tokens available for reading");
        }

        try {
            if (lexemeForName.get(Character.toString((char) charBuffer)) != null) {
                final IToken token = new Token(
                        lexemeForName.get(Character.toString((char) charBuffer)),
                        (char) charBuffer
                );

                if (reader.hasNext()) {
                    charBuffer = reader.read();
                } else {
                    charBuffer = -1;
                }

                return token;
            } else {
                StringBuilder lexeme = new StringBuilder(Character.toString((char) charBuffer));

                if (reader.hasNext()) {
                    charBuffer = reader.read();

                    while (lexemeForName.get(Character.toString((char) charBuffer)) == null) {
                        lexeme.append((char) charBuffer);

                        if (reader.hasNext()) {
                            charBuffer = reader.read();
                        } else {
                            charBuffer = -1;
                            break;
                        }
                    }
                } else {
                    charBuffer = -1;
                }

                return new Token("OTHER", lexeme.toString());
            }
        } catch (ReaderException e) {
            throw new LexerException("Unable to read from reader", e);
        }
    }
}
