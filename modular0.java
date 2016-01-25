//// Dynamic sketch - modularized.
//// Creature follows the mouse, while sun moves across the sky.

float sunX, sunY;        // Position of sun
float x, y;              // Position and speed of creature.
float dx, dy;


//// SETUP:  Define screen size, set modes.
void setup()
{
  size( 600, 400 );
  reset();
}
void reset() {
  sunX=  width/2;         // Start the sun half-way across the screen.
  sunY=  50;
  x=  width/2;            // Start creature in center.
  y=  height/2;
  dx=  random( 2,5 );     // Random speed.
  dy=  random( -2, +2 );
}


//// DRAW:  sky & sun plus creature
void draw()
{
  scene();
  action();
  show();
  messages();            // (Display the messages last.)
}


//// SCENE:  sky, sun, house.
void scene() {
  background( 150, 200, 250 );          // Blue sky
  fill( 255, 255, 0 );
  ellipse( sunX, sunY, 30, 30 );        // Yellow sun
  fill( 255, 0, 0 );
  rect( 100,100, 100,50 );              // Red house
  triangle( 100,100, 200,100, 150,50 );
}

//// MESSAGES.
void messages() {
  fill(0);
  text( "Dynamic sketch -- modularized.", width/3, 10 );
  text( "Creature follows the mouse, while sun moves across the sky.", width/3, 20 );
  text( "Click to reset creature.\n  Press 's' key to lower the sun, 'q' to quit.", 10, height/2 );
  // Also display the author and file name.
  text( "B.A.Martin / modular0.java", 10, height-10 );
}

//// ACTION:  sun moves (then resets to random height)
void action() {
  if (sunX > width) {
    sunX=  0;
    sunY=  random( 20, 120 );
  }
  sunX=  sunX + 1;
  // Move the creature.
  x=  x + dx;
  y=  y + dy;
}

//// SHOW:  creature follows mouse
void show() {
  // Draw creature.
  fill( 0, 0, 200 );
  rect( x,y, 50, 80 );                 // Blue creature
  ellipse( x+25, y-20, 40, 40 );       // Head on top
  // Eyes.
  fill( 255 );
  ellipse( x+15, y-25, 12, 12 );
  ellipse( x+35, y-25, 12, 12 );
  fill( 0, 150, 0 );
  ellipse( x+15, y-25, 4, 4 );
  ellipse( x+35, y-25, 4, 4 );
}


//// EVENT HANDLERS ////
void mousePressed() {
  reset();
  // Set the position (x,y)
  x=  mouseX;
  y=  mouseY;
}
void keyPressed() {
  if (key == 'q') {
    exit();
  }
  if (key == 'r') {
    reset();
  }
  if (key == 's') {
    sunY=  sunY + 50;
  }
}
