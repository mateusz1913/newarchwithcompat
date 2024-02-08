#import "SampleSingleton.h"

@implementation SampleSingleton

+ (SampleSingleton *)shared
{
    static SampleSingleton *sharedInstance = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        sharedInstance = [[self alloc] init];
    });
    return sharedInstance;
}

- (NSString *)getAppBuildNumber
{
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleVersion"];
}

- (NSString *)getAppBundleId
{
    return [[NSBundle mainBundle] bundleIdentifier];
}

- (NSString *)getAppVersion
{
    return [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleShortVersionString"];
}

@end
