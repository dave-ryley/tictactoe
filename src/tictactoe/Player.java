package tictactoe;

public class Player {
	private int _playerID;
	private String _playerName;
	
	public Player(int id, String name)
	{
		_playerID = id;
		set_playerName(name);
	}
	
	public int getId()
	{
		return _playerID;
	}

	public String get_playerName() {
		return _playerName;
	}

	public void set_playerName(String _playerName) {
		this._playerName = _playerName;
	}
}
