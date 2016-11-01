'use strict';
var { Platform, NativeModules, findNodeHandle, InteractionManager } = require('react-native');
var AppseeBridge = NativeModules.Appsee;


class Appsee {

    static start(apiKey) {
        AppseeBridge.start(apiKey);
    }

    static stop() {
        AppseeBridge.stop();
    }


    static pause() {
        AppseeBridge.pause();
    }


    static resume() {
        AppseeBridge.resume();
    }


    static finishSession(verifyBackground, shouldUpload) {
        if (verifyBackground == null || shouldUpload == null) {
            console.log('appsee : finishSession params are invalid');
            return;
        }
        AppseeBridge.finishSession(verifyBackground, shouldUpload);
    }


    static forceNewSession() {
        AppseeBridge.forceNewSession();
    }


    static upload() {
        AppseeBridge.upload();
    }


    static addEvent(eventName, properties) {
        if (!eventName) {
            console.log('appsee : addEvent params are invalid');
            return;
        }
        properties = (properties == null) ? {} : properties;
        AppseeBridge.addEvent(eventName, properties);
    }


    static startScreen(screenName) {
        if (!screenName) {
            console.log('appsee : startScreen params are invalid');
            return;
        }
        AppseeBridge.startScreen(screenName);
    }


    static setUserId(userId) {
        if (!userId) {
            console.log('appsee : setUserId params are invalid');
            return;
        }
        AppseeBridge.setUserId(userId);
    }


    static setLocation(latitude, longitude, horizontalAccuracy, verticalAccuracy) {
        if (latitude == null ||
            longitude == null ||
            horizontalAccuracy == null ||
            verticalAccuracy == null) {
            console.log('appsee : setLocation params are invalid');
            return;
        }
        AppseeBridge.setLocation(latitude, longitude, horizontalAccuracy, verticalAccuracy);
    }

    static setLocationDescription(description) {
        if (!description) {
            console.log('appsee : setLocationDescription can\'t be empty');
            return;
        }
        AppseeBridge.setLocationDescription(description);
    }


    static setOptOutStatus(status) {
        if (status == null) {
            console.log('appsee : setOptOutStatus params are invalid');
            return;
        }
        AppseeBridge.setOptOutStatus(status);
    }

    static markViewAsSensitive(ref) {
        if (ref == null) {
            console.log('appsee : Can\'t mark a null ref as sensitive (are you sure the component has a ref?)');
            return;
        }
        if (Platform.OS === 'android') {
            setTimeout(
                function() {
                    requestAnimationFrame(function() {
                        AppseeBridge.markViewAsSensitive(findNodeHandle(ref));
                    });
                }, 0);
        } else {
            console.log('appsee : markViewAsSensitive is not implemented for iOS yet');
        }
    }

    static unmarkViewAsSensitive(ref) {
        if (ref == null) {
            console.log('appsee : Can\'t mark a null ref as sensitive (are you sure the component has a ref?)');
            return;
        }
        if (Platform.OS === 'android') {
            setTimeout(
                function() {
                    requestAnimationFrame(function() {
                        AppseeBridge.unmarkViewAsSensitive(findNodeHandle(ref));
                    });
                }, 0);
        } else {
            console.log('appsee : unmarkViewAsSensitive is not implemented for iOS yet');
        }
    }

}
module.exports = Appsee;
