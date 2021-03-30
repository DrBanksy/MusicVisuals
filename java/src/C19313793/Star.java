package C19313793;

public class Star {
    float x, y, radius1, radius2;
    int npoints;
    MyDesign m;

    public Star(MyDesign m, float x, float y, float radius1, float radius2, int npoints) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.npoints = npoints;
        drawStar();
    }
    
    public void drawStar() {
        float angle = m.TWO_PI / npoints;
        float halfAngle = angle / (float)2.0;
        m.colorMode(m.HSB);
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

    
}
