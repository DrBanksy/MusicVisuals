package C19313793;

public class NestedRect extends Rect {

    public NestedRect(MyDesign m, float x, float y, float size) {
        super(m, x, y, size);
        
    }

    @Override
    public void render() {
        super.render();
        m.rect(x, y, size * 3, 2 - + (size-50));
    }
    
}
