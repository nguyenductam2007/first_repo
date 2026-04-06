public class FishRobot extends Robot implements Swimmable {
    public FishRobot(String modelName,int id){
        super(id, modelName);
    }
    @Override
    public void performMainTask(){
        System.out.println("nhiem vu: kham pha dai duong");
    }
    @Override
    public void swim(){
        System.out.println("robot dang boi");
    }
}
