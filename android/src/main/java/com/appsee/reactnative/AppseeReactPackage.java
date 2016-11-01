package com.appsee.reactnative;

import android.app.Activity;
import android.view.View;

import com.appsee.Appsee;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppseeReactPackage implements ReactPackage {

    public AppseeReactPackage() {}

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new AppseeModule(reactContext));

        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }


    private class AppseeModule extends ReactContextBaseJavaModule {

        AppseeModule(ReactApplicationContext reactContext) {
            super(reactContext);
        }

        @Override
        public String getName() {
            return "Appsee";
        }

        @ReactMethod
        public void start(String apiKey) {
            Appsee.appendSDKType("rn");
            Appsee.setSkipStartValidation(true);
            Appsee.start(apiKey);
        }

        @ReactMethod
        public void stop() {
            Appsee.stop();
        }

        @ReactMethod
        public void pause() {
            Appsee.pause();
        }

        @ReactMethod
        public void resume() {
            Appsee.resume();
        }

        @ReactMethod
        public void finishSession(boolean verifyBackground, boolean shouldUpload) {
            Appsee.finishSession(verifyBackground, shouldUpload);
        }

        @ReactMethod
        public void forceNewSession() {
            Appsee.forceNewSession();
        }

        @ReactMethod
        public void upload() {
            Appsee.upload();
        }

        @ReactMethod
        public void addEvent(String eventName, ReadableMap properties){
            ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;
            if(nativeProperties == null) {
                Appsee.addEvent(eventName);
            } else {
                Appsee.addEvent(eventName, nativeProperties.toHashMap());
            }
        }

        @ReactMethod
        public void startScreen(String screenName) {
            Appsee.startScreen(screenName);
        }

        @ReactMethod
        public void setUserId(String userId) {
            Appsee.setUserId(userId);
        }

        @ReactMethod
        public void setLocation(double latitude, double longitude,
            float horizontalAccuracy, float verticalAccuracy) {
            Appsee.setLocation(latitude, longitude, horizontalAccuracy, verticalAccuracy);
        }

        @ReactMethod
        public void setLocationDescription(String description) {
            Appsee.setLocationDescription(description);
        }

        @ReactMethod
        public void setOptOutStatus(boolean status) {
            Appsee.setOptOutStatus(status);
        }

        @ReactMethod
        public void markViewAsSensitive(int id) {
            Activity currentActivity = this.getCurrentActivity();
            if(currentActivity != null) {
                View view = currentActivity.findViewById(id);
                Appsee.markViewAsSensitive(view);
            }
        }

        @ReactMethod
        public void unmarkViewAsSensitive(int id) {
            Activity currentActivity = this.getCurrentActivity();
            if(currentActivity != null) {
                View view = currentActivity.findViewById(id);
                Appsee.unmarkViewAsSensitive(view);
            }
        }
    }
}
