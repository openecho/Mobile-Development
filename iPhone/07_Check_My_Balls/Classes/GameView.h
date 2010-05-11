//
//  GameView.h
//  07_Check_My_Balls
//
//  Created by Predominant on 4/05/10.
//  Copyright 2010 Graham Weldon. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "PhysicsObject.h"

@interface GameView : UIView {
	NSMutableArray *objects;
}

@property (nonatomic, retain) NSMutableArray *objects;

- (void)addObject:(PhysicsObject *)obj;

@end
