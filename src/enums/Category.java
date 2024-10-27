package enums;

public enum Category {
    COMMAND("command"),
    PLAYER_INDEX("playerIdx"),
    HAND_INDEX("handIdx"),
    CARD_ATTACKER("cardAttacker"),
    CARD_ATTACKED("cardAttacked"),
    AFFECTED_ROW("affectedRow"),
    X("x"),
    Y("y"),
    OUTPUT("output"),
    ERROR("error");

    private final String category;

    Category(final String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}