package C19313793;

import processing.core.PApplet;

public class MusicBars {
    MyDesign m;

    MusicBars(MyDesign m) {
        this.m = m;
    }

    public void render() {
        float average = m.getAmplitude();
        for(int i = 0; i < m.ab.size();i++) {
            float cc = PApplet.map(average, 0, 1, 0, 255);
                m.stroke(cc, 255, 255);
                m.lerpedBuffer[i] = PApplet.lerp(m.lerpedBuffer[i], m.ab.get(i), 0.1f);        
                m.line(i, m.height, m.width,  m.height/2 + m.lerpedBuffer[i] *  m.height/2 * 2);
                // m.line(i + m.width/4, m.height, i + m.width/4,  m.height/2 + m.lerpedBuffer[i] *  m.height/2 * 2);
                m.line(i + m.width - m.width/4, m.height,  -m.width,  -m.height/2 + m.lerpedBuffer[i] *  m.height/2 * 2);
            
        }
    }


    
}
