
package espoch.edu.ec.yasuni;

import espoch.edu.ec.yasuni.data.TourDAOImpl;
import espoch.edu.ec.yasuni.data.DifficultyService;
import espoch.edu.ec.yasuni.data.TourService;

import espoch.edu.ec.yasuni.objects.Tour;
import espoch.edu.ec.yasuni.objects.RegularTour;
import espoch.edu.ec.yasuni.objects.InterpretiveTour;
import espoch.edu.ec.yasuni.objects.Trail;
import espoch.edu.ec.yasuni.objects.Guide;
import espoch.edu.ec.yasuni.objects.CommunicationDevice;

import java.util.Scanner;

public class Yasuni {

    public static void main(String[] args) {

        TourDAOImpl dao = new TourDAOImpl();
        TourService tourService = new TourService();
        DifficultyService difficultyService = new DifficultyService();
        Scanner scanner = new Scanner(System.in);

        Tour tour1 = new RegularTour("T001", "Sendero Verde");

        Tour tour2 = new InterpretiveTour(
                "T002", "Ruta Interpretativa", 30);

        Tour tour3 = new RegularTour("T003", "Sendero Azul");

        Trail trail1 = new Trail("Sendero 1", 5, 60);
        Trail trail2 = new Trail("Sendero 2", 3, 40);
        Trail trail3 = new Trail("Sendero 3", 8, 90);

        System.out.println("ASIGNACIÓN DE SENDEROS");

        System.out.println("Sendero 1: " + tour1.addTrail(trail1));
        System.out.println("Sendero 2: " + tour2.addTrail(trail2));
        System.out.println("Sendero 3: " + tour3.addTrail(trail3));

        System.out.println("\nPRUEBA DE PROPIEDAD");

        System.out.println("Intentar compartir Sendero 1: "
                + tour2.addTrail(trail1));

        System.out.println("\nPRUEBA DE CIERRE DE SENDEROS");

        System.out.println("Distancia antes del cierre: "
                + tour1.calculateDistance() + " km");

        System.out.println("Tiempo antes del cierre: "
                + tour1.calculateDuration() + " minutos");

        System.out.println("Cerrar Sendero 1: "
                + tour1.closeTrail(trail1));

        System.out.println("Distancia después del cierre: "
                + tour1.calculateDistance() + " km");

        System.out.println("Tiempo después del cierre: "
                + tour1.calculateDuration() + " minutos");

        System.out.println("\nAUMENTO DEL FACTOR DE DIFICULTAD");

        double currentFactor = tour2.getDifficultyFactor();
        double percentage;

        do {
            System.out.print("Ingrese el porcentaje de aumento: ");
            percentage = scanner.nextDouble();

            if (!Double.isFinite(percentage) || percentage < 0) {
                System.out.println("Ingrese un porcentaje válido.");
            }

        } while (!Double.isFinite(percentage) || percentage < 0);

        double newFactor = difficultyService.simulateIncrease(
                currentFactor, percentage);

        System.out.println("Factor actual: " + currentFactor);
        System.out.println("Nuevo factor propuesto: " + newFactor);

        int option;

        do {
            System.out.print(
                    "¿Desea aceptar el cambio? (1 = Si / 0 = No): ");

            option = scanner.nextInt();

            if (option != 1 && option != 0) {
                System.out.println(
                        "Opción no válida. Intente nuevamente.");
            }

        } while (option != 1 && option != 0);

        if (option == 1) {
            tour2.setDifficultyFactor(newFactor);
            System.out.println("Factor actualizado correctamente.");
        } else {
            System.out.println("Se mantiene el factor anterior.");
        }

        System.out.println("Duración actual del tour: "
                + tour2.calculateDuration() + " minutos");
        Guide guide1 = new Guide("G001", "Carlos", true);
        Guide guide2 = new Guide("G002", "María", true);
        Guide guide3 = new Guide("G003", "Pedro", true);

        CommunicationDevice device1 = new CommunicationDevice(
                "D001", "Radio portátil 1", true);

        CommunicationDevice device2 = new CommunicationDevice(
                "D002", "Radio portátil 2", true);

        CommunicationDevice device3 = new CommunicationDevice(
                "D003", "Radio portátil 3", true);

        System.out.println("\nASIGNACIÓN DE RECURSOS");

        System.out.println("Tour 1: "
                + tourService.assignResources(tour1, guide1, device1));

        System.out.println("Tour 2: "
                + tourService.assignResources(tour2, guide2, device2));

        System.out.println("Tour 3: "
                + tourService.assignResources(tour3, guide3, device3));

        System.out.println("\nPRUEBA DE ASIGNACIÓN ATÓMICA");

        Tour tour4 = new RegularTour(
                "T004", "Sendero de Prueba");

        CommunicationDevice device4 = new CommunicationDevice(
                "D004", "Radio portátil 4", true);

        System.out.println("Intentar usar un guía ocupado: "
                + tourService.assignResources(tour4, guide1, device4));

        System.out.println("Guía asignado al Tour 4: "
                + (tour4.getGuide() != null));

        System.out.println("Dispositivo asignado al Tour 4: "
                + (tour4.getDevice() != null));

        System.out.println("Disponibilidad del dispositivo 4: "
                + device4.isAvailable());

        System.out.println("\nPRUEBA DE DISPOSITIVO OCUPADO");

        Tour tour5 = new RegularTour(
                "T005", "Sendero de Prueba 2");

        Guide guide4 = new Guide("G004", "Ana", true);

        System.out.println("Intentar usar un dispositivo ocupado: "
                + tourService.assignResources(tour5, guide4, device1));

        System.out.println("Guía asignado: "
                + (tour5.getGuide() != null));

        System.out.println("Dispositivo asignado: "
                + (tour5.getDevice() != null));

        System.out.println("Disponibilidad del guía: "
                + guide4.isAvailable());

        System.out.println("\nREGISTRO DE TOURS");

        System.out.println("Tour 1: " + dao.registerTour(tour1));
        System.out.println("Tour 2: " + dao.registerTour(tour2));
        System.out.println("Tour 3: " + dao.registerTour(tour3));

        System.out.println("\nTOURS REGISTRADOS");

        for (Tour tour : dao.getAllTours()) {
            System.out.println(
                    tour.getCode() + " - " + tour.getName());
        }

        System.out.println("\nBUSCAR TOUR T002");

        Tour foundTour = dao.findTourByCode("T002");

        if (foundTour != null) {
            System.out.println("Encontrado: " + foundTour.getName());
        } else {
            System.out.println("Tour no encontrado");
        }

        System.out.println("\nORDENADOS POR DISTANCIA");

        for (Tour tour : dao.orderByDistance()) {
            System.out.println(
                    tour.getName() + " - "
                    + tour.calculateDistance() + " km");
        }

        System.out.println("\nORDENADOS POR DURACIÓN");

        for (Tour tour : dao.orderByDuration()) {
            System.out.println(
                    tour.getName() + " - "
                    + tour.calculateDuration() + " minutos");
        }

        scanner.close();
    }
}
