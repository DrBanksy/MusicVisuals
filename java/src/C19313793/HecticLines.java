package C19313793;

import processing.core.PApplet;
import processing.core.PConstants;

public class HecticLines {
    float width, height;
    float r;
    int numPoints;
    float thetaInc;
    float lastX, lastY;
    MyDesign m;

    HecticLines(MyDesign m, float width, float height, int numPoints) {
        this.m = m;
        this.width = width;
        this.height = height;
        this.numPoints = numPoints;
        this.lastX = width/2;
        this.lastY = height/2;
        this.thetaInc = PConstants.TWO_PI / (float) numPoints;
        this.r = 1f;
    }

    public void render() {
        for(int i = 0; i < 1000; i++) {
            float c = PApplet.map(i, 0, 300, 0, 255) % 255.0f;
            m.stroke(c, 255, 255, 100);
            float theta = i * (thetaInc + m.lerpedAverage * 0.05f);
            float x = width / 2 + PApplet.sin(theta) * r;
            float y = height / 2 - PApplet.cos(theta) * r;
            r += 0.5f + (m.lerpedAverage*0.05f);
            m.line(lastX, lastY, x*m.lerpedAverage -100, x);
            lastX = x;
            lastY = y;
        }
    }
}
