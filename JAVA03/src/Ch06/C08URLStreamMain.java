package Ch06;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class C08URLStreamMain {
	public static void main(String[] args) throws Exception {
		URL uli = (new URI("https://www.etnews.com/20250905000050")).toURL();
		InputStream in = uli.openStream(); //브라우저 -> java
		
		//보조스트림 추가
		BufferedInputStream buffIn = new BufferedInputStream(in);//버퍼 공간 추가 보조스트림
		Reader rin = new InputStreamReader(buffIn);//byte -> char 변환 보조 스트림
		
		Writer fout = new FileWriter("c:\\IOTEST\\index.html"); //원하는 형태의 index파일로 뽑음
		
		while(true) {
			int data = rin.read();
			if(data == -1) {
				break;
			}
//			System.out.println((char)data);
			fout.write((char)data);
			fout.close();
			buffIn.close();
			in.close();
		}
		
		
	}
	
}
