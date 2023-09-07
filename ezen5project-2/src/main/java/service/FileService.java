package service;

import java.io.File;

public class FileService {
	
	// 1. 파일 삭제 메소드
		public static boolean fileDelete(String filepath) {
			
			// 1. 파일경로의 파일객체 선언[ 다양한 메소드 제공 ]
			File file = new File(filepath);
			
			if(file.exists()) {
				file.delete();		// 경로상의 파일 삭제
			}
			
			return false;
		}

}
