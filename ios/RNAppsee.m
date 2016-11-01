#import "RNAppsee.h"
#import "Appsee.h"

@implementation RNAppsee

RCT_EXPORT_MODULE(Appsee)

RCT_EXPORT_METHOD(start: (NSString *) apiKey){
    dispatch_async(dispatch_get_main_queue(), ^{
      [Appsee performSelector:@selector(appendSDKType:) withObject:@"rn"];
      [Appsee start: apiKey];
    });
}

RCT_EXPORT_METHOD(stop){
    [Appsee stop];
}

RCT_EXPORT_METHOD(pause){
    [Appsee pause];
}

RCT_EXPORT_METHOD(resume){
    [Appsee resume];
}

RCT_EXPORT_METHOD(finishSession: (BOOL) verifyBackground upload: (BOOL) shouldUpload){
    [Appsee finishSession: verifyBackground upload: shouldUpload];
}

RCT_EXPORT_METHOD(forceNewSession){
    [Appsee forceNewSession];
}

RCT_EXPORT_METHOD(upload){
    [Appsee upload];
}

RCT_EXPORT_METHOD(addEvent: (NSString *) eventName withProperties: (NSDictionary *) properties){
    [Appsee addEvent: eventName withProperties: properties];
}

RCT_EXPORT_METHOD(startScreen: (NSString *) screenName){
    [Appsee startScreen: screenName];
}

RCT_EXPORT_METHOD(setUserId: (NSString *) userID){
    [Appsee setUserID: userID];
}

RCT_EXPORT_METHOD(setLocation: (double) latitude
                  atLongitude: (double) longtitude
                  horizontalAccuracy: (float) horizontalAccuracy
                  verticalAccuracy: (float) varticalAccuracy){
    [Appsee setLocation: latitude
              longitude:longtitude
     horizontalAccuracy:horizontalAccuracy
       verticalAccuracy:varticalAccuracy];
}

RCT_EXPORT_METHOD(setLocationDescription: (NSString *) description){
    [Appsee setLocationDescription: description];
}

RCT_EXPORT_METHOD(setOptOutStatus: (BOOL) status){
    [Appsee setOptOutStatus: status];
}

@end
