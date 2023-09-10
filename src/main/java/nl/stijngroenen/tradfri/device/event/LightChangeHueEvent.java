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

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

/**
 * The class that represents a light hue changed event that occurred to an IKEA TRÅDFRI light
 *
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class LightChangeHueEvent extends LightChangeEvent {

    /**
     * Construct the LightChangeHueEvent class
     *
     * @param light         The light for which the event occurred
     * @param oldProperties The old properties of the light (from before the event occurred)
     * @param newProperties The new properties of the light (from after the event occurred)
     * @since 1.0.0
     */
    public LightChangeHueEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    /**
     * Get the old hue of the light (from before the event occurred)
     *
     * @return The old hue of the light
     * @since 1.0.0
     */
    public int getOldHue() {
        return getOldProperties().getHue();
    }

    /**
     * Get the new hue of the light (from after the event occurred)
     *
     * @return The new hue of the light
     * @since 1.0.0
     */
    public int getNewHue() {
        return getNewProperties().getHue();
    }

}
