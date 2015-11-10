//
//  FormViewController.m
//  QATest
//
//  Created by Alexander Coto on 11/9/15.
//  Copyright © 2015 Schoolmint. All rights reserved.
//

#import "FormViewController.h"
#import "ConfirmationViewController.h"
#import "TextInputCell.h"

@interface FormViewController ()

@end

@implementation FormViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    UITapGestureRecognizer *recog = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(hideKeyboard)];
    [self.view addGestureRecognizer:recog];
    
    self.answers = [NSMutableDictionary new];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)submit {
    
    //Bug last edited won't be saved.
    /*if (self.lastEdited) {
        [self.lastEdited resignFirstResponder];
    }*/
    
    ConfirmationViewController *confirmation = [[ConfirmationViewController alloc] init];
    confirmation.answers = self.answers;
    [self presentViewController:confirmation animated:YES completion:nil];
}

- (void)hideKeyboard {
    if (self.lastEdited) {
        [self.lastEdited resignFirstResponder];
    }
}

#pragma mark Tableview

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return 5;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    TextInputCell *cell = [tableView dequeueReusableCellWithIdentifier:@"text_cell"];
    
    if (!cell) {
        NSArray *nibs = [[NSBundle mainBundle] loadNibNamed:@"TextInputCell" owner:self options:nil];
        cell = (TextInputCell *)[nibs firstObject];
    }
    cell.titleLbl.text = [NSString stringWithFormat:@"Field #%d", (int)indexPath.row + 1];
    cell.answerFld.delegate = self;
    cell.answerFld.tag = indexPath.row + 1;
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    return cell;
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {
    return 70;
}

- (void)textFieldDidBeginEditing:(UITextField *)textField {
    self.lastEdited = textField;
}

- (void)textFieldDidEndEditing:(UITextField *)textField {
    [self.answers setObject:textField.text forKey:[NSString stringWithFormat:@"Field #%d", (int)textField.tag]];
}

@end
