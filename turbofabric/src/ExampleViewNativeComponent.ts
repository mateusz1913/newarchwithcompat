import type { ViewProps } from 'react-native';
import { requireNativeComponent } from 'react-native';

export interface ExampleViewProps extends ViewProps {
  colors: number[];
  locations: number[];
  centerPoint?: { x: number; y: number };
}

const nativeComponent = requireNativeComponent<ExampleViewProps>('ExampleView');

export default nativeComponent;
