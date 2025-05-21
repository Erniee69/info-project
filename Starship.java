import greenfoot.*;

public class Starship extends Actor {
    
    private final int speed = 2;
    private final int zoomFactor = 10;
    private int bulletDelayCounter = 0;
    private int bulletDelay = 40;
    private int powerupTimeCounter = 0;
    private int powerupTime = 250;
    
    public Starship() {
        
        GreenfootImage image = new GreenfootImage("StarshipTexture.png");
        image.scale(image.getWidth() / zoomFactor, image.getHeight() / zoomFactor);
        this.setImage(image);
    }
    
    public void act() {
        int posX = this.getX();
        int posY = this.getY();
        
        if (Greenfoot.isKeyDown("D")) {
            posX += speed;
        }
        if (Greenfoot.isKeyDown("A")) {
            posX -= speed;
        }
        if (Greenfoot.isKeyDown("space") && bulletDelayCounter == 0) {
            Bullet bullet = new Bullet();
            this.getWorld().addObject(bullet, posX, posY);
            bulletDelayCounter = bulletDelay;
            if (powerupTimeCounter > 0) {
                Bullet bullet2 = new Bullet();
                this.getWorld().addObject(bullet2, posX, posY + 30);
            }
        }
        if (bulletDelayCounter > 0) {
            bulletDelayCounter -= 1;
        }
        if (powerupTimeCounter > 0) {
            powerupTimeCounter -= 1;
        }
        if (this.isTouching(EnemyBullet.class)) {
            ((MyWorld) this.getWorld()).resetWorld();
            Greenfoot.stop();
        }
        if (this.isTouching(Powerup.class)) {
            Powerup powerup = (Powerup) this.getOneIntersectingObject(Powerup.class);
            this.getWorld().removeObject(powerup);
            powerupTimeCounter = powerupTime;
        }
        
        posX = Math.min(posX, ((MyWorld) this.getWorld()).width - 30);
        posX = Math.max(30, posX);
        
        this.setLocation(posX, posY);
    }
}
