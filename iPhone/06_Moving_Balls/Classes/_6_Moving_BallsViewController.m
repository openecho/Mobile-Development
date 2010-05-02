//
//  _6_Moving_BallsViewController.m
//  06_Moving_Balls
//
//  Created by Predominant on 2/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import "_6_Moving_BallsViewController.h"
#define PI 3.14159

@implementation _6_Moving_BallsViewController
@synthesize ball, positionRotation, viewCenterX, viewCenterY;


/*
// The designated initializer. Override to perform setup that is required before the view is loaded.
- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
    if ((self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil])) {
        // Custom initialization
    }
    return self;
}
*/

/*
// Implement loadView to create a view hierarchy programmatically, without using a nib.
- (void)loadView {
}
*/


// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad {
    [super viewDidLoad];
	[self initGame];
	[NSTimer scheduledTimerWithTimeInterval:1/60.0f target:self selector:@selector(gameLoop) userInfo:nil repeats:YES];
}

- (void)initGame {
	positionRotation = 0;
	viewCenterX = self.view.bounds.size.width / 2;
	viewCenterY = self.view.bounds.size.height / 2;
}

- (void)gameLoop {
	positionRotation += 5;
	if (positionRotation >= 360) {
		positionRotation = positionRotation % 360;
	}
	[self moveBall];
}

- (void)moveBall {
	int radius = 100;
	float radians = positionRotation * PI / 180;
	[ball setCenter:CGPointMake(sin(radians) * radius + viewCenterX, cos(radians) * radius + viewCenterY)];
}

/*
// Override to allow orientations other than the default portrait orientation.
- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}
*/

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
	
	// Release any cached data, images, etc that aren't in use.
}

- (void)viewDidUnload {
	// Release any retained subviews of the main view.
	// e.g. self.myOutlet = nil;
}


- (void)dealloc {
    [super dealloc];
}

@end
