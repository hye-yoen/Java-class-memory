package Ch11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) throws Exception{
		//서버 연결 요청
		Socket client = new Socket("192.168.5.50" , 7000);
		System.out.println("SERVER 와 연결 되었습니다.");
		//받는 것
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		//1byte-> 2byte
		DataInputStream din = new DataInputStream(in); //데이터를 수신하는 스레드
		DataOutputStream dout = new DataOutputStream(out); //데이터를 송신하는 스레드

				
		//객체 생성
		 ClientRecvThread recv = new ClientRecvThread(din); // 들어오는 데이터
		 ClientSendThread send = new ClientSendThread(dout); //나가는 데이터
		 //메인스레드 분리?
		 Thread th1 = new Thread(recv);
		 Thread th2 = new Thread(send);
		 //
		 th1.start();
		 th2.start();
		//메인쓰레드 종료까지 대기
		 th1.join();
		 th2.join();
		 //자원제거
		 dout.close();
		 din.close();
		 out.close();
		 in.close();
		 client.close();
		 System.out.println("[SERVER]  연결 종료합니다.");
	}
}
