package edu.umb.cs681.hw12;

import java.time.LocalDateTime;

public class DirectoryCreate {
	
	public static void main(String[] args) {
		
		LocalDateTime localTime = LocalDateTime.now();
		
		Directory root = new Directory(null,"root",0, localTime);
		Directory applications = new Directory(root,"applications",0, localTime);
		Directory home = new Directory(root,"home",0, localTime);
		Directory code = new Directory(home,"code",0, localTime);
		Directory pics = new Directory(home,"pics",0, localTime);
			
		File a = new File(applications,"a",1,localTime);
		File b = new File(home,"b",1,localTime);
		File c = new File(code,"c",1,localTime);
		File d = new File(code,"d",1,localTime);
		File e = new File(pics,"e",1,localTime);
		File f = new File(pics,"f",1,localTime);
		
		System.out.println("Size of root: " + root.getTotalSize());
		System.out.println("Size of home: " + home.getTotalSize());
		System.out.println("Size of code: " + code.getTotalSize());
	}

}
