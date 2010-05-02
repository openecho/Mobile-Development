//
//  _5_Show_Us_Your_BallsAppDelegate.m
//  05_Show_Us_Your_Balls
//
//  Created by Predominant on 2/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import "_5_Show_Us_Your_BallsAppDelegate.h"

@implementation _5_Show_Us_Your_BallsAppDelegate

@synthesize window;


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {    

    // Override point for customization after application launch
	
    [window makeKeyAndVisible];
	
	return YES;
}


- (void)dealloc {
    [window release];
    [super dealloc];
}


@end
