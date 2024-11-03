package game;

import cards.MinionCard;
import fileio.Coordinates;

import java.util.ArrayList;

public final class GameBoard {

    private final ArrayList<ArrayList<MinionCard>> board;

    private static final int BOARD_ROWS = 4;
    private static final int BOARD_COLUMNS = 5;

    public GameBoard() {
        board = new ArrayList<>();
        for (int i = 0; i < BOARD_ROWS; i++) {
            board.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<MinionCard>> getBoard() {
        return board;
    }

    public static int getBoardRows() {
        return BOARD_ROWS;
    }

    /**
     * Returns all cards on the board.
     * @return
     */
    public ArrayList<ArrayList<MinionCard>> getAllCardsOnTable() {
        return new ArrayList<>(board);
    }

    /**
     * Checks if a row is full.
     * @param row
     * @return
     */
    public boolean isRowFull(final int row) {
        return board.get(row).size() == BOARD_COLUMNS;
    }

    /**
     * Places a card on the board.
     * @param card
     * @param row
     */
    public void placeCard(final MinionCard card, final int row) {
        board.get(row).add(card);
    }

    /**
     * Removes a card from the board.
     * @param coordinates
     */
    public void removeCard(final Coordinates coordinates) {
        board.get(coordinates.getX()).remove(coordinates.getY());
    }

    /**
     * Returns the card at the given coordinates.
     * @param coordinates
     * @return
     */
    public MinionCard getCardFromTable(final Coordinates coordinates) {
        return board.get(coordinates.getX()).get(coordinates.getY());
    }

    /**
     * Checks if a card already attacked.
     * @param coordinates
     * @return
     */
    public boolean cardAttacked(final Coordinates coordinates) {
        return board.get(coordinates.getX()).get(coordinates.getY()).getAttacked();
    }

    /**
     * Freezes a card on the board.
     * @param coordinates
     */
    public void freezeCard(final Coordinates coordinates) {
        board.get(coordinates.getX()).get(coordinates.getY()).freeze();
    }

    /**
     * Unfreezes all cards on the specified row.
     * @param row
     */
    public void unfreezeAllCardsOnRow(final int row) {
        for (MinionCard card : board.get(row)) {
            if (card != null) {
                card.unfreeze();
            }
        }
    }

    /**
     * Resets the attacked status of all cards on the specified row.
     * @param row
     */
    public void resetAttackedOnRow(final int row) {
        for (MinionCard card : board.get(row)) {
            if (card != null) {
                card.setAttacked(false);
            }
        }
    }

    public boolean isEnemy(final Player player, final Coordinates coordinates) {
        if (coordinates.getX() != player.getBackRow() && coordinates.getX() != player.getFrontRow()) {
            return true;
        }
        return false;
    }
}
