import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private Queue<Customer> queue = new LinkedList<>();
    public void addCustomer(Customer customer){
        queue.offer(customer);
    }
    public Customer servingCustomer(){
        if (queue.isEmpty()){
            System.out.println("khong con khach nao dang doi");
            return null;
        }
        Customer customer = queue.poll();
        System.out.println("dang xu li yeu cau cho khach hang "+customer.name);
        return customer;
    }
}
