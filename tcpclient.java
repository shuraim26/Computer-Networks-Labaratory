
	import java.util.*;
	import java.io.*;
	import java.net.*;

class tcpclient{
	public static void main(String args[]) throws IOException {
	String filename ;
	Socket s = new Socket("127.0.0.1",12345);
	Scanner input = new Scanner(System.in);
	Scanner sc = new Scanner(s.getInputStream());
	System.out.println("Enter the name of the file ");
	filename = input.nextLine();
	PrintStream p = new PrintStream (s.getOutputStream());
	p.println(filename);	
	while(sc.hasNextLine()){
	System.out.println(sc.nextLine());
	}
	p.close();
	sc.close();
	}
}



