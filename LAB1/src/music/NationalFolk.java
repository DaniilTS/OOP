package music;

public class NationalFolk extends FolkMusic {
    private String name;

    public NationalFolk(int duration, Boolean isNationalFolk, String name) {
        super(duration, isNationalFolk);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "NationalFolk{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
