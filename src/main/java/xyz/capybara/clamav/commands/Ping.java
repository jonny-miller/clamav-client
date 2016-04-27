package xyz.capybara.clamav.commands;

import xyz.capybara.clamav.exceptions.InvalidResponseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ping extends Command<Void> {

    public static final String COMMAND = "PING";

    @Override
    public String getCommandString() {
        return COMMAND;
    }

    @Override
    protected CommandFormat getFormat() {
        return CommandFormat.NULL_CHAR;
    }

    @Override
    protected Void parseResponse(String responseString) {
        if (!responseString.equals("PONG")) {
            throw new InvalidResponseException(responseString);
        }

        log.debug(responseString);

        return null;
    }
}
