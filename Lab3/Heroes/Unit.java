package Heroes;

public interface Unit{
    void battleCry();

    int getHp();
    int getArmor();
    double getPower();
    void setPower(double power);

    String getName();
}
