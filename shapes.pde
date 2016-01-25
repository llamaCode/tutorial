/ Practice with different shapes and colors.
// B.A.Martin

// SETUP:  size & modes
size( 400, 300 );
smooth();


// DRAW:  shapes and colors
text( "Some lines and shapes", 10,10 );
text( "My name is:  B.A.Martin", 10,height-10 );

point(20,20 );
line(100,20, 200,20 );
line(200,30, 250,50 );

// Rectangles
rect( 50,50, 80,60 );
fill( 255,0,0 );                // Red
rect( 80,80, 60,90 );


// Ellipses
stroke( 0,0,255 );              // Blue border
fill( 255,255,0 );              // Yellow fill
ellipse( 200,100, 90,90 );
fill( 0,255,0 );                // Green
ellipse( 250,150, 90,60 );

// Lines between centers.
stroke( 255,0,255 );
line(50,50, 80,80 );
line(200,100, 250,150 );

// Add your own shapes, here.
