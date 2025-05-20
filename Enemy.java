import greenfoot.*;  

public class Enemy extends Actor {
    
    public static final int zoomFactor = 10;

    public Enemy() {

        GreenfootImage image = new GreenfootImage("EnemyTexture.png");
        image.scale(image.getWidth() / zoomFactor, image.getHeight() / zoomFactor);
        this.setImage(image);
    }

    public void act() {
        if (this.isTouching(Bullet.class)) {
            Bullet bullet = (Bullet) this.getOneIntersectingObject(Bullet.class);
            this.getWorld().removeObject(bullet);
            this.getWorld().removeObject(this);
        }
    }
}
