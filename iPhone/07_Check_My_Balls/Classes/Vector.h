//
//  Vector.h
//  07_Check_My_Balls
//
//  Created by Predominant on 4/05/10.
//  Copyright 2010 Graham Weldon. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface Vector : NSObject {
	double angle, magnitude, rotation;
}

@property (nonatomic) double angle, magnitude, rotation;

- (id)initWithAngle:(double)r;
- (id)initWithAngle:(double)r magnitude:(double)m;
- (Vector *)vectorByAddingVector:(Vector *)v;

@end
