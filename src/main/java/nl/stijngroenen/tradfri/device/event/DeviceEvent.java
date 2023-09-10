/*
 * Copyright 2023 Máté Biczó
 * Copied and adapted from ikea-tradfri-api (https://github.com/StijnGroenen/ikea-tradfri-api)
 *
 * Copyright 2020 Stijn Groenen
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Device;

/**
 * The class that represents a device event that occurred to an IKEA TRÅDFRI device
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class DeviceEvent extends Event {

    /**
     * The device for which the event occurred
     */
    private Device device;

    /**
     * Construct the DeviceEvent class
     * @param device The device for which the event occurred
     * @since 1.0.0
     */
    public DeviceEvent(Device device) {
        super();
        this.device = device;
    }

    /**
     * Get the device for which the event occurred
     * @return The device for which the event occurred
     * @since 1.0.0
     */
    public Device getDevice(){
        return this.device;
    }

}
