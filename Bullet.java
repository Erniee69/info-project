import greenfoot.*;

public class Bullet extends Actor {

    private final int zoomFactor = 20;
    private final int speed = 4;

    public Bullet() {

        GreenfootImage image = new GreenfootImage("BulletTexture.png");
        image.scale(image.getWidth() / zoomFactor, image.getHeight() / zoomFactor);
        this.setImage(image);
    }

    public void act() {

        int posX = this.getX();
        int posY = this.getY();

        if (posY <= 0) {

            this.getWorld().removeObject(this);
            return;
        }

        posY -= speed;

        this.setLocation(posX, posY);
    }
}
