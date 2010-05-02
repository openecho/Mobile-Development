//
//  _6_Moving_BallsAppDelegate.h
//  06_Moving_Balls
//
//  Created by Predominant on 2/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import <UIKit/UIKit.h>

@class _6_Moving_BallsViewController;

@interface _6_Moving_BallsAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    _6_Moving_BallsViewController *viewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet _6_Moving_BallsViewController *viewController;

@end

