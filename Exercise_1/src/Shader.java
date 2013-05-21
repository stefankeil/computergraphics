import static org.lwjgl.opengl.GL20.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Shader {
	public int id;

	public Shader(String vertexResourceName, String fragmentResourceName) {
		int vertexShader = compileFromSource(createInputStreamFromResourceName(vertexResourceName), GL_VERTEX_SHADER);
		System.err.println(glGetShaderInfoLog(vertexShader, 4096));
		int fragmentShader = compileFromSource(createInputStreamFromResourceName(fragmentResourceName), GL_FRAGMENT_SHADER);
		System.err.println(glGetShaderInfoLog(fragmentShader, 4096));

		id = glCreateProgram();
		glAttachShader(id, vertexShader);
		glAttachShader(id, fragmentShader);

		glLinkProgram(id);
		if (glGetProgrami(id, GL_LINK_STATUS) != 1) {
			System.err.println(glGetProgramInfoLog(id, 4096));
		}
	}

	private InputStream createInputStreamFromResourceName(String resourceName) {
		return getClass().getResourceAsStream("/Shaders/" + resourceName);
	}

	private int compileFromSource(InputStream sourceStream, int type) {
	    BufferedReader in = new BufferedReader(new InputStreamReader(sourceStream));
		String source="";
		try {
			String line;
			while ((line= in.readLine()) != null){
				source += line + "\n";
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int shader = glCreateShader(type);
		glShaderSource(shader, source);
		glCompileShader(shader);
		return shader;
		}
}
