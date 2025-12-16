// Custom Exception
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

// Product class
class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    // sifarisVer metodu
    public void sifarisVer(int say) throws OutOfStockException {
        if (say <= 0) {
            throw new IllegalArgumentException("Sifariş sayı mənfi və ya sıfır ola bilməz!");
        }
        if (say > stock) {
            throw new OutOfStockException("Anbarda məhsul bitib!");
        }
        stock -= say;
        System.out.println(say + " ədəd " + name + " sifariş edildi. Qalan stok: " + stock);
    }
}

// Main class
public class OnlineShop {
    public static void main(String[] args) {
        Product product = new Product("Telefon", 5);

        try {
            product.sifarisVer(3);  // düzgün sifariş
            product.sifarisVer(0);  // xətalı sifariş
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            product.sifarisVer(5);  // stokdan çox sifariş
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
