package C19313793;

import processing.core.PApplet;

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
        m.calculateAverageAmplitude();
        float average = m.getAmplitude();
        float cc = PApplet.map(average, 0, 1, 0, 255);
        // TODO Auto-generated method stub
        m.stroke(cc, 255, 255);
        m.noFill();
        m.strokeWeight(2);
        m.rect(x, y, size * 4, size);
    }

    @Override
    public void update() {

    }



    
}
