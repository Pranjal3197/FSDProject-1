import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Operation {
	private File f=new File("D:\\Courses\\Simplilearn\\Pro1");
	private String[] fname;
	
	public Operation(){
		System.out.println("File Operatiions Application (Version - I) ");
		System.out.println("Developed by - Pranjal Jain \n \n");
		fname = f.list();
	}
	
	void sortedfiles() {
		Arrays.sort(fname);
		if(fname.length==0) {
			System.out.println("Directory is Empty");	// No files is there
			return;
			}
		System.out.println("The directory contains following files:");
		for(String s:fname) {
			System.out.println(s);
		}
	}			// Displaying all files present in sorted way
	
	void usermenu() {
		System.out.println("\n  \n");
		System.out.println("User Menu: ");
		System.out.println("1. Add File");
		System.out.println("2. Delete File");
		System.out.println("3. Search for a file");
		System.out.println("Select one option:");
	}			// User Menu for all file functions
	
	void add(String name) throws IOException {
		if(Arrays.binarySearch(fname, name)>=0) {
			System.out.println("File already present");
			return;
		}
		File fil=new File(f.getPath()+"\\"+name);
			if(fil.createNewFile()) {
			fname=f.list();
			System.out.println("File Addition is successfuly completed");
			Arrays.sort(fname);
			}
	}			// Addition of a file

	void delete(String name) {
		if(Arrays.binarySearch(fname, name)<0) {
			System.out.println("File is not present");
			return;
		}
		try {
			Files.deleteIfExists(Paths.get("D:\\Courses\\Simplilearn\\Pro1\\"+name));
			System.out.println("File deleted successfully");
		} catch (IOException e) {
			System.out.println("File doesnot present");
		}
		fname=f.list();
	}			// Deletion of a file
		
	void search(String name) {
		if(Arrays.binarySearch(fname, name)>=0)
			System.out.println("File is present");
		else
			System.out.println("File is not present");
	}			// Searching of a file
		
}
