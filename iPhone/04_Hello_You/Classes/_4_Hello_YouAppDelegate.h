//
//  _4_Hello_YouAppDelegate.h
//  04_Hello_You
//
//  Created by Predominant on 2/05/10.
//  Copyright Graham Weldon 2010. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface _4_Hello_YouAppDelegate : NSObject <UIApplicationDelegate> {
	UIWindow *window;
	IBOutlet UILabel *label;
	IBOutlet UITextField *inputField;
	IBOutlet UIButton *button;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet UILabel *label;
@property (nonatomic, retain) IBOutlet UITextField *inputField;
@property (nonatomic, retain) IBOutlet UIButton *button;

- (IBAction)updateLabel:(id)sender;

@end

