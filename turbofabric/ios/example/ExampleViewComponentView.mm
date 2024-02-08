#if RCT_NEW_ARCH_ENABLED

#import "ExampleViewComponentView.h"
#import "ExampleView.h"

#import <React/RCTConversions.h>
#import <RCTTypeSafety/RCTConvertHelpers.h>

#import <react/renderer/components/MyTurboFabricPackage/ComponentDescriptors.h>
#import <react/renderer/components/MyTurboFabricPackage/EventEmitters.h>
#import <react/renderer/components/MyTurboFabricPackage/Props.h>
#import <react/renderer/components/MyTurboFabricPackage/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

using namespace facebook::react;

@interface ExampleViewComponentView () <RCTExampleViewViewProtocol>
@end

@implementation ExampleViewComponentView

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const ExampleViewProps>();
        _props = defaultProps;

        self.contentView = [ExampleView new];
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<const ExampleViewProps>(_props);
    const auto &newViewProps = *std::static_pointer_cast<const ExampleViewProps>(props);

    if (oldViewProps.colors != newViewProps.colors) {
        auto colors = RCTConvertVecToArray(newViewProps.colors, ^id(SharedColor item){
            return (id)RCTUIColorFromSharedColor(item);
        });
        ((ExampleView *) self.contentView).colors = colors;
    }

    if (oldViewProps.locations != newViewProps.locations) {
        auto locations = RCTConvertVecToArray(newViewProps.locations, ^id(double item){
            return @(item);
        });
        ((ExampleView *) self.contentView).locations = locations;
    }

    if (oldViewProps.centerPoint.x != newViewProps.centerPoint.x || oldViewProps.centerPoint.y != newViewProps.centerPoint.y) {
        auto centerPoint = CGPointMake(newViewProps.centerPoint.x, newViewProps.centerPoint.y);
        ((ExampleView *) self.contentView).centerPoint = centerPoint;
    }

    [super updateProps:props oldProps:oldProps];
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<ExampleViewComponentDescriptor>();
}

@end

Class<RCTComponentViewProtocol> ExampleViewCls(void)
{
    return ExampleViewComponentView.class;
}

#endif
