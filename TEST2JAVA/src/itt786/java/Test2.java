package itt786.java;

import java.net.InetAddress;
import java.net.Inet6Address;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Test2 t2 = new Test2();
		try{
		//Printing Mac Address
		System.out.println("Mac Address -->\t\t"+t2.getMAC());
		
		//Printing IPv6 Address
		
		System.out.print("IPv6 Address -->\t");
		System.out.print(t2.getIPv6Addresses(InetAddress.getAllByName(t2.getIPv4Address().getHostName())).getHostAddress());

		
		
		
		
		//Thread Module
		// Delay, in milliseconds before we interrupt MessageLoop thread (default one hour).
        long patience = 1000 * 60 * 60;

        // If command line argument present, gives patience in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second for MessageLoop thread to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                  && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");

				
		}catch(Exception e){
			
		}

	}
	
	public String getMAC(){
		NetworkInterface network;
		String macAddress = "";
		try {
			network = NetworkInterface.getByInetAddress(getIPv4Address());
			byte[] mac = network.getHardwareAddress();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			macAddress = sb.toString();		
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return macAddress;
	}
	
	public InetAddress getIPv4Address() throws UnknownHostException{
		
		return InetAddress.getLocalHost();
	}
	
	
	public Inet6Address getIPv6Addresses(InetAddress[] addresses) {
	    for (InetAddress addr : addresses) {
	        if (addr instanceof Inet6Address) {
	            return (Inet6Address) addr;
	        }
	    }
	    return null;
	}	
	
	private static class MessageLoop implements Runnable {
	    public void run() {
	        try {
	            for (int i = 0;
	                 i < 10;
	                 i++) {
	                // Pause for 4 seconds
	                Thread.sleep(4000);
	                
	                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	                Date date = new Date();
	                
	                // Print a message
	                threadMessage("Current Date/Time : "+dateFormat.format(date));
	            }
	        } catch (InterruptedException e) {
	            threadMessage("Interrupted - I wasn't done!");
	        }
	    }
	}
	
	 static void threadMessage(String message) {
	        String threadName =
	            Thread.currentThread().getName();
	        System.out.format("%s: %s%n",
	                          threadName,
	                          message);
	        }
	
	 
}


	

	
	

