import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BattleShipNetClientMain
{
	public static void main(String[] args)
	{
		if (2 != args.length)
		{
			System.out.println("Usage: BattleShipNetClientMain <host name> <port number>");
			System.exit(1);
		}

		String hostName   = args[0];
		int    portNumber = 0;
		try 
		{ 
			portNumber = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Wrong value for <port number> given.");
		}

		try {
			BattleShipNetClient bsnc = new BattleShipNetClient(hostName, portNumber);
			bsnc.play();
		}
		catch (UnknownHostException e)
		{
			System.err.println("Unknown host exception"+e);
		}
		catch (IOException e)
		{
			System.err.println("I/O exception"+e);
		}
		catch (PointConversionException e)
		{
			System.err.println("Point conversion, protocol error "+e);
		} 
	}
}
