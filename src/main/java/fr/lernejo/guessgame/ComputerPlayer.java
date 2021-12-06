package fr.lernejo.guessgame;

    import fr.lernejo.logger.Logger;
    import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("player");;
    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;

    private long middle(){
        return (min + max) / 2;
    }
    @Override
    public long askNextGuess() {
        return middle();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            max = middle();
        }else{
            min = middle();
        }
    }
}
