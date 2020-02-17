import org.junit.Before;
import org.junit.Test;
import tictactoe.common.framework.Game;
import tictactoe.common.framework.Player;
import tictactoe.common.framework.Position;
import main.tictactoe.common.standard.GameImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tictactoe.common.framework.GameConstants.CIRCLE;
import static tictactoe.common.framework.GameConstants.CROSS;


public class TestTicTacToe {
    private Game game;
    @Before
    public void setUp() {
        game = new GameImpl();
    }

    @Test
    public void shouldShowFirstPlayerBeCross() {
        assertThat(game.getPlayerInTurn(),is(Player.Cross));
    }

    @Test
    public void shouldShowCircleTurnAfterEndOfCrossTurn(){
        game.endTurn();
        assertThat(game.getPlayerInTurn(),is(Player.Circle));
    }

    @Test
    public void shouldShowCrossPlayerPlaceCrossInTopLeftConnor() {
        assertThat(game.placePiece(new Position(0,0)),is(true));
        assertThat(game.getPiece(new Position(0,0)).getTypeString(),is(CROSS));
    }

    @Test
    public void shouldShowCrossPlayerPlaceCrossInBottomLeftConnor() {
        assertThat(game.placePiece(new Position(2,2)),is(true));
        assertThat(game.getPiece(new Position(2,2)).getTypeString(),is(CROSS));
    }

    @Test
    public void shouldShowCirclePlayerPlaceCircleInTopLeftConnorInItsFirstTurn() {
        game.endTurn();
        assertThat(game.placePiece(new Position(0,0)),is(true));
        assertThat(game.getPiece(new Position(0,0)).getTypeString(),is(CIRCLE));
    }

    @Test
    public void shouldShowCircleNotAbleToPlaceInTopLeftConnorWhenAPieceIsThere() {
        game.placePiece(new Position(0,0));
        game.endTurn();
        assertThat(game.placePiece(new Position(0,0)),is(false));
        assertThat(game.getPiece(new Position(0,0)).getTypeString(),is(CROSS));
    }

    @Test
    public void shouldShowCrossNotAbleToPlaceInTopLeftConnorWhenAPieceIsThere() {
        game.endTurn();
        game.placePiece(new Position(0,0));
        game.endTurn();
        assertThat(game.placePiece(new Position(0,0)),is(false));
        assertThat(game.getPiece(new Position(0,0)).getTypeString(),is(CIRCLE));
    }

    @Test
    public void ShouldShowCrossPlayerNotAbleToPlaceACrossTwiceInATurn() {
        assertThat(game.placePiece(new Position(0,0)),is(true));
        assertThat(game.placePiece(new Position(0,1)),is(false));
    }

    @Test
    public void ShouldShowCirclePlayerNotAbleToPlaceACirlceTwiceInATurn() {
        assertThat(game.placePiece(new Position(0,0)),is(true));
        assertThat(game.placePiece(new Position(0,1)),is(false));
    }
}
