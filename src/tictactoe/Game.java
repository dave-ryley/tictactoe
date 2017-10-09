package tictactoe;

public class Game 
{
	private byte[] board;
	private int[] players;
	private int playerTurn;
	private String[] playerNames;
	
	public Game(Player player)
	{
		board = new byte[9];
		players = new int[2];
		players[0] = player.getId();
		playerNames = new String[2];
		playerNames[0] = player.get_playerName();
		playerTurn = 1;
	}
	
	public void addPlayer2(Player player2)
	{
		players[1] = player2.getId();
		playerNames[1] = player2.get_playerName();
	}
        
        public int makeMove(int square)
        {
            int result = playerTurn;
            board[square] = (byte) playerTurn;
            nextPlayer();
            return result;
        }
        
        private void nextPlayer()
        {
            playerTurn = (playerTurn == 1) ? 2 : 1;
        }
        
        private void clearBoard()
        {
            for(int i = 1; i < 9; i++)
            {
                board[i] = 0;
            }
        }
	
}
