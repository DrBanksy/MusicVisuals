package C19313793;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PConstants;

public class CircleOfCircles implements Shape {
    float x, y;
    float depth;
    MyDesign m;
    float angle = 0;
    Random ran;


    CircleOfCircles(MyDesign mydesign, float x, float y, float depth) {
        this.m = mydesign;
        this.y = y;
        this.x = x;
        this.depth = depth;
    }


    @Override
    public void render(){
        depth = m.lerpedAverage * 300;
        m.translate(m.width/2, m.height/2);
        for(float r = 0 ; r < m.mouseX; r+=depth) {
            float c = 2*PConstants.PI*r; 
            float aSegment = PApplet.floor(c/depth);
            for(float i = 0; i < 360; i+=360/aSegment) {
                m.pushMatrix();
                m.rotate(PApplet.radians(i));
                m.ellipse(r, 0, depth, depth);
                m.popMatrix();
            }
        }
    }

    @Override
    public void update(){

    }
    
}
