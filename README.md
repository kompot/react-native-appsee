#Appsee React Native Plugin

##Installation
`npm install --save react-native-appsee`

`react-native link react-native-appsee`

Add `var Appsee = require('react-native-appsee');`

Call `Appsee.start(<ApiKey>);` when your root component loads.


##Hiding Sensetive Views
Pass a component reference to Appsee:

`<View ref='someview' />`

`Appsee.markViewAsSensitive(this.refs['someview']);`

See more in http://www.appsee.com/docs

