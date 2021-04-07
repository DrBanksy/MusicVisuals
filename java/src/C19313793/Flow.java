package C19313793;

import processing.core.PApplet;
import processing.core.PConstants;

public class Flow implements Shape  {
    int width, height;
    int scl;
    float cc;
    float move;
    MyDesign m;
    public Flow(MyDesign m, int width, int height, int scl) {
        this.scl = scl;
        this.m = m;
        this.width = width;
        this.height = height;

    }

    public void render() {
        m.stroke(255);
        m.noFill();
        float average = m.getAmplitude();
        cc = PApplet.map(average, 0, 1, 0, 255);
        m.translate(m.width/2, m.height/2);
        m.rotateX(PConstants.PI/3);
        m.translate(-m.width/2, -m.height/2);
        m.fill(cc, 255, 255);
        for(int y = 0; y< m.rows-1; y++) {
            m.beginShape(PConstants.TRIANGLE_STRIP);

            for(int x = 0; x < m.cols; x++) {
                //draw the vertices
                m.vertex(x*scl, y*scl,m.landscape[x][y]);
                m.vertex(x*scl, (y+1)*scl,m.landscape[x][y+1]);
            }
            m.endShape();
        }



    }

    public void update() {
        m.move+= m.lerpedAverage * (m.mouseX *0.0001f);
        float y_offset = m.move;
        for(int y = 0; y< m.rows; y++) {
            float x_offset =0;
            for(int x = 0; x < m.cols; x++) {
                //last two parameters alter the pull amount of the vertice
                m.landscape[x][y] = PApplet.map(m.noise(x_offset, y_offset), 0, 1, -m.lerpedAverage*1000, m.lerpedAverage*1000);
                //change the offsets to mess around with the visual
                x_offset += 0.2; 
            }
            y_offset += 0.09;
        }
    }

    
    
}
