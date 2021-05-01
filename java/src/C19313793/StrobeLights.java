package C19313793;

public class StrobeLights implements Shape {
    float numLines;
    float cx, cy;
    float border;
    MyDesign m;
    float colorGap;
    

    public StrobeLights(MyDesign m, float numLines, float height, float width, float border) {
        this.m = m;
        this.numLines = numLines;
        this.cx = width/2;
        this.cy = height/2;
        this.border = border;
    }

    @Override
    public void render() {
         m.strokeWeight(2);
         m.smooth();   
         colorGap = 255 / (float) numLines;
         for(int i = 0; i < numLines; i++) {
            m.stroke((i * colorGap) % 255 , 255, m.alpha - (m.lerpedAverage * 10));
            m.line(border, cy + cy/2, m.width * (m.smoothedAmp * 2.0f), border * i);
            m.line(m.width - border, cy + cy/2, m.width * (m.smoothedAmp * 2.0f), border * i);
            m.fade(); 
                
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    
}
