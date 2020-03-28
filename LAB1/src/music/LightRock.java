package music;

public class LightRock extends Rock {
    private String name;

    public LightRock(int duration, Boolean isHardRock, String name) {
        super(duration, isHardRock);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "LightRock{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
