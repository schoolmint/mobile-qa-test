//
//  ViewController.h
//  QATest
//
//  Created by Alexander Coto on 11/9/15.
//  Copyright © 2015 Schoolmint. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController

@property (nonatomic, weak) IBOutlet UITextField *usernameFld;
@property (nonatomic, weak) IBOutlet UITextField *passwordFld;

-(IBAction)logIn;

@end

