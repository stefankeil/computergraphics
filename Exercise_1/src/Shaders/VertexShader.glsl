varying vec4 color;
void main(void) {
	color = gl_Color; 
	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
	gl_TexCoord[0] = gl_MultiTexCoord0;
}