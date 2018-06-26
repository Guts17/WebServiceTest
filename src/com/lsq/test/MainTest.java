package com.lsq.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTest {

	public static void main(String[] args) {
//		String str = "Hello World1!";
//		File file = new File("aa.txt");
//		FileOutputStream fos = null;
//		FileInputStream fis = null;
//		byte[] b = new byte[1024];
//		System.out.println(file.toString());
//		try {
//			fos = new FileOutputStream(file,true);
//			fis = new FileInputStream(file);
//			//fos.write(str.getBytes());
//			fis.read(b);
//			System.out.println(b);
//			uploadFile(b,"cc.txt");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		String[] arr = "eclipse.zip#navicat120.exe#pic01.jpg#".split("#");
		for(String str : arr) {
			System.out.println(str);
		}
	}
	
	public static String uploadFile(byte[] input,String filename) {
		try {
			File file = new File("D:\\xcx\\" + filename);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(input);
		} catch (Exception e) {
			e.printStackTrace();
			return "unsuccess:" + e.getMessage();
		}
		return "success";
	}

}
