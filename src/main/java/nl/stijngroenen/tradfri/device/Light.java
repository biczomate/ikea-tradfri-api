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

import nl.stijngroenen.tradfri.payload.DeviceRequest;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;
import nl.stijngroenen.tradfri.util.ColourRGB;
import nl.stijngroenen.tradfri.util.ColourXY;

/**
 * The class that represents an IKEA TRÅDFRI light
 * @author Stijn Groenen
 * @version 1.1.0
 */
public class Light extends Device {

    /**
     * The current properties of the light
     */
    private LightProperties properties;

    /**
     * The new properties of the light in the update queue
     */
    private LightProperties newProperties;

    /**
     * Construct the Light class
     * @param name The name of the light
     * @param creationDate The creation date of the light
     * @param instanceId The instance id of the light
     * @param deviceInfo The information of the device
     * @param properties The properties of the light
     * @param coapClient A CoAP client that can be used to communicate with the light using the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Light(String name, Long creationDate, Integer instanceId, DeviceInfo deviceInfo, LightProperties properties, CoapClient coapClient){
        super(name, creationDate, instanceId, deviceInfo, coapClient);
        this.properties = properties;
        this.newProperties = new LightProperties();
    }

    /**
     * Get the properties of the light
     * @return The properties of the light
     * @since 1.0.0
     */
    @Override
    public LightProperties getProperties(){
        return this.properties;
    }

    /**
     * Set the properties of the light
     * @param properties The properties of the light
     * @since 1.0.0
     */
    @Override
    public void setProperties(DeviceProperties properties){
        if(properties instanceof LightProperties) this.properties = (LightProperties) properties;
    }

    /**
     * Get the on / off state of the light
     * @return The on / off state of the light (true for on, false for off)
     * @since 1.0.0
     */
    public Boolean getOn() {
        return properties.getOn();
    }

    /**
     * Get the brightness of the light
     * @return The brightness of the light
     * @since 1.0.0
     */
    public Integer getBrightness() {
        return properties.getBrightness();
    }

    /**
     * Get the colour of the light in hexadecimals
     * @return The colour of the light in hexadecimals
     * @since 1.0.0
     */
    public String getColourHex() {
        return properties.getColourHex();
    }

    /**
     * Get the hue of the light
     * @return The hue of the light
     * @since 1.0.0
     */
    public Integer getHue() {
        return properties.getHue();
    }

    /**
     * Get the saturation of the light
     * @return The saturation of the light
     * @since 1.0.0
     */
    public Integer getSaturation() {
        return properties.getSaturation();
    }

    /**
     * Get the X value of the colour of the light
     * @return The X value of the colour of the light
     * @since 1.0.0
     */
    public Integer getColourX() {
        return properties.getColourX();
    }

    /**
     * Get the Y value of the colour of the light
     * @return The Y value of the colour of the light
     * @since 1.0.0
     */
    public Integer getColourY() {
        return properties.getColourY();
    }

    /**
     * Get the XY values of the colour of the light
     * @return The XY values of the colour of the light
     * @since 1.1.0
     */
    public ColourXY getColourXY() {
        return new ColourXY(properties.getColourX(), properties.getColourY());
    }

    /**
     * Get the RGB values of the colour of the light
     * @return The RGB values of the colour of the light
     * @since 1.1.0
     */
    public ColourRGB getColourRGB() {
        return ColourRGB.fromHS(properties.getHue() != null ? properties.getHue() : 0, properties.getSaturation() != null ? properties.getSaturation() : 0);
    }

    /**
     * Get the colour temperature of the light
     * @return The colour temperature of the light
     * @since 1.0.0
     */
    public Integer getColourTemperature() {
        return properties.getColourTemperature();
    }

    /**
     * Update the on / off state of the light in the update queue
     * @param on The new on / off state for the light (true for on, false for off)
     * @since 1.0.0
     */
    public void updateOn(Boolean on) {
        newProperties.setOn(on);
    }

    /**
     * Update the brightness of the light in the update queue
     * @param brightness The new brightness for the light
     * @since 1.0.0
     */
    public void updateBrightness(Integer brightness) {
        newProperties.setBrightness(brightness);
    }

    /**
     * Update the colour of the light in the update queue to a predefined hexadecimal colour<br>
     * Available colours:<br>
     * <ul>
     *     <li>RGB: {@link nl.stijngroenen.tradfri.util.ColourHex}</li>
     *     <li>Colour temperatures: {@link nl.stijngroenen.tradfri.util.ColourTemperatureHex}</li>
     * </ul>
     * @param colourHex The new colour for the light
     * @since 1.0.0
     */
    public void updateColourHex(String colourHex) {
        newProperties.setColourHex(colourHex);
        newProperties.setHue(null);
        newProperties.setSaturation(null);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
        newProperties.setColourTemperature(null);
    }

    /**
     * Update the hue of the light in the update queue
     * @param hue The new hue for the light
     * @since 1.0.0
     */
    public void updateHue(Integer hue) {
        newProperties.setHue(hue);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
        newProperties.setColourHex(null);
        newProperties.setColourTemperature(null);
    }

    /**
     * Update the saturation of the light in the update queue
     * @param saturation The new saturation for the light
     * @since 1.0.0
     */
    public void updateSaturation(Integer saturation) {
        newProperties.setSaturation(saturation);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
        newProperties.setColourHex(null);
        newProperties.setColourTemperature(null);
    }

    /**
     * Update the colour of the light in the update queue
     * @param colourX The X value of the new colour for the light
     * @param colourY The Y value of the new colour for the light
     * @since 1.0.0
     */
    public void updateColourXY(Integer colourX, Integer colourY) {
        newProperties.setColourX(colourX);
        newProperties.setColourY(colourY);
        newProperties.setColourHex(null);
        newProperties.setHue(null);
        newProperties.setSaturation(null);
        newProperties.setColourTemperature(null);
    }

    /**
     * Update the colour of the light in the update queue
     * @param colourXY The new colour for the light
     * @since 1.1.0
     */
    public void updateColour(ColourXY colourXY) {
        newProperties.setColourX(colourXY.getX());
        newProperties.setColourY(colourXY.getY());
        newProperties.setColourHex(null);
        newProperties.setHue(null);
        newProperties.setSaturation(null);
        newProperties.setColourTemperature(null);
    }

    /**
     * Update the colour of the light in the update queue
     * @param colourRGB The new colour for the light
     * @since 1.1.0
     */
    public void updateColour(ColourRGB colourRGB) {
        updateColour(ColourXY.fromRGB(colourRGB));
    }

    /**
     * Update the colour of the light in the update queue
     * @param colourRed The red value of the new colour for the light
     * @param colourGreen The green value of the new colour for the light
     * @param colourBlue The blue value of the new colour for the light
     * @since 1.0.0
     */
    public void updateColourRGB(int colourRed, int colourGreen, int colourBlue) {
        updateColour(new ColourRGB(colourRed, colourGreen, colourBlue));
    }

    /**
     * Update the colour temperature of the light in the update queue
     * @param colourTemperature The new colour temperature for the light
     * @since 1.0.0
     */
    public void updateColourTemperature(Integer colourTemperature) {
        newProperties.setColourTemperature(colourTemperature);
        newProperties.setColourHex(null);
        newProperties.setHue(null);
        newProperties.setSaturation(null);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
    }

    /**
     * Update the transition time for updating the light in the update queue
     * @param transitionTime The new transition time for updating the light
     * @since 1.0.0
     */
    public void updateTransitionTime(Integer transitionTime){
        newProperties.setTransitionTime(transitionTime);
    }

    /**
     * Set the on / off state of the light
     * @param on The new on / off state for the light (true for on, false for off)
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the on / off state of the light, false if not
     * @since 1.0.0
     */
    public boolean setOn(Boolean on, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setOn(on);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    /**
     * Set the on / off state of the light
     * @param on The new on / off state for the light (true for on, false for off)
     * @return True if successfully updated the on / off state of the light, false if not
     * @since 1.0.0
     */
    public boolean setOn(Boolean on){
        return setOn(on, null);
    }

    /**
     * Set the brightness of the light
     * @param brightness The new brightness for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the brightness of the light, false if not
     * @since 1.0.0
     */
    public boolean setBrightness(Integer brightness, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setBrightness(brightness);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    /**
     * Set the brightness of the light
     * @param brightness The new brightness for the light
     * @return True if successfully updated the brightness of the light, false if not
     * @since 1.0.0
     */
    public boolean setBrightness(Integer brightness){
        return setBrightness(brightness, null);
    }

    /**
     * Set the colour of the light to a predefined hexadecimal colour<br>
     * Available colours:<br>
     * <ul>
     *     <li>RGB: {@link nl.stijngroenen.tradfri.util.ColourHex}</li>
     *     <li>Colour temperatures: {@link nl.stijngroenen.tradfri.util.ColourTemperatureHex}</li>
     * </ul>
     * @param colourHex The new colour for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourHex(String colourHex, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setColourHex(colourHex);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    /**
     * Set the colour of the light to a predefined hexadecimal colour<br>
     * Available colours:<br>
     * <ul>
     *     <li>RGB: {@link nl.stijngroenen.tradfri.util.ColourHex}</li>
     *     <li>Colour temperatures: {@link nl.stijngroenen.tradfri.util.ColourTemperatureHex}</li>
     * </ul>
     * @param colourHex The new colour for the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourHex(String colourHex){
        return setColourHex(colourHex, null);
    }

    /**
     * Set the hue of the light
     * @param hue The new hue for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the hue of the light, false if not
     * @since 1.0.0
     */
    public boolean setHue(Integer hue, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setHue(hue);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    /**
     * Set the hue of the light
     * @param hue The new hue for the light
     * @return True if successfully updated the hue of the light, false if not
     * @since 1.0.0
     */
    public boolean setHue(Integer hue){
        return setHue(hue, null);
    }

    /**
     * Set the saturation of the light
     * @param saturation The new saturation for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the saturation of the light, false if not
     * @since 1.0.0
     */
    public boolean setSaturation(Integer saturation, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setSaturation(saturation);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    /**
     * Set the saturation of the light
     * @param saturation The new saturation for the light
     * @return True if successfully updated the saturation of the light, false if not
     * @since 1.0.0
     */
    public boolean setSaturation(Integer saturation){
        return setSaturation(saturation, null);
    }

    /**
     * Set the colour of the light
     * @param colourX The X value of the new colour for the light
     * @param colourY The Y value of the new colour for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourXY(Integer colourX, Integer colourY, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setColourX(colourX);
        newProperties.setColourY(colourY);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    /**
     * Set the colour of the light
     * @param colourX The X value of the new colour for the light
     * @param colourY The Y value of the new colour for the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourXY(Integer colourX, Integer colourY){
        return setColourXY(colourX, colourY, null);
    }

    /**
     * Set the colour of the light
     * @param colourXY The new colour for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.1.0
     */
    public boolean setColour(ColourXY colourXY, Integer transitionTime) {
        return setColourXY(colourXY.getX(), colourXY.getY(), transitionTime);
    }

    /**
     * Set the colour of the light
     * @param colourXY The new colour for the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.1.0
     */
    public boolean setColour(ColourXY colourXY){
        return setColour(colourXY, null);
    }

    /**
     * Set the colour of the light
     * @param colourRGB The new colour for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.1.0
     */
    public boolean setColour(ColourRGB colourRGB, Integer transitionTime) {
        return setColour(ColourXY.fromRGB(colourRGB), transitionTime);
    }

    /**
     * Set the colour of the light
     * @param colourRGB The new colour for the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.1.0
     */
    public boolean setColour(ColourRGB colourRGB){
        return setColour(colourRGB, null);
    }

    /**
     * Set the colour of the light
     * @param colourRed The red value of the new colour for the light
     * @param colourGreen The green value of the new colour for the light
     * @param colourBlue The blue value of the new colour for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourRGB(int colourRed, int colourGreen, int colourBlue, Integer transitionTime) {
        return setColour(new ColourRGB(colourRed, colourGreen, colourBlue), transitionTime);
    }

    /**
     * Set the colour of the light
     * @param colourRed The red value of the new colour for the light
     * @param colourGreen The green value of the new colour for the light
     * @param colourBlue The blue value of the new colour for the light
     * @return True if successfully updated the colour of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourRGB(int colourRed, int colourGreen, int colourBlue){
        return setColour(new ColourRGB(colourRed, colourGreen, colourBlue));
    }

    /**
     * Set the colour temperature of the light
     * @param colourTemperature The new colour temperature for the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the colour temperature of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourTemperature(Integer colourTemperature, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setColourTemperature(colourTemperature);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    /**
     * Set the colour temperature of the light
     * @param colourTemperature The new colour temperature for the light
     * @return True if successfully updated the colour temperature of the light, false if not
     * @since 1.0.0
     */
    public boolean setColourTemperature(Integer colourTemperature){
        return setColourTemperature(colourTemperature, null);
    }

    /**
     * Apply updates to the light
     * @param newProperties The new properties to apply to the light
     * @return True if successfully updated the light, false if not
     * @since 1.0.0
     */
    private boolean applyUpdate(LightProperties newProperties) {
        DeviceRequest request = new DeviceRequest();
        request.setLightProperties(new LightProperties[]{newProperties});
        String response = coapClient.put(ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(getInstanceId())), request, String.class);
        return response != null;
    }

    /**
     * Apply the updates in the update queue to the light
     * @return True if successfully updated the light, false if not
     * @since 1.0.0
     */
    public boolean applyUpdates() {
        boolean success = applyUpdate(newProperties);
        newProperties = new LightProperties();
        return success;
    }

    /**
     * Apply the updates in the update queue to the light
     * @param transitionTime The transition time for updating the light
     * @return True if successfully updated the light, false if not
     * @since 1.0.0
     */
    public boolean applyUpdates(Integer transitionTime) {
        newProperties.setTransitionTime(transitionTime);
        return applyUpdates();
    }

}
