package C19313793;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PConstants;

public class WaveForm {
    float height, width;
    MyDesign m;
    float w;

    public WaveForm(float height, float width, MyDesign m) {
        this.height = height;
        this.width = width;
        this.m = m;
    }

    public void render() {
        m.stroke(255);
        m.fft.window(FFT.HAMMING);
        m.fft.forward(m.ab);
        w = width/(float) m.getBands().length;
        m.pushMatrix();
        m.translate(width/2, height/2);
        m.rotateX(PConstants.PI/3);
        m.translate(-width/2, -height/2);

        for(int i = 0 ; i < m.getBands().length ; i ++)
        {
            float colorGap = 255 / (float) 10;
            m.fill((i * colorGap) % 255 , 255, m.alpha - (m.lerpedAverage * 5));
            m.fade();
            float x = PApplet.map(i, -1, m.getBands().length, 0, width);
            m.noStroke();
            m.rect(x, height, w*0.5f, m.getSmoothedBands()[i]*5);
        }    
        m.popMatrix();
    }


    
}
