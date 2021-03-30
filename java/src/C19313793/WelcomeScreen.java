package C19313793;

public class WelcomeScreen {
    private MyDesign m;
    private float s = 100 + (100 * 10 * 10);
    private float angle = 0;

    WelcomeScreen(MyDesign mydesign) {
        this.m = mydesign;
        setup();
    }

    private void setup() {
        m.background(0);
        m.println(m.width/2);
        m.textAlign(m.CENTER, m.CENTER);
        m.fill(255);
        m.text("1) Press space bar to start/stop music", m.width/2, m.height/2 + 50);
        m.text("2) Use 0-9 on the keyboard to see some cool stuff :)", m.width/2, m.height/2 + 90);

    }

    void drawBox() {
        m.translate(m.width/2, m.height/2);
        m.rotate(m.radians(angle));
        m.rect(0, 0, 600, 600);
        angle++;

        
    }


    

    
}
