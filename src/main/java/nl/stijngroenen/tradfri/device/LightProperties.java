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

package nl.stijngroenen.tradfri.device;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

/**
 * The class that contains the properties of an IKEA TRÅDFRI light
 *
 * @author Stijn Groenen
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LightProperties extends DeviceProperties {

    /**
     * The on state of the light (true for on, false for off)
     */
    @JsonProperty(ApiCode.ON_OFF)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Boolean on;

    /**
     * The brightness of the light
     */
    @JsonProperty(ApiCode.BRIGHTNESS)
    private Integer brightness;

    /**
     * The colour of the light in hexadecimals
     */
    @JsonProperty(ApiCode.COLOUR_HEX)
    private String colourHex;

    /**
     * The hue of the light
     */
    @JsonProperty(ApiCode.HUE)
    private Integer hue;

    /**
     * The saturation of the light
     */
    @JsonProperty(ApiCode.SATURATION)
    private Integer saturation;

    /**
     * The X value of the colour of the light
     */
    @JsonProperty(ApiCode.COLOUR_X)
    private Integer colourX;

    /**
     * The Y value of the colour of the light
     */
    @JsonProperty(ApiCode.COLOUR_Y)
    private Integer colourY;

    /**
     * The colour temperature of the light
     */
    @JsonProperty(ApiCode.COLOUR_TEMPERATURE)
    private Integer colourTemperature;

    /**
     * The transition time for updating the light
     */
    @JsonProperty(ApiCode.TRANSITION_TIME)
    private Integer transitionTime;

    /**
     * Construct the LightProperties class
     *
     * @since 1.0.0
     */
    public LightProperties() {
    }

    /**
     * Get the on state of the light
     *
     * @return The on state of the light (true for on, false for off)
     * @since 1.0.0
     */
    public Boolean getOn() {
        return this.on;
    }

    /**
     * Get the brightness of the light
     *
     * @return The brightness of the light
     * @since 1.0.0
     */
    public Integer getBrightness() {
        return this.brightness;
    }

    /**
     * Get the colour of the light in hexadecimals
     *
     * @return The colour of the light in hexadecimals
     * @since 1.0.0
     */
    public String getColourHex() {
        return this.colourHex;
    }

    /**
     * Get the hue of the light
     *
     * @return The hue of the light
     * @since 1.0.0
     */
    public Integer getHue() {
        return this.hue;
    }

    /**
     * Get the saturation of the light
     *
     * @return The saturation of the light
     * @since 1.0.0
     */
    public Integer getSaturation() {
        return this.saturation;
    }

    /**
     * Get the X value of the colour of the light
     *
     * @return The X value of the colour of the light
     * @since 1.0.0
     */
    public Integer getColourX() {
        return this.colourX;
    }

    /**
     * Get the Y value of the colour of the light
     *
     * @return The Y value of the colour of the light
     * @since 1.0.0
     */
    public Integer getColourY() {
        return this.colourY;
    }

    /**
     * Get the colour temperature of the light
     *
     * @return The colour temperature of the light
     * @since 1.0.0
     */
    public Integer getColourTemperature() {
        return this.colourTemperature;
    }

    /**
     * Get the transition time for updating the light
     *
     * @return The transition time for updating the light
     * @since 1.0.0
     */
    public Integer getTransitionTime() {
        return this.transitionTime;
    }

    /**
     * Set the on state of the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param on The new on state for the light (true for on, false for off)
     * @since 1.0.0
     */
    public void setOn(Boolean on) {
        this.on = on;
    }

    /**
     * Set the brightness of the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param brightness The new brightness for the light
     * @since 1.0.0
     */
    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    /**
     * Set the colour of the light to a predefined hexadecimal colour within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     * Available colours:<br>
     * <ul>
     *     <li>RGB: {@link nl.stijngroenen.tradfri.util.ColourHex}</li>
     *     <li>Colour temperatures: {@link nl.stijngroenen.tradfri.util.ColourTemperatureHex}</li>
     * </ul>
     *
     * @param colourHex The new colour for the light
     * @since 1.0.0
     */
    public void setColourHex(String colourHex) {
        this.colourHex = colourHex;
    }

    /**
     * Set the hue of the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param hue The new hue for the light
     * @since 1.0.0
     */
    public void setHue(Integer hue) {
        this.hue = hue;
    }

    /**
     * Set the saturation of the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param saturation The new saturation for the light
     * @since 1.0.0
     */
    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    /**
     * Set the X value of the colour of the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param colourX The X value of the new colour for the light
     * @since 1.0.0
     */
    public void setColourX(Integer colourX) {
        this.colourX = colourX;
    }

    /**
     * Set the Y value of the colour of the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param colourY The Y value of the new colour for the light
     * @since 1.0.0
     */
    public void setColourY(Integer colourY) {
        this.colourY = colourY;
    }

    /**
     * Set the colour temperature of the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param colourTemperature The new colour temperature for the light
     * @since 1.0.0
     */
    public void setColourTemperature(Integer colourTemperature) {
        this.colourTemperature = colourTemperature;
    }

    /**
     * Set the transition time for updating the light within the LightProperties class<br>
     * <i>Note: This does not change the actual light</i>
     *
     * @param transitionTime The new transition time for updating the light
     * @since 1.0.0
     */
    public void setTransitionTime(Integer transitionTime) {
        this.transitionTime = transitionTime;
    }
}
