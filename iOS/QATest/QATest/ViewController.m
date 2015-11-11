//
//  ViewController.m
//  QATest
//
//  Created by Alexander Coto on 11/9/15.
//  Copyright © 2015 Schoolmint. All rights reserved.
//

#import "ViewController.h"
#import "DashboardViewController.h"
#import <AFNetworking/AFNetworking.h>

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)logIn {
    
    NSDictionary *dict = [NSDictionary dictionaryWithObjectsAndKeys:
                          self.usernameFld.text, @"login",
                          self.passwordFld.text, @"password",
                          nil];;
    NSString *string = [NSString stringWithFormat:@"http://successful.schoolmintqa.net/api/v1/accounts/signin.json"];
    
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    [manager POST:string parameters:dict success:^(NSURLSessionDataTask *task, id responseObject) {
        DashboardViewController *dashboard = [[DashboardViewController alloc] init];
        [self presentViewController:dashboard animated:YES completion:nil];
    } failure:^(NSURLSessionDataTask *task, NSError *error) {
        if (error && [[error.userInfo objectForKey:@"NSLocalizedDescription"] isEqualToString:@"The Internet connection appears to be offline."]) {
            [[NSMutableDictionary dictionary] setObject:nil forKey:@"error"];
        } else {
            UIAlertController *alert = [UIAlertController alertControllerWithTitle:nil message:@"Invalid username or password, please try again." preferredStyle:UIAlertControllerStyleAlert];
            [alert addAction:[UIAlertAction actionWithTitle:@"Ok" style:UIAlertActionStyleDefault handler:^(UIAlertAction * _Nonnull action) {
                [alert dismissViewControllerAnimated:YES completion:nil];
            }]];
            [self presentViewController:alert animated:YES completion:nil];
        }
    }];
}

@end
