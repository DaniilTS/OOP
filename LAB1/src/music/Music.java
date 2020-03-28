package music;

abstract public class Music {
    protected int duration;

    public Music(int duration) {
        this.duration = duration;
    }

    public abstract int getDuration();
    public abstract String getName();
}
