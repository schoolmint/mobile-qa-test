//
//  ConfirmationViewController.h
//  QATest
//
//  Created by Alexander Coto on 11/9/15.
//  Copyright © 2015 Schoolmint. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ConfirmationViewController : UIViewController <UITableViewDelegate, UITableViewDataSource>

@property (nonatomic, strong) NSMutableDictionary *answers;

@end
