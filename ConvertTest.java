package cn.io.study3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * װ����
 * InputStreamReader
 * OutputStreamWriter
 * 1�����ַ�������ʽ�����ֽ��������ı���
 * 2��ָ���ַ���
 * @author dell
 *
 */

public class ConvertTest {
	public static void teat1(){
	//����System.in��System.out
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//���ֽڵ���ʽ����
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));){
				String line=null;
				while(!(line=br.readLine()).equals("exit")) {//ѭ����ȡ
					bw.write(line);
					bw.newLine();
					bw.flush();
				}
		}catch(IOException e) {
			System.out.println("�����쳣");
			
		}	
	}
	public static void test2() {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"utf-8"));//ָ���ַ���
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));){
			String msg=null;
			while((msg=br.readLine())!=null) {
				bw.write(msg);
				bw.newLine();
			}
			bw.flush();
			
		}catch(IOException e) {
			System.out.println("�����쳣");
		}
				
	}
	public static void main(String[] args) {
		test2();
	}

}
