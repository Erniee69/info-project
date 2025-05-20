import greenfoot.*;

public class EnemyBullet extends Actor {

    private final int zoomFactor = 20;
    private final int speed = 4;

    public EnemyBullet() {
        
        GreenfootImage image = new GreenfootImage("BulletTexture.png");
        image.scale(image.getWidth() / zoomFactor, image.getHeight() / zoomFactor);
        image.mirrorVertically();
        this.setImage(image);
    }

    public void act() {

        int posX = this.getX();
        int posY = this.getY();

        if (posY >= MyWorld.height - 1) {

            this.getWorld().removeObject(this);
            return;
        }
        
        posY += speed;
        
        this.setLocation(posX, posY);
    }
}
