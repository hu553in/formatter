package it.sevenbits.formatter.lexer.simple;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.ReaderException;
import it.sevenbits.formatter.io.reader.StringReader;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.LexerException;
import it.sevenbits.formatter.lexer.SimpleLexer;
import it.sevenbits.formatter.lexer.token.IToken;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class SimpleLexerTest {
    private ILexer lexer;
    private IReader reader;

    @Test
    public void shouldReturnTokensCorrectly() throws LexerException {
        reader = new StringReader("class{ \n{{\nprivate}))\n");
        lexer = new SimpleLexer(reader);

        Assert.assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        Assert.assertEquals("class", token.getLexeme());
        Assert.assertEquals("OTHER", token.getName());

        Assert.assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        Assert.assertEquals("{", token.getLexeme());
        Assert.assertEquals("OPENING_CURLY_BRACE", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals(" ", token.getLexeme());
        Assert.assertEquals("WHITESPACE", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("\n", token.getLexeme());
        Assert.assertEquals("NEWLINE", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("{", token.getLexeme());
        Assert.assertEquals("OPENING_CURLY_BRACE", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("{", token.getLexeme());
        Assert.assertEquals("OPENING_CURLY_BRACE", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("\n", token.getLexeme());
        Assert.assertEquals("NEWLINE", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("private", token.getLexeme());
        Assert.assertEquals("OTHER", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("}", token.getLexeme());
        Assert.assertEquals("CLOSING_CURLY_BRACE", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("))", token.getLexeme());
        Assert.assertEquals("OTHER", token.getName());
        Assert.assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        Assert.assertEquals("\n", token.getLexeme());
        Assert.assertEquals("NEWLINE", token.getName());
        Assert.assertFalse(lexer.hasMoreTokens());
    }

    @Test(expected = LexerException.class)
    public void shouldThrowException() throws ReaderException, LexerException {
        reader = mock(StringReader.class);
        doReturn(true).when(reader).hasNext();
        doThrow(new ReaderException("ReaderException", new IOException())).when(reader).read();
        lexer = new SimpleLexer(reader);
    }
}
