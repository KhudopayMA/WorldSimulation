package presentation;

public enum Emoji {
    PLAIN("\uD83D\uDFE7"),
    GRASS("\uD83E\uDD6C"),
    PREDATOR ("\uD83D\uDC3A"),
    HERBIVORE("\uD83D\uDC07"),
    TREE("\uD83C\uDF33"),
    ROCK("\uD83E\uDEA8");

    private final String symbol;

    Emoji(String emojiUTF16) {
        this.symbol = emojiUTF16;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
