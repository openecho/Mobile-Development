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
Display the supplied image "robot_porn.gif" on the screen.
Preferably centered, and fit to screen, but not required.

### 03 - Hello Image World
Display the supplied image "robot_porn.gif" on the screen, with "Hello World" overlaid over the image.
Preferably, the image is centred and fit to screen.
Coloring of the text to make it stand out would be tops too.

### 04 - Hello You
Display an Input and a button. Allow the user to enter their name into the input, and on pressing the button, they will be presented with the text "Hello &lt;name&gt;" on the screen.

### 05 - Show Us Your Balls
Display a circular object on the screen

### 06 - Moving Balls
Display a circular object on the screen, moving in some manner

### 07 - Bouncey Balls
Display a moving circular object on the screen that moves at a constant rate.
On collision with the screen boundary, this object should bounce and continue moving.
Inelastic collisions are optional.

### 08 - Indecisive Balls
Same as 07 with the following additions/changes:
A start/stop button will show "stop" when the ball is moving. Once pressed it will stop the ball, and the button will read "start".
Starting will enable the ball to continue on its previous course at its previous speed.

### 09 - Reverse Balls
Same as 08 with the following additions/changes:
A "reverse" button will cause the ball to reverse its direction, retaining speed.

### 10 - Lossy Balls
This challenge builds on 09 but should add the following additions/changes:
Collisions with walls should be inelastic and the ball should also loose speed as it moves. This means that the ball will eventually come to a stop. When the ball hits a wall the screen should be rendered slightly brighter to highlight the impact (and give somewhere for the energy to be lost in a virtual way :-).

### 11 - Noisy Balls
This challenge builds on 10 but should add the following additions/changes:
Sound is to be added to the challenge. A single sound sample is to be used and each time a wall is hit with the ball the sample should play. If the ball happens to hit two walls at exactly the same time (in the corner) only one sample should play.

### 12 - Touch my Balls
This challenge builds on 10 but should add the following additions/changes:
In this challenge the start/stop and reverse buttons can be removed from the application. The application should start with a bouncing ball. When a user presses the screen the application should stop. When the user presses the screen again it starts with the ball going in a random direction at full speed.

### 15 - Icon Assignment
A generic set of Icons is to be designed, similar, but with a color variation for the various platforms supported.
This project involved assigning an icon to the application.
All previous Applications should be modified to include the appropriate icon.

### 20 - Flick my Balls
This has been pushed back!

Touches to the screen must be handled. If the user touches the screen where the ball is then it will instantly come to a stop under their finger. If they move their finger around then the ball will follow it. As soon as they lift their finger the ball will continue in the direction it was last moving and act as it did in Noisy Balls.
The direction is taken from the last movement of the users finger from the touch.

