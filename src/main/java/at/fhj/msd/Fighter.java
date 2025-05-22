package at.fhj.msd;

public interface Fighter {

    public String getName();

    public String getType();

    public int getPower();

    public int getSpeed();

    public int getHp();

    public void takeDamage(int damage);

    public boolean isAlive();

}
