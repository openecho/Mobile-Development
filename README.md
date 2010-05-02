# Mobile Development
This repository contains a variety of simple mobile development applications. This started as the [Mobile Development Challenge](http://thechaw.com/mobile_developer_challenge/wiki/home/Challenge_List) but lost momentum and has been stale for some time.

My plan is,

1. Port the Android app examples to Android 2.1
2. Come up with some new and interesting challenges
3. Inspire people to pick up the development for other platforms (yes you [@predominant](http://github.com/predominant))

# The Original Challenges

## Challenge Index
	01 - Hello World
	02 - Hello Image
	03 - Hello Image World
	04 - Hello You
	05 - Show Us Your Balls
	06 - Moving Balls
	07 - Bouncey Balls
	08 - Indecisive Balls
	09 - Reverse Balls
	10 - Lossy Balls
	11 - Noisy Balls
	12 - Touch My Balls

	15 - Icon Assignment

	20 - Flick my Balls

### 01 - Hello World
Display the text "Hello World" on the screen.

### 02 - Hello Image
Display the supplied image [Robot Porn](http://github.com/openecho/Mobile-Development/blob/master/Android/02_Hello_Image/res/drawable/helloimage.png) on the screen.
Preferably centered, and fit to screen, but not required.

### 03 - Hello Image World
Display the supplied image [Robot Porn](http://github.com/openecho/Mobile-Development/blob/master/Android/02_Hello_Image/res/drawable/helloimage.png) on the screen, with "Hello World" overlaid over the image.
Preferably, the image is centred and fit to screen.
Coloring of the text to make it stand out would be tops too.

### 04 - Hello You
Display an Input and a button. Allow the user to enter their name into the input, and on pressing the button, they will be presented with the text "Hello &lt;name&gt;" on the screen.

### 05 - Show Us Your Balls
Display a circular object on the screen

### 06 - Moving Balls
Display a circular object on the screen, moving in some manner

### 07 - Check My Balls
Display a moving circular object on the screen that moves at a runtime random direction.
On collision with the screen boundary, this object should bounce and continue moving after having lost speed to emulate inelastic collisions.
"Energy" is transferred from this collision to the background color by changing it somehow (lighter, darker, etc.).
The ball will eventually come to a stop.

A start/stop button will show "stop" when the ball is moving. Once pressed it will stop the ball, and the button will read "start".
Starting will enable the ball to continue on its previous course at its previous speed.
If the ball comes to a natural stop, the button should change to "start" and clicking start will start the ball off again on the previous vector.

A "reverse" button will cause the ball to reverse its direction, retaining speed.

### 08 - Noisy Balls
This challenge builds on 10 but should add the following additions/changes:
Sound is to be added to the challenge. A single sound sample is to be used and each time a wall is hit with the ball the sample should play. If the ball happens to hit two walls at exactly the same time (in the corner) only one sample should play.

### 09 - Multi Ball
Three balls are randomly placed within the view area. They start moving at random speeds in random vectors.
Retaining the sound for all collisions, and loss of speed.

### 10 - Touch my Balls
This challenge builds on 08 (Single Ball) but should add the following additions/changes:
In this challenge the start/stop and reverse buttons can be removed from the application.
The application should start with a bouncing ball.
When a user presses the screen the ball motion should stop.
When the user presses the screen again it starts with the ball going in a random direction at full speed.

Touching the screen where the ball is not present will have no effect.

### 11 - Flick my Balls
Touches to the screen must be handled.
If the user touches the screen where the ball is then it will instantly come to a stop under their finger.
If they move their finger around then the ball will follow it.
As soon as they lift their finger the ball will continue to move.
The direction is taken from the last movement of the users finger from the touch.

