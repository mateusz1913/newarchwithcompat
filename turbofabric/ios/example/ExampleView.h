#import <UIKit/UIKit.h>
#import <QuartzCore/QuartzCore.h>

@interface ExampleView : UIView

@property (nonatomic, readonly, strong) CAGradientLayer * _Nonnull layer;

@property (nonatomic, copy) NSArray<UIColor *> * _Nonnull colors;
@property (nonatomic, copy) NSArray<NSNumber *> * _Nonnull locations;
@property (nonatomic, assign) CGPoint centerPoint;

@end
