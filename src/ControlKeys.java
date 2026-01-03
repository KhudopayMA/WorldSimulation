public enum ControlKeys {
    PAUSE('p'),
    QUIT('q');

    private final char key;

    ControlKeys(char key) {
        this.key = key;
    }

    public char getKey(){
        return key;
    }
}
