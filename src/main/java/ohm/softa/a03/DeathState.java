package ohm.softa.a03;

public class DeathState extends State {

    protected DeathState(int duration) {
        super(duration);
    }

    @Override
    State successor(Cat cat) {
        logger.info("Im dead sorry");
        return this;
    }
}
