package ohm.softa.a03;

public class DigestingState extends State {

    protected DigestingState(int duration) {
        super(duration);
    }

    @Override
    State successor(Cat cat) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(cat.getAwake()- cat.getDigest());
    }
}
