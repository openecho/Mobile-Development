//
//  _7_Check_My_BallsAppDelegate.m
//  07_Check_My_Balls
//
//  Created by Predominant on 4/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import "_7_Check_My_BallsAppDelegate.h"

@implementation _7_Check_My_BallsAppDelegate

@synthesize window, gameView;


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {    

	gameView = [[GameView alloc] initWithFrame:[[UIScreen mainScreen] applicationFrame]];
	ball = [[Ball alloc] initWithDefaultBall];
	[gameView addObject:ball];
	[window addSubview:gameView];
	
	//gameEngine = [[GameEngine alloc] init];
	[NSTimer scheduledTimerWithTimeInterval:0.2f target:self selector:@selector(gameLoop) userInfo:nil repeats:TRUE];
	
	[window makeKeyAndVisible];
	return YES;
}

- (void)gameLoop {
	// Todo, make this move with respect to the vector.
	[[ball view] setCenter:CGPointMake(100, 200)];
}

- (void)dealloc {
	[window release];
	[gameView release];
	[super dealloc];
}


@end
