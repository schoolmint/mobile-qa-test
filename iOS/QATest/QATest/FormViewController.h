//
//  FormViewController.h
//  QATest
//
//  Created by Alexander Coto on 11/9/15.
//  Copyright © 2015 Schoolmint. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface FormViewController : UIViewController <UITableViewDataSource, UITableViewDelegate, UITextFieldDelegate>

@property (nonatomic, strong) NSMutableDictionary *answers;
@property (nonatomic, assign) UITextField *lastEdited;

- (IBAction)submit;

@end
