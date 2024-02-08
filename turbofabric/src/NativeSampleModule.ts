import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  getAppBuildNumber(): Promise<string>;
  getAppBundleId(): Promise<string>;
  getAppVersion(): Promise<string>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('SampleModule');
