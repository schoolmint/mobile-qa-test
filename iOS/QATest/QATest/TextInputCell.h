//
//  TextInputCell.h
//  QATest
//
//  Created by Alexander Coto on 11/10/15.
//  Copyright © 2015 Schoolmint. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface TextInputCell : UITableViewCell

@property (nonatomic, weak) IBOutlet UILabel *titleLbl;
@property (nonatomic, weak) IBOutlet UITextField *answerFld;

@end
