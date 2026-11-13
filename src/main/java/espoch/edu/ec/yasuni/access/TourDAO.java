package espoch.edu.ec.yasuni.access;

import espoch.edu.ec.yasuni.objects.Tour;

public interface TourDAO {

    boolean registerTour(Tour tour);

    Tour[] getAllTours();

    Tour findTourByCode(String code);

    Tour[] orderByDistance();

    Tour[] orderByDuration();
}