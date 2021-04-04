package C19313793;

public class Rect implements Shape {
    float x, y, size;
    MyDesign m;

    public Rect(MyDesign m, float x, float y, float size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.m = m;
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        m.rect(x, y, size * 4, size);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }



    
}
