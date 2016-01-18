//// Example of a dynamic sketch.
//// Creature follows the mouse, while sun moves across the sky.

float x, y;              // Position of creature and sun.
float sunX, sunY;

//// SETUP:  Define screen size, set modes.
void setup()
{
  size( 600, 400 );
  sunX=  width/2;         // Start the sun half-way across the screen.
  sunY=  50;
}

//// DRAW:  sky & sun plus creature
void draw()
{
  scene();
  action();
  show();
  messages();
}

//// SCENE:  sky, sun.
void scene() {
  background( 150, 200, 250 );                    // Blue sky
  fill( 255, 255, 0 );
  ellipse( sunX, sunY, 30, 30 );                   // Yellow sun
}

//// ACTION:  sun moves (then resets to random height)
void action() {
  sunX=  sunX + 1;
  if (sunX > width) {
    sunX=  0;
    sunY=  random( 20, 120 );
  }
}

//// SHOW:  creature follows mouse
void show() {
  fill( 0, 0, 200 );
  rect( mouseX, mouseY, 50, 80 );                 // Blue creature
  ellipse( mouseX+25, mouseY-20, 40, 40 );
}

//// MESSAGES.
void messages() {
  fill(0);
  text( "Example of a dynamic sketch.", width/3, 10 );
  text( "Creature follows the mouse, while sun moves across the sky.", width/3, 20 );
  text( "Click to reset sun.\n  Press 's' key to lower the sun, 'q' to quit.", 10, 100 );
  // Also display the author and file name.
  text( "B.A.Martin / dynamic1.java", 10, height-10 );
}

//// EVENT HANDLERS ////
void mousePressed() {
  sunX=0;
}
void keyPressed() {
  if (key == 'q') {
    exit();
  }
  if (key == 's') {
    sunY=  sunY + 50;
  }
}
