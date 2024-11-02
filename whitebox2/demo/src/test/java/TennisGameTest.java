import static org.junit.Assert.*;

import org.junit.Test;

import com.example.TennisGame;
import com.example.TennisGameException;

public class TennisGameTest {
	
	// Here is the format of the scores: "player1Score - player2Score"
	// "love - love"
	// "15 - 15"
	// "30 - 30"
	// "deuce"
	// "15 - love", "love - 15"
	// "30 - love", "love - 30"
	// "40 - love", "love - 40"
	// "30 - 15", "15 - 30"
	// "40 - 15", "15 - 40"
	// "player1 has advantage"
	// "player2 has advantage"
	// "player1 wins"
	// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}

	// My tests
	@Test
    public void testInitialScore() {
		TennisGame game = new TennisGame();
        assertEquals("love - love", game.getScore());
    }

	@Test
    public void testPlayer1Scores() throws TennisGameException {
		TennisGame game = new TennisGame();
        game.player1Scored();
        assertEquals("love - 15", game.getScore());
    }

	@Test
    public void testPlayer2Scores() throws TennisGameException {
		TennisGame game = new TennisGame();
        game.player2Scored();
        assertEquals("15 - love", game.getScore());
    }

    @Test
    public void testDeuce() throws TennisGameException {
		TennisGame game = new TennisGame();
        for (int i = 0; i < 3; i++) {
            game.player1Scored();
            game.player2Scored();
        }
        assertEquals("deuce", game.getScore());
    }

	@Test
    public void testPlayer1Advantage() throws TennisGameException {
        TennisGame game = new TennisGame();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
		game.player2Scored();
		game.player2Scored();
        game.player1Scored();
        assertEquals("player1 has advantage", game.getScore());
    }

	@Test
    public void testPlayer2Advantage() throws TennisGameException {
        TennisGame game = new TennisGame();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player1Scored();
		game.player1Scored();
		game.player1Scored();
        game.player2Scored();
        assertEquals("player2 has advantage", game.getScore());
    }

    @Test
    public void testPlayer2Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
        game.player2Scored();
        game.player2Scored();
        game.player2Scored();
        game.player1Scored();
        game.player1Scored();
		game.player2Scored();
        assertEquals("player2 wins", game.getScore());
    }

    @Test
    public void testPlayer1Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
		game.player1Scored();
        assertEquals("player1 wins", game.getScore());
    }

	@Test
	public void testBackToDeuceAfterAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored(); 
		game.player2Scored(); 
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		assertEquals("deuce", game.getScore());
	}

	@Test
	public void testPlayer2WinsAfterAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("player2 wins", game.getScore());
	}

	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}

}