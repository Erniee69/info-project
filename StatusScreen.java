import greenfoot.*;

public class StatusScreen extends Actor {
    
    public enum ScreenType {
        GameOver,
        YouWin,
    }
    
    private static GreenfootImage gameOverTexture = new GreenfootImage("GameOverScreen.png");
    private static GreenfootImage youWonTexture = new GreenfootImage("YouWinScreen.png");
    
    private ScreenType screenType;
    
    public StatusScreen(ScreenType p_screenType) {
        
        screenType = p_screenType;
        
        if (screenType == ScreenType.GameOver) {
            this.setImage(gameOverTexture);
        }
        else {
            this.setImage(youWonTexture);
        }
    }
    
    public void act() {}
}