package tictactoe.common.standard;

import tictactoe.common.framework.GameConstants;
import tictactoe.common.framework.Piece;
import tictactoe.common.framework.Position;

public class PieceImpl implements Piece {

    private final String type;

    public PieceImpl(String type) {
        this.type = type;
    }

    @Override
    public String getTypeString() {
        return type;
    }

}
