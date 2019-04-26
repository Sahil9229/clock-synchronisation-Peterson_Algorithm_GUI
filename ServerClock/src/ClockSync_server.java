import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
public class ClockSync_server{
	
	public static void init()
	{
		ClockServer cs = new ClockServer();
		cs.start();
	}
}