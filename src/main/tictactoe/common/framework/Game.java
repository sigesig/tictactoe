package tictactoe.common.framework;

public interface Game {

    /**
     * Method for getting the winner
     * @return the player who won
     */
    public Player getWinner();

    /**
     * Get the player who is in turn
     * @return the player
     */
    public Player getPlayerInTurn();

    /**
     * ends the current players turn
     */
    public void endTurn();

    /**
     * Place a piece at a given position
     * @param p postion
     * @return true or false if the piece has been placed
     */
    public boolean placePiece(Position p);

    /**
     * Method for getting piece at a given position
     * @param p the position
     * @return the piece
     */
    Piece getPiece(Position p);
}

