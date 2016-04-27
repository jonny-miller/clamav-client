package xyz.capybara.clamav.commands.scan;

import xyz.capybara.clamav.commands.Command;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Scan extends ScanCommand {

    public static final String COMMAND = "SCAN";

    private String path;

    public Scan(String path) {
        this.path = path;
    }

    @Override
    public String getCommandString() {
        return COMMAND;
    }

    @Override
    protected Command.CommandFormat getFormat() {
        return Command.CommandFormat.NULL_CHAR;
    }

    @Override
    protected ByteBuffer getRawCommand() {
        StringBuilder rawCommand = new StringBuilder();
        rawCommand.append(getFormat().getPrefix())
                .append(getCommandString())
                .append(' ')
                .append(path)
                .append(getFormat().getTerminator());

        return ByteBuffer.wrap(rawCommand.toString().getBytes(StandardCharsets.US_ASCII));
    }
}
