# Tutorial on the _Processing_ Programming Language.
<img src="http://suffolk.li//cst112/61cst112/students/img/p.jpg" width=64 align=RIGHT hspace=100 >
## Syntax Rules
* Double-slash __//__ begins a *comment*.  (The remainder of the line is ignored by compiler.)
```
            // Always begin with a comment that says what you are trying to do!
```
* Semicolon __;__ must end each statement.  <img src= "http://suffolk.li/img/h.png" hspace=100 ALIGN=RIGHT >
```
            // Draw a red house, with roof.
            fill( 255, 0, 0 );                         // Red house 
            rect( 100,100, 100,50 );
            triangle( 100,100, 200,100, 150,50 );      // Roof
```               
* Each __BLOCK__ of statements should be indented and surrounded by *curly-braces*:
```
            //// SETUP:  Define screen size, set modes.
            {
                        size( 600, 400 );
                        rectMode( CORNER );
                        ellipseMode( CENTER );
            }

            //// DRAW:  sky and sun
            {
                        background( 150, 255, 255 );     // Cyan sky
                        fill( 255, 255, 0 );
                        ellipse( width/2, 50, 30,30 );   // Yellow sun
            }
```
* Variables must be declared.  (Use only the __```float```__ type for now.)
```
            float x=200, y=300;     // Starting position of creature.
            float sunX=50, sunY=50; // Starting position for the sun.
            
            //// ZOOG:  draw a creature at (x,y)

            {
                        fill( 255,0,255 );               // Blue creature
                        rect( x,y, 50,80 );              // Body
                        ellipse( x+25,y-20, 40,40 );     // Head
            }
```      
## For dynamic sketches,      <img src="http://suffolk.li/img/d1zz.png" ALIGN=RIGHT >
  1. put setup code in a ```setup( )``` method _(called once)_, and
  2. code to draw each frame in a ```draw( )``` method _(called repeatedly)_:
```
            //// Example of a dynamic sketch.
            //// Creature follows the mouse, while sun moves across the sky.

            float x,y;                          // Position of creature and sun.
            float sunX, sunY;
            
            //// SETUP:  Define screen size, set modes.
            void setup()
            {
                        size( 600, 400 );
                        sunX=  width/2;                  // Reset the sun position.
                        sunY=  50;
            }

            //// DRAW:  sky, sun, house plus creature
            void draw()
            {
                        // SCENE:
                        background( 150, 255, 255 );        // Cyan sky
                        fill( 255, 255, 0 );
                        ellipse( sunX, sunY, 30,30 );       // Yellow sun
                        // Draw a red house, with roof.
                        fill( 255, 0, 0 );                  // Red house
                        rect( 100,100, 100,50 );
                        triangle( 100,100, 200,100, 150,50 );
                        
                        // ACTION:
                        sunX=  sunX + 1;
                        if (sunX > width) sunX=  0;

                        // SHOW:
                        fill( 0,0,200 );
                        x=  mouseX;
                        y=  mouseY;
                        rect( x, y, 50, 80 );               // Blue body
                        ellipse( x+25, y-20, 40,40 );       // Head
                        fill( 255 );
                        ellipse( x+15,y-25, 12,12 );        // Eyes
                        ellipse( x+35,y-25, 12,12 );
            }
```

#### _Examine and run this code:_
<IMG SRC="http://suffolk.li/img/d1.png" ALIGN=RIGHT>
  [http://raw.githubusercontent.com/61cst112/tutorial/master/dynamic1.java](http://raw.githubusercontent.com/61cst112/tutorial/master/dynamic1.java)  


## Modularize:  
* Organize the code using bite-sized pieces (blocks).
```
            //// DRAW:  Next frame.
            void draw()
            {
                        scene();
                        action();
                        show();
                        messages();
            }
```
#### _Examine this code, then make your own modifications and run it!_  
  [http://raw.githubusercontent.com/61cst112/tutorial/master/dynamic2.java](http://raw.githubusercontent.com/61cst112/tutorial/master/dynamic2.java)

*.../....1..../....2..../....3..../....4..../....5..../....6..../....7..../....8..../....9..../....0..../....1..../....2..../....3..../....3..../....4..../....5..../....6  
            |           |           |           |           |           |           |           |           |           |
