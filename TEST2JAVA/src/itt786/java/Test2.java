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
		
		//Printing Mac Address
		System.out.println("Mac Address -->\t"+t2.getMAC());

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
	
	

	
	
}
