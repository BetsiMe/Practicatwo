
package espoch.edu.ec.yasuni.data;

import espoch.edu.ec.yasuni.objects.Tour;
import espoch.edu.ec.yasuni.objects.Guide;
import espoch.edu.ec.yasuni.objects.CommunicationDevice;

public class TourService {

    public boolean assignResources(
            Tour tour,
            Guide guide,
            CommunicationDevice device) {

        if (tour == null || guide == null || device == null) {
            return false;
        }

        if (tour.getGuide() != null || tour.getDevice() != null) {
            return false;
        }

        if (!guide.isAvailable() || !device.isAvailable()) {
            return false;
        }

        tour.setGuide(guide);
        tour.setDevice(device);

        guide.setAvailable(false);
        device.setAvailable(false);

        return true;
    }
}
