package it.sevenbits.formatter;

import it.sevenbits.formatter.formatter.FormatterException;
import it.sevenbits.formatter.formatter.IFormatter;
import it.sevenbits.formatter.formatter.fsm.FSMFormatter;
import it.sevenbits.formatter.io.reader.FileReader;
import it.sevenbits.formatter.io.reader.ReaderException;
import it.sevenbits.formatter.io.writer.FileWriter;
import it.sevenbits.formatter.io.writer.WriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class of application.
 */
public final class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * A private constructor created to exclude the possibility of creating instances of this class.
     */
    private Main() {
    }

    /**
     * Main entry point of application.
     *
     * @param args Command-line arguments.
     */
    public static void main(final String[] args) {
        if (args.length != 2) {
            LOGGER.error("Incorrect number of command-line args (expected 2: input file path, output file path)");
            return;
        }

        final IFormatter formatter = new FSMFormatter();

        try (
                FileReader reader = new FileReader(args[0]);
                FileWriter writer = new FileWriter(args[1])
        ) {
            formatter.format(reader, writer);
        } catch (ReaderException | WriterException | FormatterException e) {
            LOGGER.error(String.format("%s - %s", e.getClass().getSimpleName(), e.getMessage()));
        }
    }
}
