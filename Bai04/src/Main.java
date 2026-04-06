public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();

        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("this is not a Cat");
        }
    }
}

//Trình biên dịch Compiler sẽ cho pass. Lý do là vì lúc này nó chỉ kiểm tra dựa trên kiểu khai báo. Nó thấy biến a có kiểu Animal, và Cat là một lớp con của Animal. Do đó, về mặt logic cú pháp, việc ép một Animal về Cat là điều có thể xảy ra hợp lệ, nên nó cho phép biên dịch
//Có lỗi. Chương trình sẽ bị crash ngay lập tức tại dòng Bước 2. Tên lỗi xuất hiện trên console là: java.lang.ClassCastException
//Nguyên nhân :khi chạy, máy ảo Java sẽ kiểm tra đối tượng thực sự nằm trong vùng nhớ heap. Nó phát hiện ra a đang giữ một con Chó (Dog). Chó và Mèo là hai lớp anh em (cùng cha Animal) chứ không có quan hệ cha-con với nhau, nên không thể biến Chó thành Mèo được

