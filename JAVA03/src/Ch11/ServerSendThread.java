package Ch11;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ServerSendThread implements Runnable{
	
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	
	public ServerSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {
		String send = null;
		while(true) {
			
			try {
			
			System.out.print("[SERVER (q:종료)] : ");
			send = sc.nextLine(); //공백을 포함한 문자열 받기
			
			//Server->Client(송신)
			dout.writeUTF(send); //send를 UTF=8 형식으로 출력 스트림에 기록
			dout.flush(); //버퍼 초기화
			if(send.equals("q")) {
				break;
			}
			}catch(Exception e) {
				System.out.println("[Exception] 예외발생 SEND THREAD 종료");
				break;
			}
		}
		

		
		sc.close();
		
	}

}
