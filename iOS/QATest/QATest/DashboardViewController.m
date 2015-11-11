//
//  DashboardViewController.m
//  QATest
//
//  Created by Alexander Coto on 11/9/15.
//  Copyright © 2015 Schoolmint. All rights reserved.
//

#import "DashboardViewController.h"
#import "FormViewController.h"

@interface DashboardViewController ()

@end

@implementation DashboardViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)startForm {
    FormViewController *form = [[FormViewController alloc] init];
    [self presentViewController:form animated:YES completion:nil];
}

@end
