#import "ExampleViewManager.h"
#import "ExampleView.h"

@implementation ExampleViewManager

RCT_EXPORT_MODULE(ExampleView)

RCT_EXPORT_VIEW_PROPERTY(colors, NSArray<UIColor>)
RCT_EXPORT_VIEW_PROPERTY(locations, NSArray<NSNumber *>)
RCT_EXPORT_VIEW_PROPERTY(centerPoint, CGPoint)

#if RCT_NEW_ARCH_ENABLED
#else

- (UIView *)view
{
    ExampleView *view = [ExampleView new];
    return view;
}

#endif

@end