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

package nl.stijngroenen.tradfri.device;

import com.fasterxml.jackson.core.JsonProcessingException;
import nl.stijngroenen.tradfri.device.event.DeviceAddedEvent;
import nl.stijngroenen.tradfri.device.event.DeviceRemovedEvent;
import nl.stijngroenen.tradfri.device.event.EventHandler;
import nl.stijngroenen.tradfri.device.event.GatewayEvent;
import nl.stijngroenen.tradfri.util.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class that observes a device to automagically detect changes
 * @author Stijn Groenen
 * @version 1.0.0
 */
public abstract class Observer implements CoapHandler {

    /**
     * The endpoint to observe
     */
    private String endpoint;

    /**
     * A CoAP client that can be used to communicate with the IKEA TRÅDFRI gateway
     */
    private CoapClient coapClient;

    /**
     * The observe relation used by CoAP to keep track of the connection to the IKEA TRÅDFRI gateway
     */
    private CoapObserveRelation coapObserveRelation;

    /**
     * Construct the Observer class
     * @param endpoint The endpoint to observe
     * @param coapClient A CoAP client that can be used to communicate with the device using the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Observer(String endpoint, CoapClient coapClient) {
        this.endpoint = endpoint;
        this.coapClient = coapClient;
    }

    /**
     * Start observing the endpoint to automagically detect changes
     * @return True if successfully started observing, false if not
     * @since 1.0.0
     */
    public boolean start(){
        if(coapObserveRelation == null || coapObserveRelation.isCanceled()){
            coapObserveRelation = coapClient.requestObserve(endpoint, this);
            return true;
        }
        return false;
    }

    /**
     * Stop observing the device
     * @return True if successfully stopped observing, false if not
     * @since 1.0.0
     */
    public boolean stop(){
        if(coapObserveRelation != null && !coapObserveRelation.isCanceled()){
            coapObserveRelation.proactiveCancel();
            return true;
        }
        return false;
    }

    /**
     * Check if there is a difference between the old value and the new value
     * @param oldValue The old value
     * @param newValue The new value
     * @return True if there is a difference between the old value and the new value, false if they are the same
     * @since 1.0.0
     */
    protected boolean checkChanges(Object oldValue, Object newValue){
        return ((oldValue == null && newValue != null) || (newValue == null && oldValue != null) || (oldValue != null && !oldValue.equals(newValue)));
    }

    /**
     * Handles a new response from the CoAP client
     * @param coapResponse The response to the CoAP request
     * @since 1.0.0
     */
    @Override
    public void onLoad(CoapResponse coapResponse) {
        if(!coapResponse.isSuccess()) return;
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                callEventHandlers(coapResponse.getResponseText());
            } catch (InterruptedException ignored) {
            }
        }).start();
    }

    /**
     * Handles an error from the CoAP client
     * @since 1.0.0
     */
    @Override
    public void onError() {
    }

    /**
     * Call the appropriate event handlers
     * @param payload The payload text of the CoAP response
     * @since 1.0.0
     */
    public abstract void callEventHandlers(String payload);

}
