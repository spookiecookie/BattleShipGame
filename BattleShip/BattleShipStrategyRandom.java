public class BattleShipStrategyRandom
	extends BattleShipStrategy
{
	public Point getNextPoint(Board board)
	{
		return board.getRandomNotAttacked();
	}
}
