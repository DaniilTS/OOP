package music;

public class Rock extends Music {
    private Boolean isHardRock;

    public Rock(int duration, Boolean isHardRock) {
        super(duration);
        this.isHardRock = isHardRock;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override
    public String getName(){
        return null;
    }
}
