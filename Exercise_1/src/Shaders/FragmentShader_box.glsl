uniform sampler2D texture1;

varying vec4 color;

void main (void) { 
	vec4 colour1 = texture2D(texture1, gl_TexCoord[0].st);
	gl_FragColor = colour1;
}