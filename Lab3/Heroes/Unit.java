package Heroes;

public interface Unit{
    void battleCry();

    double getHp();
    void setHp(double hp);

    double getArmor();
    void setArmor(double armor);
    void setArmor(String name,double armor);

    double getPower();
    void setPower(double power);

    String getName();
    void setName(String name);
}
