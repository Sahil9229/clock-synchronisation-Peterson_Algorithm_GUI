import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

class ClockClient extends Thread{
	static String port,hostName;

	public void run() {
	
	
        
        BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
        
		try {
			sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("port no:"+port);
       // try {
			//port=stdIn.readLine();
	//	} catch (IOException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
        int portNumber = Integer.parseInt(port);
        System.out.println("host IP:"+hostName);
       // try {
		//	hostName=stdIn.readLine();
		//} catch (IOException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
        try 
           {
            
        	 Socket echoSocket = new Socket(hostName, portNumber);
            
        	 OutputStream os=echoSocket.getOutputStream();
        	 DataOutputStream dos =new DataOutputStream(os);
        	 dos.writeInt(1);
        	 PrintWriter out =
                 new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in =
                 new BufferedReader(
                     new InputStreamReader(echoSocket.getInputStream()));
        	
        	
        	String userInput;
            System.out.println("Client Started");
            System.out.println("Enter Exit to stop");
            
                long T0;
                long serverTime;
                long T1;
                long finalTime;                
                out.println(T0=System.currentTimeMillis());
                serverTime = Long.parseLong(in.readLine());
                
                
                

                
                T1 =System.currentTimeMillis();
                finalTime =  serverTime + (T1-T0)/2;
                DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                System.out.println("Client Time: " + formatter.format(new Date(T1)));
                System.out.println("Server Time: " + formatter.format(new Date(serverTime)));
               
                String STM= formatter.format(new Date(finalTime));
        /////// 
                System.out.println();
                System.out.println(STM);
                System.out.println(STM);
                try{
            		Runtime.getRuntime().exec("cmd /C time " + STM); // hh:mm:ss
            		}catch(IOException e)
                    {e.printStackTrace();}
                
                System.out.println("Client Time after reset: " + formatter.format(new Date(finalTime)));
                
              //  out.println("EXit");
                
               
           
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}
