import type { ColorValue, HostComponent, ViewProps } from 'react-native';
import type { Double } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

export interface ExampleViewProps extends ViewProps {
  colors: ColorValue[];
  locations: Double[];
  centerPoint?: { x: Double; y: Double };
}

export type ExampleViewComponent = HostComponent<ExampleViewProps>;

export default codegenNativeComponent<ExampleViewProps>(
  'ExampleView',
) as ExampleViewComponent;
