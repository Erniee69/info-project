import greenfoot.*;

public class MyWorld extends World {
    
    public MyWorld() {    
        super(600, 400, 1);
        Starship starship = new Starship();
        this.addObject(starship, 300, 370);
    }
}
