//
//  Vector.m
//  07_Check_My_Balls
//
//  Created by Predominant on 4/05/10.
//  Copyright 2010 Graham Weldon. All rights reserved.
//

#import "Vector.h"


@implementation Vector

@synthesize angle, magnitude, rotation;

- (id)initWithAngle:(double)r {
	return [self initWithAngle:r magnitude:1.0f];
}

- (id)initWithAngle:(double)r magnitude:(double)m {
	[self setAngle:r];
	[self setMagnitude:m];
	[self setRotation:0.0f];
	return self;
}

- (Vector *)vectorByAddingVector:(Vector *)v {
	double ax = [self magnitude] * cos([self angle]);
	double ay = [self magnitude] * sin([self angle]);
	
	double bx = [v magnitude] * cos([v angle]);
	double by = [v magnitude] * sin([v angle]);
	
	double m = sqrt(pow(ax + bx, 2) + pow(ay + by, 2));
	double a = tanh((ay + by) / (ax + bx));
	
	Vector *result = [[Vector alloc] initWithAngle:a magnitude:m];
	[result autorelease];
	return result;
}


@end
