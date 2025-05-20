import greenfoot.*;

public class MyWorld extends World {
    
    public static final int width = 662;
    public static final int height = 450;
    
    public MyWorld() {    
        super(width, height, 1);
        Starship starship = new Starship();
        this.addObject(starship, width / 2, height - 30);
        
        buildEnemyGrid();
    }
    
    public void buildEnemyGrid() {
        
        GreenfootImage enemyTexture = new GreenfootImage("EnemyTexture.png");
        
        int enemyWidth = enemyTexture.getWidth() / Enemy.zoomFactor;
        int enemyHeight = enemyTexture.getHeight() / Enemy.zoomFactor;
        
        int countX = (int) Math.floor((double) width / enemyWidth);
        int countY = (int) Math.floor((double) height / enemyHeight);
        
        int paddingX = (width - countX * enemyWidth);
        int paddingY = (height - countY * enemyHeight);

        countY -= 2; // remove 2 rows of enemys for spaceship space
        
        for (int i = 0; i < countX; i++) {
            for (int j = 0; j < countY; j++) {
                Enemy enemy = new Enemy();
                this.addObject(enemy, paddingX + i * enemyWidth, paddingY + j * enemyHeight);
            }
        }
    }
}
