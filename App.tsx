import * as React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { ExampleView, SampleModule } from 'my-turbofabric-library';

const App = () => {
  const [appBuildNumber, setAppBuildNumber] = React.useState('');
  const [appBundleId, setAppBundleId] = React.useState('');
  const [appVersion, setAppVersion] = React.useState('');
  React.useEffect(() => {
    SampleModule.getAppBuildNumber().then(setAppBuildNumber);
    SampleModule.getAppBundleId().then(setAppBundleId);
    SampleModule.getAppVersion().then(setAppVersion);
  }, []);
  return (
    <View style={styles.screen}>
      <Text style={styles.label}>App Build Number: {appBuildNumber}</Text>
      <Text style={styles.label}>App Bundle Id: {appBundleId}</Text>
      <Text style={styles.label}>App Version: {appVersion}</Text>
      <ExampleView
        colors={['blue', 'purple', 'red']}
        locations={[0.1, 0.3, 0.8]}
        centerPoint={{ x: 0.45, y: 0.55 }}
        style={styles.gradient}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  gradient: {
    height: 200,
    marginVertical: 30,
    width: 200,
  },
  label: {
    color: 'white',
    fontSize: 20,
  },
  screen: {
    alignItems: 'center',
    alignSelf: 'stretch',
    backgroundColor: 'green',
    flex: 1,
    justifyContent: 'center',
  },
});

export default App;
