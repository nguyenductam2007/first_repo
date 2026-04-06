import java.util.Stack;

public class MessageHistory {
    private Stack<Message> stack = new Stack<>();
    public void typeMessage(Message msg){
        stack.push(msg);
    }

    public void Undo(){
        if (!stack.isEmpty()){
            Message removedmsg = stack.pop();
            System.out.println("da xoa tin nhan :" +removedmsg.toString());
        }
        else{
            System.out.println("khong co tin nhan nao de thu hoi");
        }
    }
    public void viewLast(){
        if (!stack.isEmpty()){
            Message lastmsg = stack.peek();
            System.out.println("tin nhan gan nhat: "+lastmsg.toString());
        }
        else{
            System.out.println("lich su tin nhan trong");
        }
    }
}
