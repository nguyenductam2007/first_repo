public class Main{
    public static void main(String[] args){
        Animal[] zoo = new Animal[4];
        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Duck();
        zoo[3] = new Dog();

        for (int i = 0; i<4;i++){
            zoo[i].makeSound();
        }

    }
}
//Khi lớp Duck dùng từ khóa extends Animal (kế thừa từ lớp Animal), nó tự động được hưởng tất cả các thuộc tính và phương thức (hàm) của lớp cha. Nghĩa là ngầm định bên trong lớp Duck đã có sẵn hàm makeSound() in ra "Animal sound".
//Khác với Dog hay Cat, lớp Duck của bạn không ghi đè (override) hàm này. Nó không tự định nghĩa lại một cách kêu riêng của mình (như "Quack quack").