public abstract class Robot {
    private int id,batteryLevel;
    private String modelName;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public void chargeBattery(){
        batteryLevel = 100;
    }
    public String getModelName(){
        return modelName;
    }
    public int getId(){
        return id;
    }
    public final void showIdentity(){
        System.out.println("Model: "+getModelName()+" |ID: "+id);
    }
    public abstract void performMainTask();
}
