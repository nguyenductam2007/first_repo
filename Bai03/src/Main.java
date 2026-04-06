public class Main{
    public static void main(String[] args) {
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5,5));
        //System.out.println(m.sum(5.5,5.5));
    }
}

//kết quả: Sẽ in ra 20.
// Đây là kết quả của tính Đa hình (Polymorphism) và cơ chế Dynamic Binding (Liên kết động) chạy lúc Runtime:
//Biến m có kiểu tham chiếu (Reference Type) là MathUtils.
//Tuy nhiên, đối tượng thực sự được tạo ra trên vùng nhớ Heap (Object Type) lại là AdvancedMath.
//Khi gọi m.sum(5, 5), Java compiler thấy lớp MathUtils có hàm sum(int, int) nên cho phép biên dịch. Nhưng khi chạy thực tế, máy ảo Java sẽ ưu tiên gọi phương thức sum đã bị Override (ghi đè) bên trong đối tượng thực tế là AdvancedMath. Do đó, nó chạy logic 5 + 5 + 10 = 20

//Bỏ comment dòng (B): Trình biên dịch chắc chắn sẽ báo lỗi (static binding)
//Khi bạn viết code, trình biên dịch (Compiler) chỉ nhìn vào Kiểu khai báo của biến (tức là MathUtils) để kiểm tra xem hàm đó có tồn tại hay không.
//Nó thấy m là kiểu MathUtils. Nó mở bản thiết kế của MathUtils ra xem và chỉ thấy đúng một hàm sum(int a, int b). Nó hoàn toàn không thấy hàm sum(double, double) (vì hàm này chỉ mới được định nghĩa thêm ở lớp con AdvancedMath).

