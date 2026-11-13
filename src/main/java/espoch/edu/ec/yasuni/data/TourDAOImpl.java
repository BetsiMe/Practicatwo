package espoch.edu.ec.yasuni.data;

import espoch.edu.ec.yasuni.access.TourDAO;
import espoch.edu.ec.yasuni.objects.Tour;

public class TourDAOImpl implements TourDAO {

    private Tour[] tours;
    private int count;

    public TourDAOImpl() {
        tours = new Tour[20];
        count = 0;
    }

    @Override
    public boolean registerTour(Tour tour) {

        if (tour == null
                || tour.getCode() == null
                || tour.getCode().trim().isEmpty()
                || count >= tours.length) {
            return false;
        }

        if (findTourByCode(tour.getCode()) != null) {
            return false;
        }

        tours[count] = tour;
        count++;

        return true;
    }

    @Override
    public Tour[] getAllTours() {

        Tour[] registeredTours = new Tour[count];

        for (int i = 0; i < count; i++) {
            registeredTours[i] = tours[i];
        }

        return registeredTours;
    }

    @Override
    public Tour findTourByCode(String code) {

        if (code == null || code.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < count; i++) {

            if (tours[i].getCode().equalsIgnoreCase(code)) {
                return tours[i];
            }
        }

        return null;
    }

    @Override
    public Tour[] orderByDistance() {

        Tour[] orderedTours = getAllTours();

        for (int i = 0; i < orderedTours.length - 1; i++) {

            for (int j = 0; j < orderedTours.length - 1 - i; j++) {

                if (orderedTours[j].calculateDistance()
                        > orderedTours[j + 1].calculateDistance()) {

                    Tour temp = orderedTours[j];

                    orderedTours[j] = orderedTours[j + 1];

                    orderedTours[j + 1] = temp;
                }
            }
        }

        return orderedTours;
    }

    @Override
    public Tour[] orderByDuration() {

        Tour[] orderedTours = getAllTours();

        for (int i = 0; i < orderedTours.length - 1; i++) {

            for (int j = 0; j < orderedTours.length - 1 - i; j++) {

                if (orderedTours[j].calculateDuration()
                        > orderedTours[j + 1].calculateDuration()) {

                    Tour temp = orderedTours[j];

                    orderedTours[j] = orderedTours[j + 1];

                    orderedTours[j + 1] = temp;
                }
            }
        }

        return orderedTours;
    }
}
