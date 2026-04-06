import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Robot> robotList = new ArrayList<>();

        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                String type = input[0];
                int id = Integer.parseInt(input[1]);
                String model = input[2];

                switch (type) {
                    case "DR":
                        robotList.add(new DroneRobot(model,id));
                        break;
                    case "FR":
                        robotList.add(new FishRobot(model,id));
                        break;
                    case "AR":
                        robotList.add(new AmphibiousRobot(model,id));
                        break;
                }
            }
        }


        for (int i = 0; i < robotList.size(); i++) {
            Robot robot = robotList.get(i);

            robot.performMainTask();

            if (robot instanceof Flyable) {
                ((Flyable) robot).fly();
            }
            if (robot instanceof Swimmable) {
                ((Swimmable) robot).swim();
            }
            if (robot instanceof GPS) {
                ((GPS) robot).getCoordinates();
            }

            if (i < robotList.size() - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }
}