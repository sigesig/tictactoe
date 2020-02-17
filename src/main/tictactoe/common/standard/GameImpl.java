package tictactoe.common.standard;

import tictactoe.common.framework.*;

import static tictactoe.common.framework.GameConstants.CIRCLE;
import static tictactoe.common.framework.GameConstants.CROSS;

public class GameImpl implements Game {
    private Piece[][] board;
    private Player currentPlayerInTurn = Player.Cross;
    private boolean turnUsed;

    /**
     * Constructor
     */
    public GameImpl() {
        board = new Piece[3][3];
    }

    public Player getWinner() {
        return null;
    }

    public Player getPlayerInTurn() {
        return currentPlayerInTurn;
    }

    public void endTurn() {
        //Changes the player in turn
        currentPlayerInTurn = (currentPlayerInTurn == Player.Cross ? Player.Circle : Player.Cross);

        //Resets
        resetTurnUsed();
    }

    public boolean placePiece(Position p) {
        if (turnUsed){return false;}
        if (checkPieceAtLocation(p)){return false;}
        board[p.getRow()][p.getColumn()] = (getPlayerInTurn() == Player.Cross) ? new PieceImpl(CROSS) : new PieceImpl(CIRCLE);
        turnUsed = true;
        return true;
    }

    public Piece getPiece(Position p) {
        return board[p.getRow()][p.getColumn()];
    }

    /**
     * Method for checking if there is a piece at a specific location
     * @param p the specific position
     * @return true if a there is a piece else false
     */
    private boolean checkPieceAtLocation(Position p) {
        if (getPiece(p) != null){
            return true;
        }
        return false;
    }

    /**
     * Method for resetting the tracker if a player has used their turn/move
     */
    private void resetTurnUsed(){
        turnUsed = false;
    }

}
