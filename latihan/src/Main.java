import java.util.Scanner;

class BookIDException extends Exception {
    public BookIDException(String message) {
        super(message);
    }
}

class LoanDurationException extends Exception {
    public LoanDurationException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] books = {"B001", "B002", "B003"};

        try {
            System.out.print("Masukkan Nama Anda: ");
            String name = scanner.nextLine();

            System.out.print("Masukkan ID Buku: ");
            String id = scanner.nextLine();

            boolean validID = false;
            for (String b : books) {
                if (b.equalsIgnoreCase(id)) {
                    validID = true;
                    break;
                }
            }

            if (!validID) {
                throw new BookIDException("ID Buku tidak ditemukan.");
            }

            System.out.print("Masukkan lama peminjaman (hari): ");
            int days = scanner.nextInt();
            if (days < 1 || days > 14) {
                throw new LoanDurationException("Lama peminjaman harus antara 1-14 hari.");
            }

            System.out.println("Peminjaman berhasil untuk " + name + " dengan ID Buku " + id + " selama " + days + " hari.");
        } catch (BookIDException | LoanDurationException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input tidak valid: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program selesai.");
        }
    }
}
