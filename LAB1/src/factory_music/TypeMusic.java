package factory_music;

public enum TypeMusic {
    OBJ_LIGHT_ROCK("LightRock"),
    OBJ_HARD_ROCK("HardRock"),
    OBJ_NATIONAL_FOLK("NationalFolk"),
    OBJ_POP_FOLK("PopFolk");

    private String name;

    private TypeMusic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
