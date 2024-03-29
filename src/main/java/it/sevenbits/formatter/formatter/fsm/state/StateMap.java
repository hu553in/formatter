package it.sevenbits.formatter.formatter.fsm.state;

import it.sevenbits.formatter.lexer.token.IToken;
import it.sevenbits.formatter.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides a mapping of {@link Pair} instances (that contain {@link State} instance / {@link String}
 * instance pairs) to {@link State} instances.
 * <p>
 * This mapping is used for providing transitions between FSM states.
 * Transition choice performs using information about current FSM state and other input signals.
 * Other input signals are actually presented by {@link String} instances.
 */
class StateMap {
    private final State startState, errorState;
    private final Map<Pair<State, String>, State> stateMap;

    /**
     * Class constructor that initializes private {@link #stateMap} field and fills it with a pairs of
     * {@link Pair} instances (that contain {@link State} instance / {@link String} instance pairs)
     * and {@link State} instances.
     * <p>
     * Also this method initializes private {@link #startState} and {@link #errorState} fields
     * with new {@link State} instances.
     */
    StateMap() {
        stateMap = new HashMap<>();

        startState = new State("START");
        errorState = new State("ERROR");

        final State otherState = new State("OTHER");
        final State newLineState = new State("NEWLINE");
        final State whitespaceState = new State("WHITESPACE");
        final State openingCurlyBraceState = new State("OPENING_CURLY_BRACE");
        final State closingCurlyBraceState = new State("CLOSING_CURLY_BRACE");
        final State semicolonState = new State("SEMICOLON");
        final State singleLineCommentState = new State("SINGLE_LINE_COMMENT");
        final State multilineCommentState = new State("MULTILINE_COMMENT");
        final State characterLiteralState = new State("CHARACTER_LITERAL");
        final State stringLiteralState = new State("STRING_LITERAL");

        stateMap.put(new Pair<>(startState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(startState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(startState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(startState, "NEWLINE"), startState);
        stateMap.put(new Pair<>(startState, "TAB"), startState);
        stateMap.put(new Pair<>(startState, "WHITESPACE"), startState);
        stateMap.put(new Pair<>(startState, "OTHER"), otherState);
        stateMap.put(new Pair<>(startState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(startState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(startState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(startState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(otherState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(otherState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(otherState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(otherState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(otherState, "TAB"), otherState);
        stateMap.put(new Pair<>(otherState, "WHITESPACE"), whitespaceState);
        stateMap.put(new Pair<>(otherState, "OTHER"), otherState);
        stateMap.put(new Pair<>(otherState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(otherState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(otherState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(otherState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(newLineState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(newLineState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(newLineState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(newLineState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(newLineState, "TAB"), newLineState);
        stateMap.put(new Pair<>(newLineState, "WHITESPACE"), newLineState);
        stateMap.put(new Pair<>(newLineState, "OTHER"), otherState);
        stateMap.put(new Pair<>(newLineState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(newLineState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(newLineState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(newLineState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(whitespaceState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(whitespaceState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(whitespaceState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(whitespaceState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(whitespaceState, "TAB"), whitespaceState);
        stateMap.put(new Pair<>(whitespaceState, "WHITESPACE"), whitespaceState);
        stateMap.put(new Pair<>(whitespaceState, "OTHER"), otherState);
        stateMap.put(new Pair<>(whitespaceState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(whitespaceState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(whitespaceState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(whitespaceState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(openingCurlyBraceState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "TAB"), openingCurlyBraceState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "WHITESPACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "OTHER"), otherState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(openingCurlyBraceState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(closingCurlyBraceState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "TAB"), closingCurlyBraceState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "WHITESPACE"), whitespaceState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "OTHER"), otherState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(closingCurlyBraceState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(semicolonState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(semicolonState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(semicolonState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(semicolonState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(semicolonState, "TAB"), semicolonState);
        stateMap.put(new Pair<>(semicolonState, "WHITESPACE"), semicolonState);
        stateMap.put(new Pair<>(semicolonState, "OTHER"), otherState);
        stateMap.put(new Pair<>(semicolonState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(semicolonState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(semicolonState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(semicolonState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(singleLineCommentState, "NEWLINE"), newLineState);

        stateMap.put(new Pair<>(multilineCommentState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(multilineCommentState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(multilineCommentState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(multilineCommentState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(multilineCommentState, "TAB"), multilineCommentState);
        stateMap.put(new Pair<>(multilineCommentState, "WHITESPACE"), whitespaceState);
        stateMap.put(new Pair<>(multilineCommentState, "OTHER"), otherState);
        stateMap.put(new Pair<>(multilineCommentState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(multilineCommentState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(multilineCommentState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(multilineCommentState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(characterLiteralState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(characterLiteralState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(characterLiteralState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(characterLiteralState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(characterLiteralState, "TAB"), characterLiteralState);
        stateMap.put(new Pair<>(characterLiteralState, "WHITESPACE"), whitespaceState);
        stateMap.put(new Pair<>(characterLiteralState, "OTHER"), otherState);
        stateMap.put(new Pair<>(characterLiteralState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(characterLiteralState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(characterLiteralState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(characterLiteralState, "STRING_LITERAL"), stringLiteralState);

        stateMap.put(new Pair<>(stringLiteralState, "OPENING_CURLY_BRACE"), openingCurlyBraceState);
        stateMap.put(new Pair<>(stringLiteralState, "CLOSING_CURLY_BRACE"), closingCurlyBraceState);
        stateMap.put(new Pair<>(stringLiteralState, "SEMICOLON"), semicolonState);
        stateMap.put(new Pair<>(stringLiteralState, "NEWLINE"), newLineState);
        stateMap.put(new Pair<>(stringLiteralState, "TAB"), stringLiteralState);
        stateMap.put(new Pair<>(stringLiteralState, "WHITESPACE"), whitespaceState);
        stateMap.put(new Pair<>(stringLiteralState, "OTHER"), otherState);
        stateMap.put(new Pair<>(stringLiteralState, "SINGLE_LINE_COMMENT"), singleLineCommentState);
        stateMap.put(new Pair<>(stringLiteralState, "MULTILINE_COMMENT"), multilineCommentState);
        stateMap.put(new Pair<>(stringLiteralState, "CHARACTER_LITERAL"), characterLiteralState);
        stateMap.put(new Pair<>(stringLiteralState, "STRING_LITERAL"), stringLiteralState);
    }

    /**
     * Method that returns {@link State} instance that presents start FSM state.
     *
     * @return {@link State} instance that presents start FSM state.
     */
    State getStartState() {
        return startState;
    }

    /**
     * Method that returns {@link State} instance that presents error FSM state.
     *
     * @return {@link State} instance that presents error FSM state.
     */
    State getErrorState() {
        return errorState;
    }

    /**
     * Method that returns {@link State} instance that presents target FSM state
     * corresponding to current FSM state and currently being processed lexical token
     * (or default if there are no matches).
     *
     * @param state {@link State} instance that presents current FSM state.
     * @param token {@link IToken} instance that presents currently being processed lexical token.
     * @return {@link State} instance that presents target FSM state
     * (or default if there are no matches with passed args).
     */
    State getNextState(final State state, final IToken token) {
        return stateMap.getOrDefault(new Pair<>(state, token.getName()), errorState);
    }
}
