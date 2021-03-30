package C19313793;

import java.util.Random;

import processing.core.PApplet;

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
        render();
    }


    @Override
    public void render(){
        m.translate(m.width/2, m.height/2);
        for(float r = 0 ; r < 400; r+=depth) {
            float c = 2*m.PI*r; 
            float aSegment = m.floor(c/depth);
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
