#import <Foundation/Foundation.h>

@interface SampleSingleton : NSObject

+ (SampleSingleton *)shared;

- (NSString *)getAppBuildNumber;
- (NSString *)getAppBundleId;
- (NSString *)getAppVersion;

@end