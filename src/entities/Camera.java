package entities;

import org.lwjgl.input.Keyboard;
//import org.lwjgl.input.Mouse;
//import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private Vector3f position =new Vector3f(150,30,0);
	private float pitch=0;
	private float yaw;
	private float roll;
	
	
	
	
	public Camera(){
		
	}
	
	
	
	public void move(){
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
			position.z-=1.0f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			position.x+=1.0f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			position.x-=1.0f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_X)){
			position.z+=1.0f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			position.y-=1.0f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			position.y+=1.0f;
		}
		//changePitch();
	
	}

	public final Vector3f getPosition() {
		return position;
	}

	public final float getPitch() {
		return pitch;
	}

	public final float getYaw() {
		return yaw;
	}

	public final float getRoll() {
		return roll;
	}
//
//	private void changePitch(){
//		if(Mouse.isButtonDown(1)){
//		float pitchChange=Mouse.getDY()*0.1f;
//			pitch-=pitchChange;
//	}
		
//	}
	
	}



