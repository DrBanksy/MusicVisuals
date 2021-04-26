package C19313793;

import processing.core.PConstants;

public class WelcomeScreen {
    private MyDesign m;

    WelcomeScreen(MyDesign mydesign) {
        this.m = mydesign;
    }

    public void setup() {
        m.background(0);
        m.textAlign(PConstants.CENTER, PConstants.CENTER);
        m.fill(255);
        m.text("1) Press space bar to start/stop music", m.width/2, m.height/2 + 50);
        m.text("2) Use 0-9 on the keyboard", m.width/2, m.height/2 + 90);
        m.text("WARNING: Loud headbanger music incoming", m.width/2, m.height/2 + 160);
    }
}
