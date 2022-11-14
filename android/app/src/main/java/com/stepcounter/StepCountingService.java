package com.stepcounter;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;


public class StepCountingService extends Service implements SensorEventListener {
  SensorManager sensorManager;
  //Sensor stepCounterSensor;
  Sensor stepDetectorSensor;
  int currentStepsDetected;
  int stepCounter;
  int newStepCounter;
  Sensor stepSensor ;
  int counter = 0;

  void initialize(){
    sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    if(stepSensor == null){
      Toast.makeText(this , "No sensor detected on this device", Toast.LENGTH_SHORT).show();
    } 
    else {
      sensorManager.registerListener(this,stepSensor, SensorManager.SENSOR_DELAY_UI );
    }
  }


  @Override
  public void onSensorChanged(SensorEvent event) {
    if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
      int countSteps = (int) event.values[0];
    
      if (stepCounter == 0) {
        stepCounter = (int) event.values[0];
      
      }
      newStepCounter = countSteps - stepCounter;
    }
    if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
      int detectSteps = (int) event.values[0];
      currentStepsDetected += detectSteps;
    }
  }
  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}

