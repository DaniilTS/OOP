package music;

public class FolkMusic extends Music {

    private Boolean isNationalFolk;

    public FolkMusic(int duration, Boolean isNationalFolk) {
        super(duration);
        this.isNationalFolk = isNationalFolk;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override
    public String getName() {
        return null;
    }
}
