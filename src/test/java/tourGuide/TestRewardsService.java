package tourGuide;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import org.junit.Before;
import org.junit.Test;
import tourGuide.service.gpsUtilService;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class TestRewardsService {

    @Before
    public void setLocale() {
        Locale.setDefault(Locale.US);
    }

    @Test
    public void isWithinAttractionProximity() {
        GpsUtil gpsUtil = new GpsUtil();
        gpsUtilService gpsUtilService = new gpsUtilService(gpsUtil);
        Attraction attraction = gpsUtil.getAttractions().get(0);
        assertTrue(gpsUtilService.near(attraction, attraction));
    }

}
