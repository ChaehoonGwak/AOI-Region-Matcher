package com.sia.assignment.common;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class TypeConversion {

    public static Geometry wktToGeometry(String wellKnownText) throws ParseException {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        geom = fromText.read(wellKnownText);
        System.out.println(geom);
        System.out.println(geom.getClass());
        return geom;
    }

}
