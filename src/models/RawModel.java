package models;

public class RawModel {
	
	private int vaoID;
	private int vertexCount;
	
	public RawModel(int vaoID,int vertexCount){
		this.vaoID=vaoID;
		this.vertexCount=vertexCount;
	}
	
	public final int getVaoID() {
		return vaoID;
	}
	
	public final void setVaoID(int vaoID) {
		this.vaoID = vaoID;
	}
	
	public final int getVertexCount() {
		return vertexCount;
	}
	
	public final void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}
	
}
