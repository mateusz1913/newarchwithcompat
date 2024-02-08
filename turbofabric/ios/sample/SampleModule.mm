#import "SampleModule.h"
#import "SampleSingleton.h"

@implementation SampleModule

RCT_EXPORT_MODULE(SampleModule)

RCT_EXPORT_METHOD(getAppBuildNumber:(RCTPromiseResolveBlock)resolve
                             reject:(RCTPromiseRejectBlock)reject)
{
    resolve([SampleSingleton shared].getAppBuildNumber);
}

RCT_EXPORT_METHOD(getAppBundleId:(RCTPromiseResolveBlock)resolve
                          reject:(RCTPromiseRejectBlock)reject)
{
    resolve([SampleSingleton shared].getAppBundleId);
}

RCT_EXPORT_METHOD(getAppVersion:(RCTPromiseResolveBlock)resolve
                         reject:(RCTPromiseRejectBlock)reject)
{
    resolve([SampleSingleton shared].getAppVersion);
}

@end
