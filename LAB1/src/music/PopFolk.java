package music;

public class PopFolk extends FolkMusic {
    private String name;

    public PopFolk(int duration, Boolean isNationalFolk, String name) {
        super(duration, isNationalFolk);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "PopFolk{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
