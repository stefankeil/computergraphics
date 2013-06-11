uniform sampler2D texture1;

varying vec4 color;
varying vec3 normal;
varying vec3 vertex;
vec3 licht = vec3(1,0,0);
void main (void) { 
	vec4 colour1 = texture2D(texture1, gl_TexCoord[0].st);
	float h= dot(normalize(normal),normalize(licht-vertex));
	gl_FragColor = max(0.0,h)*colour1;
	
	
}