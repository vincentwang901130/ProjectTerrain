package entities;

import models.TextureModel;

import org.lwjgl.util.vector.Vector3f;

public class Entity {
		private TextureModel model;
		private Vector3f position;
		private float rotX, rotY, rotZ;
		private float scale;
		
		public Entity(TextureModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale)
		{
			this.model=model;
			this.position=position;
			this.rotX=rotX;
			this.rotY=rotY;
			this.rotZ=rotZ;
			this.scale=scale;
			
		}
		
		public void increasePosition(float dx, float dy, float dz)
		{
			this.position.x+=dx;
			this.position.y+=dy;
			this.position.z+=dz;
			
		}	
		
		public void increaseRotation(float dx, float dy, float dz){
			this.rotX +=dx;
			this.rotY +=dy;
			this.rotZ +=dz;
		}
		public final TextureModel getModel() {
			return model;
		}
		public final void setModel(TextureModel model) {
			this.model = model;
		}
		public final Vector3f getPosition() {
			return position;
		}
		public final void setPosition(Vector3f position) {
			this.position = position;
		}
		public final float getRotX() {
			return rotX;
		}
		public final void setRotX(float rotX) {
			this.rotX = rotX;
		}
		public final float getRotY() {
			return rotY;
		}
		public final void setRotY(float rotY) {
			this.rotY = rotY;
		}
		public final float getRotZ() {
			return rotZ;
		}
		public final void setRotZ(float rotZ) {
			this.rotZ = rotZ;
		}
		public final float getScale() {
			return scale;
		}
		public final void setScale(float scale) {
			this.scale = scale;
		}
		
		
}
