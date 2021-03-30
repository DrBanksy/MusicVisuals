package C19313793;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.*;

public class MyDesign extends Visual{
    
    AudioPlayer ap;
    private int which = 0;
    Drop d;
    Drop[] rainfall = new Drop[150];
    float lerpedAverage = 0;


    public void settings()
	{
		// size(512, 512);
        fullScreen(P3D, 1);
	}

    public void keyPressed() {
        ap = getAudioPlayer();
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
        switch(which) {
            case 0 : {
                for(int i = 0; i < rainfall.length; i++) {
                    rainfall[i].update();
                    rainfall[i].render();
                }
                
            }
            
        }
    }

    public void setup() 
	{
        colorMode(HSB);
        startMinim();
        loadAudio("skyfire.mp3");
        for(int i = 0; i < rainfall.length; i++) {
            rainfall[i] = new Drop(this, this.width, this.height);
        }
	}
}
