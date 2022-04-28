package tourGuide.resources;

import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tourGuide.service.gpsUtilService;

import java.util.List;

@RestController
public class gpsController {

    @Autowired
    gpsUtilService gpsUtilService;

    @GetMapping("/setProximityBuffer/{buffer}")
    public void setProximityBuffer(@PathVariable int buffer) {
        gpsUtilService.setProximityBuffer(buffer);
    }

    @GetMapping("/getAttractions")
    public List<Attraction> getAttractions() {
        return gpsUtilService.getAttractions();
    }

    @GetMapping("/getVisitedLocation/{id}")
    public VisitedLocation getVisitedLocation(@PathVariable String id) {
        return gpsUtilService.getVisitedLocation(id);
    }

    @GetMapping("/getDistance")
    public double getDistance(@RequestParam double lat1, @RequestParam double long1,
                        @RequestParam double lat2, @RequestParam double long2) {
        Location loc1 = new Location(lat1, long1);
        Location loc2 = new Location(lat2, long2);
        return gpsUtilService.getDistance(loc1, loc2);
    }

    @GetMapping("/near")
    public boolean near(@RequestParam double lat1, @RequestParam double long1,
                        @RequestParam double lat2, @RequestParam double long2,
                        @RequestParam int proximityBuffer) {
        Location loc1 = new Location(lat1, long1);
        Location loc2 = new Location(lat2, long2);
        return gpsUtilService.near(loc1, loc2, proximityBuffer);
    }

}
