package cn.io.study3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 装换流
 * InputStreamReader
 * OutputStreamWriter
 * 1，以字符流的形式操作字节流（纯文本）
 * 2，指定字符集
 * @author dell
 *
 */

public class ConvertTest {
	public static void teat1(){
	//操作System.in和System.out
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//按字节的形式读入
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));){
				String line=null;
				while(!(line=br.readLine()).equals("exit")) {//循环读取
					bw.write(line);
					bw.newLine();
					bw.flush();
				}
		}catch(IOException e) {
			System.out.println("操作异常");
			
		}	
	}
	public static void test2() {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"utf-8"));//指定字符集
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));){
			String msg=null;
			while((msg=br.readLine())!=null) {
				bw.write(msg);
				bw.newLine();
			}
			bw.flush();
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
				
	}
	public static void main(String[] args) {
		test2();
	}

}
