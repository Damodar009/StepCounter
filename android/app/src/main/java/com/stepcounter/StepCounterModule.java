package com.stepcounter;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class StepCounterModule extends ReactContextBaseJavaModule{
  private static  ReactApplicationContext reactContext ;
  StepCounterModule(ReactApplicationContext context){
    super(context);
    reactContext = context ;
  }
  @NonNull
  @Override
  public String getName() {
    return "StepCounterModule";
  }

  @ReactMethod
  public void getStepCount(String name){
     Log.d("StepCounterModule", name);
   }
}



 // try{
   
    //   // StepCountingService StepCountingService = new StepCountingService();
    //   // Log.d("this is initialize","this id initialize");
    //   // StepCountingService.initialize();

    // }catch (Exception e){
    //   e.printStackTrace();
    // }