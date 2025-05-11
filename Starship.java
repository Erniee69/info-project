import greenfoot.*;

public class Starship extends Actor {
    
    private final int speed = 2;
    private final int zoomFactor = 10;
    
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
        
        posX = Math.min(posX, 570);
        posX = Math.max(30, posX);
        
        this.setLocation(posX, posY);
    }
}
