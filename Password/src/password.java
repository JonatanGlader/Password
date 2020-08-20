import java.util.Scanner;

public class password {

	public static void main(String[] args) {

		String pass = "default";
		int tries = 3;
		boolean canLogin = false;
		Scanner reader = new Scanner(System.in);

		while (tries > 0 && canLogin == false) {						//if the users have tries left, they can try to log in
			System.out.println("Please enter your password");
			String input = reader.nextLine();	//creates a String for the input
			
			if (input.equals(pass)) {		//checks if input is the same as pass
				canLogin = true;
				System.out.println("you have logged in");
			} 
			else 							//if input isn't the correct pass
			{
				tries = tries - 1;
				System.out.println("You have entered the wrong password, you have " + tries + " tries left\n");
			}
		}
		if (tries == 0) //if password has been entered 3 times, user gets "blocked" and can't re-enter password
		{
			System.out.println("Sorry, you have entered the wrong password 3 times. your account is now blocked");
			//here you can shut down the application
		}
		if(canLogin == true) //if correct password has been entered, user gets "logged in" and can't enter password again
		{
			System.out.println("Welcome to this program!");
		}
		reader.close();
	}
}
