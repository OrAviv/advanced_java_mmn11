public class BullseyeMain
{
    public static void main (String args[])
    {
        Bullseye new_game = new Bullseye();

        String target = new_game.randomize_target();
        String guess = new_game.take_a_guess();
        new_game.number_of_guesses++;
        new_game.guess_history += guess+"\n";
        boolean bullseye = new_game.compare_guess_to_target(guess, target);
        while (true)
        {
            if (bullseye == true)
            {
                System.out.println("Would you like to start a new game? (yes/no)");
                if (new_game.my_scanner.nextLine().equals("yes"))
                {
                    target = new_game.randomize_target();
                    new_game.guess_history = "";
                    new_game.number_of_guesses = 0;
                }
                else return;
            }
            guess = new_game.take_a_guess();
            new_game.guess_history += guess+"\n";
            new_game.number_of_guesses++;
            bullseye = new_game.compare_guess_to_target(guess, target);
        }

    }
}
