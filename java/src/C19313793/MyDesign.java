package C19313793;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.*;
import processing.core.PFont;

public class MyDesign extends Visual{
    
    AudioPlayer ap;
    AudioBuffer ab;
    private int which = 0;
    Drop d;
    Drop[] rainfall = new Drop[250];
    float lerpedAverage = 0;
    float[] lerpedBuffer;
    CircleOfCircles circles;
    PFont font;
    WelcomeScreen menu;
    float angle;
    float acc;
    float vel;
    float cx;
    float cy;
    int scl = 20;
    int cols, rows;
    int w, h;
    float[][] landscape;
    float move;

    

    int alpha;
    int delta;

    public void settings()
	{
		// size(600, 600, P3D);
        fullScreen(P3D, 1);
	}

    public void keyPressed() {
        
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void draw() {
        background(0);
        float halfHeight = height / 2;
        calculateAverageAmplitude();
        float c = map(getAmplitude(), 0, 1, 0, 255);
        lerpedAverage = lerp(lerpedAverage, getAmplitude() , 0.1f);
    
        switch(which) {
            case 0 : {
                WelcomeScreen welcome = new WelcomeScreen(this);
                acc = (float)0.01;
                acc = map((float)mouseX, (float)0, (float)width, (float)-0.01,(float) 0.01);
                noStroke();
                fill(240, 99, 164);
                rectMode(CENTER);
                pushMatrix();
                translate(width/2, height/2 - 50);
                rotate(angle);
                // rect(0, 0, 130, 60);
                Star star = new Star(this, 0, 0, 30, 70, 5);
                angle += vel;
                vel += acc;
                popMatrix();
                break;


                // translate(width/2, height/2);
                // rotate(radians(angle));
                // rect(0, -400, 200, 200);
                // angle++;
                // break;
            }
            case 1 : {
                fill(255);
                text("C19313793", width/2, height -20);
                noFill();
                stroke(120);
                // float wave = sin(radians(frameCount));
                // ellipse(width/2 + wave * (lerpedAverage * 500), height/2, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
                for(int i = 0; i < rainfall.length; i++) {
                    rainfall[i].update();
                    rainfall[i].render();
                }
                stroke(c, 255, 255); 
                circles = new CircleOfCircles(this, 200, 200, lerpedAverage*300);
                break;
            }

            //strobe lights
            case 2: {
                // calculateAverageAmplitude();
                float smoothedAmp = getSmoothedAmplitude();
                float numLines = 10;
                float w = width / numLines;
                float colorGap = 255 / (float) numLines;
                float border = width * 0.05f;
                colorMode(HSB);
                strokeWeight(3);
                smooth();
                for(int i = 0; i < numLines; i++) {
                    println(lerpedAverage);
                    stroke((i * colorGap) % 255 , 255, alpha - (lerpedAverage * 10));
                    line(border, cy + cy/2, width * (smoothedAmp * 2.0f), border * i);
                    line(width - border, cy + cy/2, width * (smoothedAmp * 2.0f), border * i);
                    twinkle(); 
                        
                }
                break;

            }

            // terrain visual
            case 3 :{
                stroke(255);
                noFill();
                // calculateAverageAmplitude();
                float average = getAmplitude();
                float cc = map(average, 0, 1, 0, 255);
                translate(width/2, height/2);
                rotateX(PI/3);
                translate(-width/2, -height/2);
                fill(cc, 255, 255);
                for(int y = 0; y< rows-1; y++) {
                    beginShape(TRIANGLE_STRIP);

                    for(int x = 0; x < cols; x++) {
                        //draw the vertices
                        vertex(x*scl, y*scl,landscape[x][y]);
                        vertex(x*scl, (y+1)*scl, landscape[x][y+1]);
                    }
                    endShape();
                }

                //adjust speed of the wave
                move+= lerpedAverage * (mouseX *0.0001f);
                float y_offset = move;
                for(int y = 0; y< rows; y++) {
                    float x_offset =0;
                    for(int x = 0; x < cols; x++) {
                        //last two parameters alter the pull amount of the vertice
                        landscape[x][y] = map(noise(x_offset, y_offset), 0, 1, -lerpedAverage*1000, lerpedAverage*1000);
                        //change the offsets to mess around with the visual
                        x_offset += 0.2; 
                    }
                    y_offset += 0.02;
                }

                stroke(cc, 255, 255);        
                strokeWeight(2);
                noFill();
                rectMode(CENTER);
                
                break;

            }

            // cool rectangles
            // demonstrates polymorphism and inheritance
            case 4 : {

                calculateAverageAmplitude();
                float average = getAmplitude();
                float cc = map(average, 0, 1, 0, 255);
                stroke(cc, 255, 255);
                noFill();
                strokeWeight(2);
                Rect rect = new NestedRect(this, width/2, height/2, 50 + (lerpedAverage * 500));
                rect.render();
            }
            
        }
    }

    public void setup() 
	{
        colorMode(HSB);
        setFrameSize(512);
        font = createFont("customFont.ttf", 24);
        textFont(font);
        startMinim();
        loadAudio("skyfire.mp3");
        ap = getAudioPlayer();
        rectMode(CENTER);
        acc =0;
        vel = 0;
        angle = 0;
        alpha = 1;
        delta =1;
        cx = width / 2;
        cy = height / 2;  
        w = width;
        h = height;
        cols = w/scl;
        rows = h/scl;
        landscape = new float[cols][rows];
        
        
        
        
        for(int i = 0; i < rainfall.length; i++) {
            rainfall[i] = new Drop(this, this.width, this.height);
        }
        lerpedBuffer = new float[width];
	}

    void twinkle() {
        //fade in and out
       if (alpha == 0 || alpha == 255) {
          delta= -delta;
        }
        alpha += delta;
    } 

  
}
