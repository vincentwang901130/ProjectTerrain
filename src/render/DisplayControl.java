package render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayControl {
	
	private static final int WIDTH=1024;
	private static final int HEIGHT=512;
	private static final int FPS_CAP=120;
	
	public static void createDisplay(){
		ContextAttribs attribs=new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try{
		Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
		Display.create(new PixelFormat(), attribs);
		Display.setTitle("Terrain-PerlinNoise");
		}
		catch(LWJGLException e){
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	public static void updateDisplay(){
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void stopDisplay(){
		Display.destroy();
	}
}
