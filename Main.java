import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Operation op=new Operation();
	
	static void mainmenu() {
		System.out.println("Main Menu");
		System.out.println("1. Display files present");	//Files will be listed out in ascending order
		System.out.println("2. User Menu");				//All file related operations done here
		System.out.println("3. Exit");					//Completion of program
	}
	
	static void option(int x) throws IOException {
		switch(x) 
		{
		case 1: op.sortedfiles();
				break;
		case 2: op.usermenu();
				select();
				break;
		case 3: return;
		default: System.out.println("Invalid Input");
		}
	}
	
	static void select() throws IOException {
		BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(ob.readLine());
		switch(x) 
		{
		case 1: System.out.println("Enter the file name :");
				op.add(ob.readLine());
				break;
		case 2: System.out.println("Enter the name of file to delete");
				op.delete(ob.readLine());
				break;
		case 3: System.out.println("Enter file name to be searched:");
				op.search(ob.readLine());
				break;
		default: System.out.println("Invalid Input");
		}
		System.out.println("Task Completed"+"\n"+"Back to main menu:");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
		int option=0;
		while(option!=3) {
			mainmenu();
			option=Integer.parseInt(ob.readLine());
			option(option);  
		}
	}
}