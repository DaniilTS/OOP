package Heroes;

public interface Unit{
    void battleCry();

    int getHp();
    int getArmor();
    float getPower();
    void setPower(float power);

    String getName();
}
