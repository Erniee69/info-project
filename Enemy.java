import greenfoot.*;  

public class Enemy extends Actor {
    
    public static final int zoomFactor = 10;

    public Enemy() {

        GreenfootImage image = new GreenfootImage("EnemyTexture.png");
        image.scale(image.getWidth() / zoomFactor, image.getHeight() / zoomFactor);
        this.setImage(image);
    }

    public void act() {
        
        int num = (int)(Math.random() * 1000);
        if (num == 0) {
            EnemyBullet bullet = new EnemyBullet();
            this.getWorld().addObject(bullet, this.getX(), this.getY());
        }
        
        if (this.isTouching(Bullet.class)) {
            Bullet bullet = (Bullet) this.getOneIntersectingObject(Bullet.class);
            this.getWorld().removeObject(bullet);
            int num2 = (int)(Math.random() * 10);
            if (num2 == 0) {
                Powerup powerup = new Powerup();
                this.getWorld().addObject(powerup, this.getX(), this.getY());
            }
            this.getWorld().removeObject(this);
        }
    }
}
