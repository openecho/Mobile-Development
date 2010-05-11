//
//  PhysicsObject.h
//  07_Check_My_Balls
//
//  Created by Predominant on 4/05/10.
//  Copyright 2010 Graham Weldon. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Vector.h"

@interface PhysicsObject : NSObject {
	UIView *view;
	Vector *vector;
}

@property (nonatomic, retain) UIView *view;
@property (nonatomic, retain) Vector *vector;



@end
