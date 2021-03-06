/*
Copyright (c) 2017 Anar Sultanov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.anarsultanov.airportmap.marker;

import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import de.fhpotsdam.unfolding.utils.MapPosition;
import processing.core.PGraphics;

import java.util.List;

/**
 * A class to represent RouteMarkers on a world map.
 *
 * @author Anar Sultanov
 */

public class RouteMarker extends SimpleLinesMarker {

    private static final int LINES = 5;

    public RouteMarker(List<Location> location, java.util.HashMap<java.lang.String, java.lang.Object> properties) {
        super(location, properties);
    }


    public void draw(PGraphics pg, List<MapPosition> mapPositions) {
        if (!hidden) {
            drawMarker(pg, mapPositions);
            if (selected) {
                showTitle(pg, mapPositions);
            }
        }
    }

    private void drawMarker(PGraphics pg, List<MapPosition> mapPositions) {
        pg.pushStyle();
        pg.strokeWeight(1);
        pg.stroke(0);
        pg.beginShape(LINES);
        for (MapPosition mapPosition : mapPositions) {
            pg.vertex(mapPosition.x, mapPosition.y);
        }
        pg.endShape();
        pg.popStyle();
    }

    private void showTitle(PGraphics pg, List<MapPosition> mapPositions) {
        pg.pushStyle();
        pg.fill(200);
        MapPosition positionOne = mapPositions.get(0);
        MapPosition positionTwo = mapPositions.get(1);
        float averageX = positionOne.x - positionTwo.x;
        float averageY = positionOne.y - positionTwo.y;
        pg.rect(averageX, averageY, 50, 50);
        pg.popStyle();
    }

}
