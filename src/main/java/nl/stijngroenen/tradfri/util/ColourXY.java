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

package nl.stijngroenen.tradfri.util;

/**
 * The class that contains XY values that make up a colour
 *
 * @author Stijn Groenen
 * @version 1.1.0
 */
public class ColourXY {

    /**
     * The x value of the colour
     */
    private Integer x;

    /**
     * The y value of the colour
     */
    private Integer y;

    /**
     * Construct the ColourXY class
     *
     * @param x The x value of the colour
     * @param y The y value of the colour
     * @since 1.1.0
     */
    public ColourXY(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Construct the ColourXY class
     *
     * @since 1.1.0
     */
    public ColourXY() {
    }

    /**
     * Get the X value of the colour
     *
     * @return The X value of the colour
     * @since 1.1.0
     */
    public Integer getX() {
        return this.x;
    }

    /**
     * Get the Y value of the colour
     *
     * @return The Y value of the colour
     * @since 1.1.0
     */
    public Integer getY() {
        return this.y;
    }

    /**
     * Set the x value of the colour
     *
     * @param x The new x value of the colour
     * @since 1.1.0
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * Set the y value of the colour
     *
     * @param y The new y value of the colour
     * @since 1.1.0
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Construct the ColourXY class from the {@link ColourRGB} class
     *
     * @param colourRGB The {@link ColourRGB} class
     * @return The ColourXY class
     * @since 1.1.0
     */
    public static ColourXY fromRGB(ColourRGB colourRGB) {
        return colourRGB.toXY();
    }
}
