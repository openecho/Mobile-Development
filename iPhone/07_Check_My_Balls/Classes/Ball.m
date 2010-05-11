//
//  Ball.m
//  07_Check_My_Balls
//
//  Created by Predominant on 11/05/10.
//  Copyright 2010 Graham Weldon. All rights reserved.
//

#import "Ball.h"


@implementation Ball

- (id)initWithDefaultBall {
	id ball = [super init];
	[ball setView:[[UIImageView alloc] initWithImage:[UIImage imageNamed:@"mobile_ball.png"]]];
	NSLog(@"Set View from ball");
	return ball;
}

@end
