package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
	private LinkedList<FSElement> children;
	private LinkedList<Directory> directory;
	private LinkedList<File> file;
	
	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if(parent!= null) {
			parent.appendChild(this);
		}
		children = new LinkedList<FSElement>();
	}
	
	public LinkedList<FSElement> getChildren() {
		lock.lock();
		try {
			return this.children;
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public void appendChild(FSElement child) {
		lock.lock();
		try {
			this.children.add(child);
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public int countChildren() {
		lock.lock();
		try {
			int count=0;
			for(@SuppressWarnings("unused") FSElement f: this.children) {
				count+=1;
			}
			return count;
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public LinkedList<Directory> getSubDirectory(){
		lock.lock();
		try {
			for(FSElement s: getChildren()) {
				if(s instanceof Directory) {
					directory.add((Directory) s);
				}
			}
			return directory;
		}
		finally {
			lock.unlock();
		}
	}
	
	public LinkedList<File> getFiles(){
		lock.lock();
		try {
			for(FSElement s: getChildren()) {
				if(s instanceof File) {
					file.add((File) s);
				}
			}
			return file;
		}
		finally {
			lock.unlock();
		}
	}
	
	public int getTotalSize() {
		lock.lock();
		try {
			int totalSize=0;
			for(FSElement f: getChildren()) {
				if(f instanceof Directory) {
					totalSize+= ((Directory)f).getTotalSize();
				}
				else {
					totalSize+= f.getSize();
				}
			}
			return totalSize;
		}
		finally {
			lock.unlock();
		}
	}
	
	

	@Override
	public boolean isDirectory() {
		lock.lock();
		try {
			if(this instanceof Directory) {
				return true;
			}
			return false;
		}
		finally {
			lock.unlock();
		}
		
	}
	
}