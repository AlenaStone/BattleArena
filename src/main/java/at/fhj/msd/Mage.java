package at.fhj.msd;

public class Mage implements Fighter {

    private String name;
    private String type = "Mage";
    private int power = 10;
    private int speed = 10;
    private int hp = 100;
    private boolean isAlive = true;

    public Mage(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void takeDamage(int damage) {
        hp = hp - damage;
        if (hp <= 0) {
            isAlive = false;
            hp = 0;
        }
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

}
