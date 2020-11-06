import java.util.Random;
import java.util.Scanner;

public class Bullseye
{
    private Random rand = new Random();
    Scanner my_scanner = new Scanner(System.in);
    // Constants & class params.
    final private int min_target_value = 1000;
    final private int number_length = 4;
    private String guess_history = "";
    private int number_of_guesses = 0;

    // Main flow.
    public void run_main_flow()
    {
        String target = this.randomize_target();
        String guess = this.take_a_guess();
        this.number_of_guesses++;
        this.guess_history += guess+"\n";
        boolean bullseye = this.compare_guess_to_target(guess, target);
        while (true)
        {
            if (bullseye == true)
            {
                System.out.println("Would you like to start a new game? (yes/no)");
                if (my_scanner.nextLine().equals("yes"))
                {
                    target = this.randomize_target();
                    this.guess_history = "";
                    this.number_of_guesses = 0;
                }
                else return;
            }
            guess =this.take_a_guess();
            this.guess_history += guess+"\n";
            this.number_of_guesses++;
            bullseye = this.compare_guess_to_target(guess, target);
        }
    }

    // Randomize a target number.
    private String randomize_target()
    {
        int target = this.rand.nextInt(8999) + this.min_target_value;
        String target_string = String.valueOf(target);
        while (true)
        {
            target_string = this.check_my_number(target_string);
            if (target_string != null)
                return target_string;
            target = this.rand.nextInt(8999) + this.min_target_value;
            target_string = String.valueOf(target);
        }
    }
    // Checks that the number provided is according to requirements.
    private String check_my_number(String number)
    {
        for (int i = 0; i < number.length()-1; i++)
            for (int j = i+1; j < number.length(); j++)
                if (number.charAt(i) == number.charAt(j) || number.charAt(i) < '0' || number.charAt(j) < '0' || number.charAt(i) > '9' || number.charAt(j) > '9')
                    return null;
        return number;
    }
    // function to take a guess from the user.
    private String take_a_guess()
    {
        System.out.println("Insert Your guess:");
        String guess_number = my_scanner.nextLine();
        guess_number = this.check_my_number(guess_number);
        while (guess_number == null || guess_number.length() != this.number_length)
        {
            System.out.println("Your guess number had duplicates, please try insert another guess without duplicates:");
            guess_number = my_scanner.nextLine();
            guess_number = this.check_my_number(guess_number);
        }
        return guess_number;
    }
    // Compares target number to user guess.
    private boolean compare_guess_to_target(String guess, String target)
    {
        int guess_counter = 0;
        int target_counter = 0;
        for (int i=0; i<guess.length(); i++)
            for (int j=0; j<guess.length(); j++)
            {
                if (guess.charAt(i) == target.charAt(j))
                    // valid targets check.
                    if (i==j)
                        target_counter++;
                        // valid guesses check.
                    else guess_counter++;
            }
        if (target_counter == target.length())
        {
            System.out.println("BULLSEYE! -- you got it all correct!");
            System.out.println("Number of guesses: "+this.number_of_guesses+"\n");
            return true;
        }
        else
        {
            this.guess_history += "Number of good guesses: "+guess_counter+"; Number of good targets: "+target_counter+"\n";
            System.out.println(this.guess_history);
            return false;
        }
    }
}