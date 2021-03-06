//// Example of a dynamic sketch.
//// Creature follows the mouse, while sun moves across the sky.

float x,y;              // Position of creature and sun.
float sunX, sunY;

//// SETUP:  Define screen size, set modes.
void setup()
{
            size( 600, 400 );

            // RESET:  // Start the sun half-way across the screen.
            sunX=  width/2;
            sunY=  50;
}

//// DRAW:  sky & sun plus creature
void draw()
{
            // SCENE:  sky, sun, house.
            background( 150, 200, 250 );                    // Blue sky
            fill( 255, 255, 0 );
            ellipse( sunX, sunY, 30,30 );                   // Yellow sun
            fill( 255, 0, 0 );
            rect( 100,100, 100,50 );                        // Red house
            triangle( 100,100, 200,100, 150,50 );
            
            // ACTION:  sun crosses sky, reset to left side.
            if (sunX > width) {
                        sunX=  0;
            }
            sunX=  sunX + 1;

            // SHOW:  creature follows mouse
            fill( 0,0,200 );
            rect( mouseX, mouseY, 50, 80 );                 // Blue creature
            ellipse( mouseX+25, mouseY-20, 40,40 );
            
            // MESSAGES.
            fill(0);
            text( "Example of a dynamic sketch.", width/3, 10 );
            text( "Creature follows the mouse, while sun moves across the sky.", width/3, 20 );
            // Also display the author and file name.
            text( "B.A.Martin / dynamic1.java", 10, height-10 );
}

