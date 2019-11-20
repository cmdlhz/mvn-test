package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CharTest {
	public static void main(String[] args) {
		int k = 15;
		char c = '가';
		char a = 'a';
//		System.out.println(Integer.toHexString(k)); // 유니코드
//		System.out.println(Integer.toHexString(c)); 
//		System.out.println(Integer.toHexString(a)); // 아스키 코드
		
//		for(int j=0; j<=127; j++) {
//			System.out.println((char)j);
//		}
		
		String sPath = "c:\\test.txt";
		String tPath = "c:\\test1.txt";
		try {
			FileInputStream fis = new FileInputStream(sPath);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8"); // 보조스트림 (생크림 넣는 틀처럼)
			BufferedReader br = new BufferedReader(isr);
			String str = null; // int에는 null이 없다. Integer는 정해져 있지 않은 data type이 아니므로 null이 나올 수 있음
			String string = "";
			while((str=br.readLine()) != null) {
				System.out.println(str);
				string += str;
			}
			FileOutputStream fos = new FileOutputStream(tPath);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(string);
			bw.flush(); // 처음부터 한 것을 반대로 한 것~
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String str = "abcd";
//		char x = str.charAt(0);
//		System.out.println(x);
	}
}
