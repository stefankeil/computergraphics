import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public abstract class simple_setup {
	float rotation = 0;
	long lastFrame;

	
	simple_setup(){
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initOpenGL();
		
	}
	
	public void run(){
		getDelta();
		while (!Display.isCloseRequested()){
			render();
			int delta = getDelta();
			update(delta);

			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	//@return milliseconds passed since last frame
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
		}
	// returns miliseconds
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
		}
	
	public void update(int delta){
		rotation += 0.01f * delta;
	}


protected abstract void initOpenGL();

protected abstract void render();
}