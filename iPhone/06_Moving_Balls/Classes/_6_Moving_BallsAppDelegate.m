//
//  _6_Moving_BallsAppDelegate.m
//  06_Moving_Balls
//
//  Created by Predominant on 2/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import "_6_Moving_BallsAppDelegate.h"
#import "_6_Moving_BallsViewController.h"

@implementation _6_Moving_BallsAppDelegate

@synthesize window;
@synthesize viewController;


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {    
    
    // Override point for customization after app launch    
	return YES;
}


- (void)dealloc {
    [viewController release];
    [window release];
    [super dealloc];
}


@end
