package tourGuide.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class gpsUtilService {
    private static final double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;

    private final GpsUtil gpsUtil;

    // proximity in miles
    private int defaultProximityBuffer = 10;
    private int proximityBuffer = defaultProximityBuffer;
    private int attractionProximityRange = 200;

    public gpsUtilService(GpsUtil gpsUtil) {
        this.gpsUtil = gpsUtil;
    }

    public List<Attraction> getAttractions() {
        return gpsUtil.getAttractions();
    }

    public VisitedLocation getVisitedLocation(String userID) {
        return gpsUtil.getUserLocation(UUID.fromString(userID));
    }

    public boolean near(Location loc1, Location loc2) {
        return getDistance(loc1, loc2) > proximityBuffer ? false : true;
    }

    public double getDistance(Location loc1, Location loc2) {
        double lat1 = Math.toRadians(loc1.latitude);
        double lon1 = Math.toRadians(loc1.longitude);
        double lat2 = Math.toRadians(loc2.latitude);
        double lon2 = Math.toRadians(loc2.longitude);

        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        double nauticalMiles = 60 * Math.toDegrees(angle);
        double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteMiles;
    }
}
