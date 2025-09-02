package Ch09;
// 192.168.16.10
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class C01Clinet {
 public static void main(String[] args) throws IOException {
	Socket client = new Socket("192.168.5.200", 7000);

	//서버 내용 받는 작업
	InputStream in = client.getInputStream(); //정보정달 inputStream
	DataInputStream din = new DataInputStream(in);//1byte -> char
	String recv = din.readUTF(); //UTF-8로 해석해서 문자열로 일기
	System.out.println("메세지" + recv);
	
	din.close();
	in.close();
	client.close();

	
	 
}
}
