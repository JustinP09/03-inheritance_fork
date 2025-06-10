package ohm.softa.a03;

public class HungryState extends State {

    protected HungryState(int duration) {
        super(duration);
    }
    @Override
    State successor(Cat cat) {
        logger.info("I've starved for a too long time...good bye...");
        return new DeathState(Integer.MAX_VALUE);
    }

    State feed(Cat cat) {
        if (!cat.isHungry())
            throw new IllegalStateException("Can't stuff a cat...");

        logger.info("You feed the cat...");
        return new DigestingState(cat.getDigest());
    }
}
