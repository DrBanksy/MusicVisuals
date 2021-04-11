package C19313793;

import processing.core.PApplet;

public class Rect implements Shape {
    float x, y;
    MyDesign m;

    public Rect(MyDesign m, float x, float y) {
        this.x = x;
        this.y = y;
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
        m.rect(x, y, (50 + (m.lerpedAverage * 500)) * 4, (50 + (m.lerpedAverage * 500)));
    }

    @Override
    public void update() {

    }



    
}
