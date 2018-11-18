package it.sevenbits.homework.lexer.token;

/**
 * Interface that declares a functionality for lexical token.
 */
public interface IToken {
    /**
     * Method that returns token name.
     *
     * @return String instance that represents name of token.
     */
    String getName();

    /**
     * Method that returns lexeme.
     *
     * @return String instance that represents lexeme.
     */
    String getLexeme();
}
