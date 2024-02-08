import * as React from 'react';

import type { ExampleViewProps } from './ExampleViewNativeComponent';
import ExampleViewNativeComponent from './ExampleViewNativeComponent';
import { ColorValue, processColor } from 'react-native';

const ExampleView = (
  props: Omit<ExampleViewProps, 'colors'> & {
    colors: ReadonlyArray<ColorValue>;
  },
) => {
  const colors = props.colors.map(processColor) as number[];
  return <ExampleViewNativeComponent {...props} colors={colors} />;
};

export default ExampleView;
