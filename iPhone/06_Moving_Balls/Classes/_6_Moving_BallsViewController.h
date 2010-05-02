//
//  _6_Moving_BallsViewController.h
//  06_Moving_Balls
//
//  Created by Predominant on 2/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface _6_Moving_BallsViewController : UIViewController {

	IBOutlet UIImageView *ball;
	int positionRotation, viewCenterX, viewCenterY;
	
}

@property (nonatomic, retain) IBOutlet UIImageView *ball;
@property (nonatomic) int positionRotation, viewCenterX, viewCenterY;

- (void)gameLoop;
- (void)initGame;
- (void)moveBall;

@end

