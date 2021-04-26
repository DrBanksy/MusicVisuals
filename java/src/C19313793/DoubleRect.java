package C19313793;

public class DoubleRect extends Rect {

    public DoubleRect(MyDesign m, float x, float y) {
        super(m, x, y);
        
    }

    @Override
    public void render() {
        super.render();
        m.rect(x, y, (50 + (m.lerpedAverage * 500)) * 3, 2 - + ((50 + (m.lerpedAverage * 500))-50));
    }
    
}
