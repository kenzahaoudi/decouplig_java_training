package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;//on associe au champ player la variable player
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
        //TODO implement me
    }

    /**
     *
     */
   /* private boolean nextRound() {
        //TODO implement me
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir un nombre : ");
        int numberToGuess = scanner.nextInt();
        if (numberToGuess == 9) {
            return true;
        } else if (numberToGuess < 9) {
            System.out.println("<");
            return false;
        } else {
            System.out.println(">");
            return false;
        }
    }*/
    private boolean nextRound(long guess) {
        /*long guess = player.askNextGuess();*/
        if(guess==numberToGuess) {
            return true;
        } else {
            player.respond(guess < numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxLoop){
        long guess;
        int counter=0;
        long startTime=System.currentTimeMillis();
        do{ guess = player.askNextGuess();
            counter++;
        } while(counter<maxLoop && !nextRound(guess));
        logger.log("well done");

        long endTime=System.currentTimeMillis();
        long duration=(endTime - startTime);

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("mm:ss.SSS");
        Date date= new Date(duration);

        String time = simpleDateFormat.format(date.getTime());
        logger.log(time);
    }
}
