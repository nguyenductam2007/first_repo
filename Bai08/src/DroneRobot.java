public class DroneRobot extends Robot implements Flyable,GPS{
    public DroneRobot(String modelName, int id){
        super(id, modelName);
    }

    @Override
    public void performMainTask(){
        System.out.println("nhiem vu: giao hang tren khong");
    }
    @Override
    public void fly(){
        System.out.println("robot dang bay");
    }
    @Override
    public void getCoordinates(){
        System.out.println("dang su dung gps");
    }

}
