//
//  GameView.m
//  07_Check_My_Balls
//
//  Created by Predominant on 4/05/10.
//  Copyright 2010 Graham Weldon. All rights reserved.
//

#import "GameView.h"


@implementation GameView

@synthesize objects;

- (id)initWithFrame:(CGRect)frame {
	if ((self = [super initWithFrame:frame])) {
		[self setBackgroundColor:[UIColor grayColor]];
	}
	return self;
}

- (void)addObject:(PhysicsObject *)obj {
	[self addSubview:[obj view]];
	[objects addObject:obj];
	[[obj view] setCenter:CGPointMake(100, 100)];
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/

- (void)dealloc {
	[super dealloc];
}


@end
