package music;

public class HardRock extends Rock {
    private String name;

    public HardRock(int duration, Boolean isHardRock, String name) {
        super(duration, isHardRock);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return "HardRock{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
