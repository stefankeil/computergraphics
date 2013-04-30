import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;
import java.util.Random;

public class setup extends simple_setup {
	int counter=0;
	float oldPos = 0;
	public static void main(String[] args) {
		new setup().run();

	}
	
	public float rndPosition(){
		counter++;
		if (counter<75){
			return oldPos;
		}else{
			counter = 0;
			oldPos=(float)Math.random();
			
			return oldPos;
		}
	}
	
	public float randomColor(){
		Random randomgenerator = new Random();
		float value = randomgenerator.nextFloat();
		return value;
	}

	@Override
	protected void initOpenGL() {
		glMatrixMode(GL_PROJECTION);
		
		glLoadIdentity();
		glFrustum(-1, 1, -1, 1, 1, 100);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		glEnable(GL_BLEND);
        // BlendFunc setzen
        glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);

		glShadeModel(GL_FLAT);
		glClear(GL_COLOR_BUFFER_BIT);
	}

	@Override
	protected void render() {
		
		glClear(GL_DEPTH_BUFFER_BIT);
		glBegin(GL_QUADS);
		glColor4f(0,0,0,0.06f);
		glVertex3i(-100, -100, -99);
		glVertex3i(-100, 100, -99);
		glVertex3i(100,100, -99);
		glVertex3i(100, -100, -99);
		glEnd();
		
		glPushMatrix();
		glTranslatef(0, 0, -80f);
		glRotatef(rotation, 0.5f, 1f, 0.5f);
		glTranslatef(randomColor()*50,randomColor()*30, 0);
		
		glBegin(GL_QUADS);
		
		glColor3f(randomColor(),randomColor(),randomColor());
		// RŸckseite
		glVertex3i(-10, -10, 1);
		glVertex3i(-10, 10, 1);
		glVertex3i(10, 10, 1);
		glVertex3i(10, -10, 1);
		
		// Vorderseite
		glColor3f(randomColor(),randomColor(),randomColor());

		glVertex3i(-10, -10, 10);
		glVertex3i(-10, 10, 10);
		glVertex3i(10, 10, 10);
		glVertex3i(10, -10, 10);

		// Seite Links
		glColor3f(randomColor(),randomColor(),randomColor());

		glVertex3i(-10, -10, -10);
		glVertex3i(-10, 10, -10);
		glVertex3i(-10, 10, 10);
		glVertex3i(-10, -10, 10);

		// Seite rechts
		glColor3f(randomColor(),randomColor(),randomColor());

		glVertex3i(10, -10, -10);
		glVertex3i(10, 10, -10);
		glVertex3i(10, 10, 10);
		glVertex3i(10, -10, 10);

		// oben
		glColor3f(randomColor(),randomColor(),randomColor());

		glVertex3i(-10, 10, 10);
		glVertex3i(-10, 10, -10);
		glVertex3i(10, 10, -10);
		glVertex3i(10, 10, 10);

		// unten
		glColor3f(randomColor(),randomColor(),randomColor());

		glVertex3i(-10, -10, 10);
		glVertex3i(-10, -10, -10);
		glVertex3i(10, -10, -10);
		glVertex3i(10, -10, 10);
		
		glEnd();
		glPopMatrix();
		
	}

}
