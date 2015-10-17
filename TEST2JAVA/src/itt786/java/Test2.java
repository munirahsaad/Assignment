package itt786.java;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

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

}
	

	
	

