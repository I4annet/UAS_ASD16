package Tugas17_UAS;
import java.util.Scanner;
import Tugas17_UAS.Kendaraan.TranskasiPajak;

public class Node {
    Node prev;
    Node next;
    TranskasiPajak data;

    public Node(TranskasiPajak data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

 class Kendaraan {
    Node prev;
    Node next;
    String noTNKB;
    String nama;
    String jenis;
    int cc;
    int tahun;
    int bulanHarusBayar;

    public Kendaraan(Node prev,String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar,Node next) {
        this.prev = prev;
        this.noTNKB = noTNKB;
        this.nama = nama;
        this.jenis = jenis;
        this.cc = cc;
        this.tahun = tahun;
        this.bulanHarusBayar = bulanHarusBayar;
        this.next = next;

    }
    class TranskasiPajak {
        int kode;
        long nominalBayar;
        long denda;
        int bulanBayar;
        Kendaraan kendaraan;
    
        public TranskasiPajak(int kode, long nominalBayar, long denda, int bulanBayar, Kendaraan kendaraan) {
            this.kode = kode;
            this.nominalBayar = nominalBayar;
            this.denda = denda;
            this.bulanBayar = bulanBayar;
            this.kendaraan = kendaraan;
        }
    }
}

 class DoubleLinkedList {
    Node head;
    Node tail;
    int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    } 

        public void add(TranskasiPajak data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        
        public int size() {
            return size;
        }

        public long hitungNominalBayar(Kendaraan kendaraan) {
            long nominal = 0;
            if (kendaraan.jenis.equals("Motor")) {
                if (kendaraan.cc < 100) {
                    nominal = 100000;
                } else if (kendaraan.cc <= 250) {
                    nominal = 250000;
                } else {
                    nominal = 500000;
                }
            } else if (kendaraan.jenis.equals("Mobil")) {
                if (kendaraan.cc < 1000) {
                    nominal = 750000;
                } else if (kendaraan.cc <= 2500) {
                    nominal = 1000000;
                } else {
                    nominal = 1500000;
                }
            }
            return nominal;
        }
        public void display() {
            if (head == null) {
                System.out.println("Belum ada transaksi.");
                return;
            }
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

    public boolean isEmpty() {
       return head == null;
    }
    
    public void add(TransaksiPajak data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        if (head == null) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void addFirst(TransaksiPajak data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(TransaksiPajak data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public void remove() {
        if (head == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        Node temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        System.out.println("Data removed: " + temp.data);
    }

    public void printDaftarKendaraan() {
        Node current = head;
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("Daftar Transaksi Pembayaran Pajak ");
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("| No. | Nama Pemilik | Nominal Bayar | Denda |");
        while (current != null) {
            System.out.printf("| %-3d | %-12s | %-12d | %-6d |\n", current.data.kode, current.data.kendaraan.nama, current.data.nominalBayar, current.data.denda);
            current = current.next;
        }
        System.out.println("Sisa antrian: " + size);
    }

    public void printTransaksi() {
        display();
    }



 class Main {
    
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
        System.out.println("1. Daftar Kendaraan");
        System.out.println("2. Bayar Pajak");
        System.out.println("3. Tampilkan seluruh transaksi");
        System.out.println("4. Urutkan Transaksi berdasar nama pemilik");
        System.out.println("5. Keluar");
        System.out.println("Pilih (1-5): ");
        int pilih = sc.nextInt();

        switch (pilih) {
            case 1:
                
                break;
            case 2:

            break;

            case 3:

            break;

            case 4:

            break;

            case 5:

            break;
        
            default:
                break;
        }

    }
}
