package test;
import models.RawModel;
import models.TextureModel;
 
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
 
import render.DisplayControl;
import render.Loader;
import render.MasterRenderer;
import render.OBJLoader;
import terrain.Terrain;
import textures.ModelTexture;
import entities.Camera;
//import entities.Entity;
import entities.Light;
 
public class MainLoop {
 
    public static void main(String[] args) {
     
        DisplayControl.createDisplay();
        Loader loader = new Loader();
         
         
       // RawModel model = OBJLoader.loadObjModel("stall", loader);
         
        //TextureModel staticModel = new TextureModel(model, new ModelTexture(loader.loadTexture("stallTexture")));
    //    ModelTexture texture = staticModel.getTexture();
   //     texture.setShineDamper(5);
     //   texture.setReflectivity(1);
         
        //Camera Position
       // Entity entity = new Entity(staticModel, new Vector3f(0,-50,-25),0,0,0,1);
        //Light source position and color.
        Light light = new Light(new Vector3f(100,100,100), new Vector3f(1,1,1));
         
        Terrain terrain = new Terrain(0,-1,loader, new ModelTexture(loader.loadTexture("rock")));
 
        Camera camera = new Camera();
         
        MasterRenderer renderer = new MasterRenderer();
        while(!Display.isCloseRequested()){
            //entity.increasePosition(0, 0, 0);
          //  entity.increaseRotation(0, 0, 0);
            camera.move();
             
            renderer.processTerrain(terrain);
            //renderer.processEntity(entity);
             
            renderer.render(light, camera);
            DisplayControl.updateDisplay();
                 
        }
        renderer.cleanUp();
        loader.cleanUp();
        DisplayControl.stopDisplay();
 
    }
 
}