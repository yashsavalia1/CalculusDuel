package game.bullets;

public class Bullet {

    double y;
    public boolean dead;
    boolean ultimate;

    public Bullet(int initial) {
        y = initial;
        dead = false;
        ultimate = false;
    }

    public void kill() {
        dead = true;
    }

    public void setUltimate() {
        ultimate = true;
    }

}
