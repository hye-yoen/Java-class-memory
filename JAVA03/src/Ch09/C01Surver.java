package Ch09;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class C01Surver {
 public static void main(String[] args) throws IOException {
	//서버 소켓 형성
	 ServerSocket server = new ServerSocket(7000); //IP:192,168,5,50 Port : 7000
	 //192.168.16.10
	 System.out.println("[INFO] SERVER SOCKET LISTENING");
	 
//	 //1회 접속
//	 Socket client = server.accept(); // 1회 (통신대기) //소캣생성
//	 OutputStream out = client.getOutputStream(); //고객 정보 전달(받기)위해 outputstrema 사용
//	 DataOutputStream dout = new DataOutputStream(out); //byte -> char
//	 //DataOutputStream 자체가 byte만 다룸
//	 dout.writeUTF("[SERVER] WELCOME TO SERVER + " +  new Date());
//	 dout.flush();
//	 dout.close();
//	 out.close();
//	 client.close();
//
//	 server.close();
//	 
//	 System.out.println("[INFO] SERVER EXIT");
	 
	 while(true) {
		 Socket client = server.accept(); // 1회 (통신대기) //소캣생성
		 OutputStream out = client.getOutputStream(); //고객 정보 전달(받기)위해 outputstrema 사용
		 DataOutputStream dout = new DataOutputStream(out); //byte -> char
		 //DataOutputStream 자체가 byte만 다룸
		 dout.writeUTF("[SERVER] WELCOME TO SERVER + " +  new Date());
		 dout.flush();
		 dout.close();
		 out.close();
		 client.close();
	 }
	 
	 

 
 }
}
