package fr.lernejo.guessgame;
import java.security.SecureRandom;
import fr.lernejo.guessgame.ComputerPlayer;
import fr.lernejo.guessgame.HumanPlayer;

public class Launcher {
    public static void main(String [] args) {
        final Player player;
        final long numberToGuess;
        final long maxLoop;

        if (args.length > 0 && "-interactive".equals(args[0])) {
            player = new HumanPlayer();
            SecureRandom random = new SecureRandom();
            numberToGuess = random.nextInt(100);
            maxLoop = Long.MAX_VALUE;
            Simulation simulation = new Simulation(player);
            simulation.initialize(numberToGuess);
            simulation.loopUntilPlayerSucceed(maxLoop);
        } else if (args.length > 1 && "-auto".equals(args[0])) {
            player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            numberToGuess = random.nextInt(100);
            maxLoop=1000;
            simulation.initialize(numberToGuess);
            simulation.loopUntilPlayerSucceed(maxLoop);

        } else {
            throw new IllegalArgumentException("Bad parameters");
        }
    }
}
