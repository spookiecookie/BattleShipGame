public class BattleShipNetClientThread 
	extends BattleShipNetThread
{
	private BattleShipNetClientGame game   ;

	public BattleShipNetClientThread(Socket socket)
	{
		this.game = BattleShipNetGameFactory.getClientGame();
	}

	public void setGame(BattleShipNetClientGame game)
	{
		this.game = game;
	}

	public BattleShipNetClientGame getGame()
	{
		return game;
	}

	public void run()
	{
		getCommunicationModule().init();
	}

	public void say(String str)
	{
		getCommunicationModule().say(str);
	}

	public String getLineBlocking()
	{
		String str = null;
		while (null != (str = getCommunicationModule().readLine()))
		{
		}
		return str;
	}

	public boolean gameOver()
	{
		return getGame().isOver();
	}

	public boolean attacks()
	{
		return BattleShipNetProtocol.attacks(
				getCommand());
	}

	public boolean attack()
	{
		return BattleShipNetProtocol.attack().equals(
				getCommand());
	}
	
	public void attackAt(Point point)
	{
		say(BattleShipNetProtocol.attackAt(point));
	}

	public boolean isHit()
	{
		return BattleShipNetProtocol.isHitAt(getCommand());
	}

	public boolean isSunken()
	{
		return BattleShipNetProtocol.isSunken(getCommand());
	}

}