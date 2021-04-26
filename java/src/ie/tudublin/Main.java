package ie.tudublin;

import C19313793.MyDesign;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyDesign());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}