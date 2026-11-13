
package espoch.edu.ec.yasuni.access;

import espoch.edu.ec.yasuni.objects.InterpretiveTour;


public interface InterfaceInterpretiveTour {

    public double distance(InterpretiveTour interpretiveTour);

    public boolean orderRuteTime(InterpretiveTour interpretiveTour);

    public boolean orderRuteDistance(InterpretiveTour interpretiveTour);
}
