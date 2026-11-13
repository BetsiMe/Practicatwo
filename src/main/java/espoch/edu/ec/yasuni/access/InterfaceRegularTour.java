
package espoch.edu.ec.yasuni.access;

import espoch.edu.ec.yasuni.objects.RegularTour;


public interface InterfaceRegularTour {

    public double distance(RegularTour regularTour);

    public boolean orderRuteTime(RegularTour regularTour);

    public boolean orderRuteDistance(RegularTour regularTour);
}
