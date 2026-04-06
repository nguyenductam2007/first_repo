public class AmphibiousRobot extends Robot implements Swimmable,Flyable,GPS{
    public AmphibiousRobot(String modelName, int id){
        super(id, modelName);
    }
    @Override
    public void performMainTask(){
        System.out.println("nhiem vu: hoat dong o moi dia hinh");
    }
    @Override
    public void swim(){
        System.out.println("dang tham hiem duoi mat nuoc");
    }
    @Override
    public void fly(){
        System.out.println("dang do tham tren khong");
    }
    @Override
    public void getCoordinates(){
        System.out.println("dang lay toa do");
    }
}
