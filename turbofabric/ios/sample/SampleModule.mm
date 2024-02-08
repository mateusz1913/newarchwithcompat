#import "SampleModule.h"
#import "SampleSingleton.h"

#if RCT_NEW_ARCH_ENABLED

#import "MyTurboFabricPackage.h"

@interface SampleModule () <NativeSampleModuleSpec>

@end

#endif

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

#if RCT_NEW_ARCH_ENABLED

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params {
    return std::make_shared<facebook::react::NativeSampleModuleSpecJSI>(params);
}

#endif

@end
