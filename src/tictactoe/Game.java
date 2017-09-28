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
		playerTurn = 0;
	}
	
	public void addPlayer2(Player player2)
	{
		players[1] = player2.getId();
		playerNames[1] = player2.get_playerName();
	}
	
}
