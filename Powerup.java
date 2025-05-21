import greenfoot.*;

public class Powerup extends Actor {
    
    public final int zoomFactor = 10;
    public final int speed = 3;
    
    public Powerup() {
        
        GreenfootImage image = new GreenfootImage("Powerup.png");
        image.scale(image.getWidth() / zoomFactor, image.getHeight() / zoomFactor);
        this.setImage(image);
    }
    
    public void act() {
        
        int posX = this.getX();
        int posY = this.getY();
        
        posY += speed;
        
        this.setLocation(posX, posY);
        
        int height = ((MyWorld) this.getWorld()).height;
        if (posY >= height - 1) {
            this.getWorld().removeObject(this);
        }
    }
}
