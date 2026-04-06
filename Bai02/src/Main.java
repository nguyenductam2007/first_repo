public class Main{
    public static void main(String[] args){
        CustomerQueue customerQueue = new CustomerQueue();
        Customer khachA = new Customer("C01","Alice");
        Customer khachB = new Customer("C02","Jack");
        customerQueue.addCustomer(khachA);
        customerQueue.addCustomer(khachB);

        Customer currentCustomer = customerQueue.servingCustomer();
        if (currentCustomer != null && currentCustomer.name.equals("Alice")){
            MessageHistory msg = new MessageHistory();
            msg.typeMessage(new Message("M01","Xin chao quy khach"));
            msg.typeMessage(new Message("M02","don hang dang duoc van chuyen"));
            msg.typeMessage(new Message("M03","du khien giao hang toi nay"));

            msg.viewLast();
            msg.Undo();
            msg.viewLast();
        }

        System.out.println("\nKhach hang tiep theo");
        currentCustomer = customerQueue.servingCustomer();
        if (currentCustomer != null && currentCustomer.name.equals("James")) {
            MessageHistory chatHistoryB = new MessageHistory();
            chatHistoryB.typeMessage(new Message("M04", "hello James,how can i help you"));
        }

        System.out.println("\n--- Nhân viên tiếp tục ấn nút xử lý ---");
        customerQueue.servingCustomer();

    }
}