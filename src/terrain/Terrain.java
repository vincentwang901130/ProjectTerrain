package terrain;

 
//import org.lwjgl.input.Keyboard;

//import org.lwjgl.input.Keyboard;

import models.RawModel;
import render.Loader;
import textures.ModelTexture;
import toolbox.Noise;
 
public class Terrain {
	
	private float p=0.2f;
    private static final float SIZE = 256;
    private static final int VERTEX_COUNT = 128;
    private float x;
    private float z;
    private RawModel model;
    private ModelTexture texture;
//    public int TerrainChange(){
//    	if(Keyboard.isKeyDown(Keyboard.KEY_O)){
//			p+=0.1f;
//			  return 1;
//		}
//		if(Keyboard.isKeyDown(Keyboard.KEY_P)){
//			p-=0.1f;
//			  return 1;
//		}
//  return 0;
//    }
//   
    public Terrain(int gridX, int gridZ, Loader loader, ModelTexture texture){
        this.texture = texture;
        this.x = gridX * SIZE;
        this.z = gridZ * SIZE;
        this.model = generateTerrain(loader);
    }
     
     
    public float getX() {
        return x;
    }
 
 
    public float getZ() {
        return z;
    }

 
    public RawModel getModel() {
        return model;
    }
 
 
    public ModelTexture getTexture() {
        return texture;
    }
    
 
    private RawModel generateTerrain(Loader loader){
        int count = VERTEX_COUNT * VERTEX_COUNT;
        float[] vertices = new float[count * 3];
        float[] normals = new float[count * 3];
        float[] textureCoords = new float[count*2];
        int[] indices = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT*1)];
        int vertexPointer = 0;
        Noise noise=new Noise();
        
        
        for(int i=0;i<VERTEX_COUNT;i++){
            for(int j=0;j<VERTEX_COUNT;j++){
                vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
                vertices[vertexPointer*3+1] =getHeight((float)j,(float)i,noise);
                vertices[vertexPointer*3+2] = (float)i/((float)VERTEX_COUNT - 1) * SIZE;
                normals[vertexPointer*3] = 0;
                normals[vertexPointer*3+1] = 1;
                normals[vertexPointer*3+2] = 0;
                textureCoords[vertexPointer*2] = (float)j/((float)VERTEX_COUNT - 1);
                textureCoords[vertexPointer*2+1] = (float)i/((float)VERTEX_COUNT - 1);
                vertexPointer++;
            }
        }
        int pointer = 0;
        for(int gz=0;gz<VERTEX_COUNT-1;gz++){
            for(int gx=0;gx<VERTEX_COUNT-1;gx++){
                int topLeft = (gz*VERTEX_COUNT)+gx;
                int topRight = topLeft + 1;
                int bottomLeft = ((gz+1)*VERTEX_COUNT)+gx;
                int bottomRight = bottomLeft + 1;
                indices[pointer++] = topLeft;
                indices[pointer++] = bottomLeft;
                indices[pointer++] = topRight;
                indices[pointer++] = topRight;
                indices[pointer++] = bottomLeft;
                indices[pointer++] = bottomRight;
            }
        }
        return loader.loadToVAO(vertices, textureCoords, normals, indices);
    }
    
    private float getHeight(float x, float z, Noise noise){
    	if(x<0||x>VERTEX_COUNT||z<0||z>VERTEX_COUNT){
    		return 0;
    	}
    	float height=100.0f*Noise.PerlinNoise_2D((x + 10000) / 10.0f, (z + 10000) / 10.0f, p);
    	return height;
    }
    
}