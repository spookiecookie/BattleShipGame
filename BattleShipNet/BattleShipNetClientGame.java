public class BattleShipNetClientGame
	extends Game
{
	public BattleShipNetClientGame(Player p1, Board b1, Player p2, Board b2)
	{
		super(p1,b1,p2,b2);
	}

	public Player getServerPlayer()
	{
		return player(0).getStrategy() instanceof BattleShipStrategyServer ? player(0) : player(1);
	}

	public Player getClientPlayer()
	{
		return opponent(getServerPlayer());
	}

	public void setHitAt(Point point)
	{
		Tile tile = getBoard(getServerPlayer()).getTileAt(point);
		tile.setHit(true);
		tile.setAttacked(true);
	}

	public void setMissAt(Point point)
	{
		Tile tile = getBoard(getServerPlayer()).getTileAt(point);
		tile.setAttacked(true);
	}

}
