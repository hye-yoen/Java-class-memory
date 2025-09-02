package Ch11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) throws Exception{
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7000);
		System.out.println("[INFO] SERVER SOCKET LISTENING..");
		//고객 요청
		Socket client = server.accept();
		System.out.println("[INFO] SERVER ACCEP..CLIENT IP" + client.getInetAddress());
		//받는 것
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		//1byte-> 2byte
		DataInputStream din = new DataInputStream(in); //데이터를 수신하는 스레드
		DataOutputStream dout = new DataOutputStream(out); //데이터를 송신하는 스레드

		
		//
		 ServerRecvThread recv = new ServerRecvThread(din); // 들어오는 데이터
		 ServerSendThread send = new ServerSendThread(dout); //나가는 데이터
		 //메인스레드 분리?
		 Thread th1 = new Thread(recv);
		 Thread th2 = new Thread(send);
		 //
		 th1.start();
		 th2.start();
		//메인스레드 같이 종료???
		 th1.join();
		 th2.join();
		 //자원제거
		 dout.close();
		 din.close();
		 out.close();
		 in.close();
		 client.close();
		 server.close();
		 System.out.println("[SERVER]  연결 종료합니다.");
		
		
		
		
	}
}
