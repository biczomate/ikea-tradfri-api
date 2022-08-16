/*
   Copyright 2020 Stijn Groenen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.MotionSensor;

/**
 * The class that represents a motion sensor event that occurred to an IKEA TRÅDFRI motion sensor
 *
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class MotionSensorEvent extends DeviceEvent {

    /**
     * Construct the MotionSensorEvent class
     *
     * @param motionSensor The motion sensor for which the event occurred
     * @since 1.0.0
     */
    public MotionSensorEvent(MotionSensor motionSensor) {
        super(motionSensor);
    }

    /**
     * Get the motion sensor for which the event occurred
     *
     * @return The motion sensor for which the event occurred
     * @since 1.0.0
     */
    public MotionSensor getMotionSensor() {
        return (MotionSensor) getDevice();
    }

}
