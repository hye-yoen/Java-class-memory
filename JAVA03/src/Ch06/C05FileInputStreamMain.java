package Ch06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class C05FileInputStreamMain {
	public static void main(String[] args) throws IOException{
		InputStream fin = new FileInputStream("c:\\IOTEST\\test.pdf");
		//2byte 기반 이미지 동영상 파일 등등..
		long startTime = System.currentTimeMillis();
		StringBuffer stringbuffer = new StringBuffer();
		byte[] buff = new byte[10000];
		//read
		while(true) {
			int data = fin.read(buff);//buff만큼의 데이터 읽기
			if(data == -1) 
				break;
//			stringbuffer.append((char)data);
			System.out.print(buff);
			
		}
		System.out.println("총길이 : "+stringbuffer.length());
		fin.close();
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : "+ (endTime-startTime)+"ms");
	}
}
