package fr.lernejo.guessgame;

    import java.util.Scanner;

    import fr.lernejo.logger.Logger;
    import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner= new Scanner(System.in);


    @Override
    public long askNextGuess() {

        do {
            logger.log("Please input a number");
            String guessText = scanner.nextLine();
            try {
                long guess = Long.parseLong(guessText);
                return guess;
            }catch(NumberFormatException e){
                logger.log("Not a number");
            }
        }while(true);
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log("Input number was " + (lowerOrGreater ? "lower" : "greater"));
    }
}
