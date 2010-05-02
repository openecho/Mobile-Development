//
//  _4_Hello_YouAppDelegate.m
//  04_Hello_You
//
//  Created by Predominant on 2/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import "_4_Hello_YouAppDelegate.h"

@implementation _4_Hello_YouAppDelegate

@synthesize window, label, button, inputField;

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {    

    // Override point for customization after application launch
	
    [window makeKeyAndVisible];
	
	return YES;
}

- (IBAction)updateLabel:(id)sender {
	[[self label] setText:[@"Hello " stringByAppendingString:[[self inputField] text]]];
}

- (void)dealloc {
    [window release];
    [super dealloc];
}


@end
