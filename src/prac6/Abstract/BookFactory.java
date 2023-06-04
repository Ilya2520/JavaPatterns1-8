package prac6.Abstract;

interface Softcover{}
interface Hardcover{}

class SoftWarAndPeace implements Softcover{
}

class HardWarAndPeace implements Hardcover{
}

public interface BookFactory {
    Hardcover createHardcover();
    Softcover createSoftcover();

    static void main(String[] args) {
        BookFactory a = new WarAndPeaceFactory();
        a.createHardcover();
        a.createSoftcover();
    }
}

class WarAndPeaceFactory implements BookFactory{

    @Override
    public Hardcover createHardcover() {
        System.out.println("Книга 'Война и мир' была напечатана в твердом переплёте");
        return new HardWarAndPeace();
    }

    @Override
    public Softcover createSoftcover() {
        System.out.println("Книга 'Война и мир' была напечатана в мягком переплёте");
        return new SoftWarAndPeace();
    }
}

