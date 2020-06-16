package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		/*
		 *  Scanner 객체를 이용해서 문자열 한줄을 입력 받은 다음
		 *  c:/acorn2020/myFolder/quiz.txt 파일을 만들어서
		 *  해당 파일에 문자열을 저장해 보세요.
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("저장할 문자열 입력:");
		String str = scan.nextLine();
		
		File file1 = new File("c:/acorn2020/myFolder/quiz.txt");

		try {
			boolean isExist = file1.exists();
			if(!isExist) {
				file1.createNewFile();
			}
			// new FileWriter(File 객체, append 모드 여부)
			FileWriter fw = new FileWriter(file1, true);
//			fw.write(str);
			fw.append(str);
			//fw.flush();
			fw.close(); //자동 flush 된다.
			System.out.println("문자열을 저장했습니다.");
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		File file = new File("c:/acorn2020/myFolder/quiz.txt");
//		
//		Scanner scan = new Scanner(System.in);
//		String str;
//		while(true){
//			str = scan.nextLine();
//			try {
//				
//				boolean isExist = file.exists();
//				if(!isExist) {
//					file.createNewFile();
//				}
//				FileWriter fw = new FileWriter(file,true);
//				fw.append(str+"\n");
//				fw.flush();
//				
//				
//				if(str.contains(".")){
//					fw.close();
//					System.out.println("파일이 생성되었습니다.");
//
//					break;
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}	
//		}
	}
}

