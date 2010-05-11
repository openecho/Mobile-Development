//
//  _7_Check_My_BallsAppDelegate.h
//  07_Check_My_Balls
//
//  Created by Predominant on 4/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "GameView.h"
#import "Ball.h"

@interface _7_Check_My_BallsAppDelegate : NSObject <UIApplicationDelegate> {
	UIWindow *window;
	GameView *gameView;
	Ball *ball;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) GameView *gameView;

- (void)gameLoop;

@end

