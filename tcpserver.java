import java.util.*;
import java.io.*;
import java.net.*;

class tcpserver{

	public static void main(String args[]) throws IOException{	
	String filename;	
	ServerSocket s = new ServerSocket(12345);
	Socket skt = s.accept();
	Scanner sc = new Scanner(skt.getInputStream());
	filename = sc.nextLine();
	Scanner scf = new Scanner(new File(filename));
	PrintStream p = new PrintStream (skt.getOutputStream());
	while(scf.hasNextLine()){	
	p.println(scf.nextLine());
	}
	scf.close();
	
	}

}
