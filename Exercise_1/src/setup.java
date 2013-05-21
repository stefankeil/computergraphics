import static org.lwjgl.opengl.GL11.*;


import java.util.Random;

public class setup extends simple_setup {
	Texture texture,texture2;

	public static void main(String[] args) {
		new setup().run();
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
        glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		glShadeModel(GL_SMOOTH);
		glClear(GL_COLOR_BUFFER_BIT);
		glEnable(GL_TEXTURE_2D);
		texture = new Texture("/Texture/Paper0029_2_thumblarge.jpg");
		texture2 = new Texture("/Texture/PlywoodNew0041_1_S.jpg");		

	}

	@Override
	protected void render() {
		
		glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MAG_FILTER,GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MIN_FILTER,GL_NEAREST);
		glBindTexture(GL_TEXTURE_2D, texture2.getId());
		
		glPushMatrix();
		
		glClear(GL_DEPTH_BUFFER_BIT);
		
		glBegin(GL_QUADS);
		glColor4f(1,1,1,0.06f);
		glTexCoord2f(0, 0);
		glVertex3i(-100, -100, -99);
		glTexCoord2f(1, 0);
		glVertex3i(-100, 100, -99);
		glTexCoord2f(1, 1);
		glVertex3i(100,100, -99);
		glTexCoord2f(0, 1);
		glVertex3i(100, -100, -99);
		glEnd();
		
		glTranslatef(0, 0, -80f);
		glRotatef(rotation, 0.5f, 1f, 0.5f);
		//glTranslatef(randomColor()*50,randomColor()*30, 0);
		glScalef(2, 2, 2);
		glBindTexture(GL_TEXTURE_2D, texture.getId());
		
		glBegin(GL_QUADS);
		glColor3f(1,1,1);
		// RŸckseite
		glTexCoord2f(0, 0);
		glVertex3i(-10, -10, -10);
		glTexCoord2f(1, 0);
		//glColor3f(1,1,1f);
		glVertex3i(-10, 10, -10);
		glTexCoord2f(1, 1);
		glVertex3i(10, 10, -10);
		glTexCoord2f(0, 1);
		glVertex3i(10, -10, -10);
		
		// Vorderseite
		//glColor3f(0.5f,1,1);
		glTexCoord2f(0, 0);
		glVertex3i(-10, -10, 10);
		glTexCoord2f(1, 0);
		//glColor3f(1,1,1f);
		glVertex3i(-10, 10, 10);
		glTexCoord2f(1, 1);
		glVertex3i(10, 10, 10);
		glTexCoord2f(0, 1);
		glVertex3i(10, -10, 10);

		// Seite Links
		//glColor3f(0.5f,1,1);
		glTexCoord2f(0, 0);
		glVertex3i(-10, -10, -10);
		glTexCoord2f(1, 0);
		//glColor3f(1,1,1f);
		glVertex3i(-10, 10, -10);
		glTexCoord2f(1, 1);
		glVertex3i(-10, 10, 10);
		glTexCoord2f(0, 1);

		glVertex3i(-10, -10, 10);

		// Seite rechts
		//glColor3f(0.5f,1,1);
		glTexCoord2f(0, 0);
		glVertex3i(10, -10, -10);
		glTexCoord2f(1, 0);
		//glColor3f(1,1,1f);
		glVertex3i(10, 10, -10);
		glTexCoord2f(1, 1);
		glVertex3i(10, 10, 10);
		glTexCoord2f(0, 1);
		glVertex3i(10, -10, 10);

		// oben
		//glColor3f(0.5f,1,1);
		glTexCoord2f(0, 0);
		glVertex3i(-10, 10, 10);
		glTexCoord2f(1, 0);
		//glColor3f(1,1,1f);
		glVertex3i(-10, 10, -10);
		glTexCoord2f(1, 1);
		glVertex3i(10, 10, -10);
		glTexCoord2f(0, 1);
		glVertex3i(10, 10, 10);

		// unten
		//glColor3f(0.5f,1,1);
		glTexCoord2f(0, 0);
		glVertex3i(-10, -10, 10);
		glTexCoord2f(1, 0);
		//glColor3f(1,1,1f);
		glVertex3i(-10, -10, -10);
		glTexCoord2f(1, 1);
		glVertex3i(10, -10, -10);
		glTexCoord2f(0, 1);
		glVertex3i(10, -10, 10);
		
		glEnd();
		glPopMatrix();
		
	}

}
