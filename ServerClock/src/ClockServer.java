import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import java.lang.*;


public class ClockServer extends Thread {
	public static int Cno;
	public static String port;
	//public static ThreadLocal port=new ThreadLocal();
	
	
	
	public void run(){
		
	    
        BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
        System.out.print("Server port:"+port);
       
       // try {
        	//String port=null;
        	//port=stdIn.readLine();
		//} catch (IOException e1 ) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
	 // }
               
        int portNumber = Integer.parseInt(port);
        /*try {
			sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        try 
             {
        	ServerSocket serverSocket =
                    new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();     
              InputStream is=clientSocket.getInputStream();
              DataInputStream dis=new DataInputStream(is);
              
             
      					Cno+=dis.readInt();
      					
      					
              
              
                
                PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);                   
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        	
        	
        	
        	
            String inputLine;
            System.out.println("Server Started");
            while (true) {
                inputLine = in.readLine();
                if(inputLine.equalsIgnoreCase("Exit"))
                {
                     System.out.println("Exiting");
                     out.println("Server Exiting");
                     break;
                }
                out.println(System.currentTimeMillis()+5000);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
	}
}