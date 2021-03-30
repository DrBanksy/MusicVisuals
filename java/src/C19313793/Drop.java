package C19313793;

import java.util.Random;

import processing.core.PApplet;

public class Drop implements Shape {
    float x,y,z;
    float len, ySpeed;
    float width;
    float height;
    MyDesign mydesign;
    Random ran;
    float thick;

    Drop(MyDesign m, int w, int h) {
        this.mydesign = m;
        this.width = w;
        this.height = h;
        setupDrop();
    }

    private void setupDrop() {
        ran = new Random();
        x = ran.nextInt(((int)width - 1 ) + 1) + 1;
        //starting point for rainfall, max 400 min -200
        y = ran.nextInt((int)height+200) -200; 
        z=ran.nextInt(10) + 1;
        len = PApplet.map(z , 0, 20, 10, 20);
        ySpeed = PApplet.map(z , 0, 20, 4, 10);
    }

    @Override
    public void render() {
        thick = PApplet.map(z, 0, 20, 1, 6);
        mydesign.strokeWeight(thick);
        mydesign.stroke(ran.nextInt(255) + 1, 255, 255);
        mydesign.line(x, y, x, y+len);
    }

    @Override
    public void update() {
        y = y + ySpeed;
        ySpeed = ySpeed + 0.01f; //speed up or slow down rainfall

        if(y > height) {
            y = ran.nextInt(200) + 1;
            ySpeed = PApplet.map(z , 0, 20, 4, 10);
        }
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getThick() {
        return thick;
    }

    public void setThick(float thick) {
        this.thick = thick;
    }

    
    
}
