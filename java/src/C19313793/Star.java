package C19313793;

import processing.core.PApplet;

public class Star implements Shape {
    float x, y, radius1, radius2;
    int npoints;
    MyDesign m;
    float angle1 = 0;
    float acc = 0; 
    float vel = 0;;


    public Star(MyDesign m, float x, float y, float radius1, float radius2, int npoints) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.npoints = npoints;
    }
    
    @Override
    public void render() {
        float angle = m.TWO_PI / npoints;
        float halfAngle = angle / (float)2.0;
        acc = (float)0.01;
        acc = PApplet.map((float)m.mouseX, (float)0, (float)m.width, (float)-0.01,(float) 0.01);
        m.colorMode(m.HSB);
        m.pushMatrix();
        m.translate(m.width/2, m.height/2 - 50);
        m.rotate(angle1);
        m.beginShape();
        for(float a = 0; a < m.TWO_PI ; a += angle) {
            m.stroke(255);
            m.fill(255, 255, 255);
            float sx = x + m.cos(a) * radius2;
            float sy = y + m.sin(a) * radius2;
            m.vertex(sx, sy);
            sx = x + m.cos(a+halfAngle) * radius1;
            sy = y + m.sin(a+halfAngle) * radius1;
            m.vertex(sx, sy);
        }
        m.endShape();      

    }

    @Override
    public void update() {
        angle1 += vel;
        vel += acc;
        m.popMatrix();
    }

    

    
}
