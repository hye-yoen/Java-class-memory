package Ch09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {

	public static void main(String[] args) throws Exception{
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7000);
		System.out.println("[INFO] SERVER SOCKET LISTENING..");
		// 고객 요청
		Socket client = server.accept();
		System.out.println("[INFO] SERVER ACCEP..CLIENT IP" + client.getInetAddress());
		//받는 것
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		//1byte-> 2byte
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		//
		Scanner sc = new Scanner(System.in);
		String recv = null; //수신용
		String send = null;//송신용
		while(true) {
			//
			System.out.print("[SERVER (q:종료)] : ");
			send = sc.nextLine(); //공백을 포함한 문자열 받기
			
			//server->client(송신)
			dout.writeUTF(send); //send를 UTF=8 형식으로 출력 스트림에 기록
			dout.flush();
			if(send.equals("q")) {
				break;
			}
			//Client->Server(수신)
			recv = din.readUTF();
			if(recv.equals("q")) 
				break;
			System.out.println("[CLIENT] : " +recv);
		}
		
		sc.close();
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();
		server.close();
		System.out.println("[SERVER]  연결 종료합니다.");
		
		
	}

}
