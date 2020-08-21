import java.util.Scanner;

public class password2 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		String username = "default";
		int pin = 0000;
		boolean userRegistered = false;

	//here is the part where you register a user
		if (!userRegistered)		
		{
			System.out.println("Welcome to this program! \nPlease choose a username!");
			username = reader.nextLine();
			System.out.println("Username set, now please enter a pincode, pin must contain 4 numbers");
			
			boolean pinRegistered = false; //might replace this with userRegistered
			
			while (!pinRegistered)
			{
				try
				{
					pin = Integer.parseInt(reader.nextLine());
					System.out.println("User has been registered");
					pinRegistered = true;
					userRegistered = true;
				}
				catch (NumberFormatException e)
				{
					System.out.println("you have entered forbidden characters, please only use 4 numbers in your pincode");
				}
			}
		}
		
	//here is where you login with registered user
		if (userRegistered)
		{
			int tries = 3;
			boolean userAccepted = false;
			boolean canLogin = false;

			while (tries > 0 && !userAccepted) {						//here you login with the username
				System.out.println("Please enter your username");
				String input = reader.nextLine();	//creates a String for the input in console
				
				if (input.equals(username)) {		//checks if input is the same as username
					userAccepted = true;
					System.out.println("you have entered a correct username");
					tries = 3;
				} 
				else 							//if input isn't the correct username
				{
					tries = tries - 1;
					System.out.println("You have entered the wrong username, you have " + tries + " tries left\n");
				}
			}
			
			while (tries > 0 && !canLogin && userAccepted) {						//here you login with the pin
				System.out.println("Now, please enter your password");
				String input = reader.nextLine();	//creates a String for the input in console
				int i = 0;
				
				try //tries if the input is a correct entered pin
				{
					i = Integer.parseInt(input);
				}
				catch (NumberFormatException e) //if the pin contains forbidden characters
				{
					System.out.println("you have entered forbidden characters, please try again");
				}
				
				if(i != pin)
				{
					tries--;
					System.out.println("you have entered wrong pin, please try again. You have " + tries + " tries left");
				}
				if (i == pin)
				{
					System.out.println("you have entered the correct pin");
					canLogin = true; //if both correct pin and username has been entered, user can login
				}
			}
			
			if (tries == 0) //if username or pin has been entered 3 times, user gets "blocked" and can't re-enter username
			{
				System.out.println("Sorry, you have entered the wrong username/pin 3 times. your account is now blocked");
				//here you can shut down the application
			}		
			if(canLogin == true) //if correct password has been entered, user gets "logged in" and can't enter username/pin again again
			{
				System.out.println("Welcome to this program!"); //from here, the user gets logged in to the potential program
			}
			
			
		}

	}

}
