package com.example.dentalcareapp.app.utils;

import com.example.dentalcareapp.app.models.*;
import java.util.ArrayList;
import java.util.List;

public class DummyData {

    // Dummy Dentists
    public static List<Dentist> getDentists() {
        List<Dentist> dentists = new ArrayList<>();

        Dentist d1 = new Dentist("D001", "Dr. Farrel Athaillah Wijaya", "Ortodontis", 4.8f, "dentist_1");
        d1.setEducation("Universitas Sriwijaya");
        d1.setExperience("10 tahun");
        d1.setClinicName("Smile Dental Clinic");
        d1.setAvailability("Senin, Rabu, Jumat (09:00 - 15:00)");
        dentists.add(d1);

        Dentist d2 = new Dentist("D002", "Dr. Putri Alisya Zhafirah", "Bedah Mulut", 4.9f, "dentist_2");
        d2.setEducation("Universitas Sriwijaya");
        d2.setExperience("12 tahun");
        d2.setClinicName("Dental Care Center");
        d2.setAvailability("Senin, Kamis, Jumat (10:00 - 19:00)");
        dentists.add(d2);

        Dentist d3 = new Dentist("D003", "Dr. Hakan Ilyasa", "Dokter Gigi Umum", 5f, "dentist_3");
        d3.setEducation("Universitas Sriwijaya");
        d3.setExperience("20 tahun");
        d3.setClinicName("Happy Teeth Clinic");
        d3.setAvailability("Senin - Jum'at (08:00 - 15:00)");
        dentists.add(d3);

        Dentist d4 = new Dentist("D004", "Dr. Azka Hukma Tsabitah", "Periodonti", 4.9f, "dentist_4");
        d4.setEducation("Universitas Sriwijaya");
        d4.setExperience("15 tahun");
        d4.setClinicName("Elite Dental Care");
        d4.setAvailability("Senin, Rabu, Kamis, Jum'at (09:00 - 15:00)");
        dentists.add(d4);

        Dentist d5 = new Dentist("D005", "Dr. Thalia Dyah Zaneta", "Endodonti", 4.6f, "dentist_5");
        d5.setEducation("Universitas Sriwijaya");
        d5.setExperience("7 tahun");
        d5.setClinicName("Bright Smile Clinic");
        d5.setAvailability("Senin, Rabu, Kamis (09:00 - 14:00)");
        dentists.add(d5);

        return dentists;
    }

    // Dummy Appointments
    public static List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        Appointment a1 = new Appointment("A001", "Dr. Farrel Athaillah Wijaya", "25 Nov 2025", "10:00", "confirmed");
        a1.setClinicName("Smile Dental Clinic");
        a1.setNotes("Konsultasi pemasangan behel");
        appointments.add(a1);

        Appointment a2 = new Appointment("A002", "Dr. Putri Alisya Zhafirah", "28 Nov 2025", "14:00", "pending");
        a2.setClinicName("Dental Care Center");
        a2.setNotes("Cabut gigi bungsu");
        appointments.add(a2);

        Appointment a3 = new Appointment("A003", "Dr. Hakan Ilyasa", "15 Nov 2025", "09:00", "completed");
        a3.setClinicName("Happy Teeth Clinic");
        a3.setNotes("Pembersihan karang gigi");
        appointments.add(a3);

        return appointments;
    }

    // Dummy Products
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product("P001", "Pasta Gigi Whitening Pro", "Pasta Gigi", 45000, 4.7f, "toothpaste_1");
        p1.setDescription("Pasta gigi pemutih dengan teknologi micro-crystals yang ampuh mengangkat noda kuning pada gigi dalam 7 hari pemakaian rutin. Aman untuk enamel gigi.");
        products.add(p1);

        Product p2 = new Product("P002", "Sikat Gigi Elektrik SmartBrush", "Sikat Gigi", 350000, 4.9f, "toothbrush_1");
        p2.setDescription("Sikat gigi pintar dengan timer otomatis 2 menit dan sensor tekanan agar gusi tidak terluka. Baterai tahan hingga 30 hari.");
        products.add(p2);

        Product p3 = new Product("P003", "Benang Gigi Mint Fresh", "Benang Gigi", 25000, 4.5f, "floss_1");
        p3.setDescription("Benang gigi rasa mint yang kuat dan tidak mudah putus. Efektif membersihkan sisa makanan di sela-sela gigi yang sempit.");
        products.add(p3);

        Product p4 = new Product("P004", "Mouthwash Antibakteri 500ml", "Obat Kumur", 55000, 4.6f, "mouthwash_1");
        p4.setDescription("Obat kumur tanpa alkohol yang membunuh 99% kuman penyebab bau mulut. Memberikan kesegaran nafas sepanjang hari.");
        products.add(p4);

        Product p5 = new Product("P005", "Pasta Gigi Anak Rasa Strawberry", "Pasta Gigi", 30000, 4.8f, "toothpaste_2");
        p5.setDescription("Pasta gigi khusus anak dengan rasa buah yang disukai si kecil. Mengandung fluoride takaran rendah yang aman jika tertelan sedikit.");
        products.add(p5);

        return products;
    }


    // Dummy Clinics
    public static List<Clinic> getClinics() {
        List<Clinic> clinics = new ArrayList<>();

        Clinic c1 = new Clinic("C001", "Smile Dental Clinic",
                "Jl. Sudirman No. 123, Jakarta Pusat", "021-5551234",
                -6.2088, 106.8456);
        c1.setRating(4.8f);
        c1.setOpenHours("08:00 - 20:00");
        c1.setDistance(1.5);
        clinics.add(c1);

        Clinic c2 = new Clinic("C002", "Dental Care Center",
                "Jl. Thamrin No. 45, Jakarta Pusat", "021-5555678",
                -6.1944, 106.8229);
        c2.setRating(4.9f);
        c2.setOpenHours("09:00 - 21:00");
        c2.setDistance(2.3);
        clinics.add(c2);

        Clinic c3 = new Clinic("C003", "Happy Teeth Clinic",
                "Jl. Gatot Subroto No. 67, Jakarta Selatan", "021-5559012",
                -6.2297, 106.8253);
        c3.setRating(4.7f);
        c3.setOpenHours("08:00 - 18:00");
        c3.setDistance(3.1);
        clinics.add(c3);

        Clinic c4 = new Clinic("C004", "Elite Dental Care",
                "Jl. Kuningan No. 89, Jakarta Selatan", "021-5553456",
                -6.2382, 106.8311);
        c4.setRating(4.9f);
        c4.setOpenHours("10:00 - 22:00");
        c4.setDistance(4.2);
        clinics.add(c4);

        Clinic c5 = new Clinic("C005", "Bright Smile Clinic",
                "Jl. Rasuna Said No. 12, Jakarta Selatan", "021-5557890",
                -6.2236, 106.8412);
        c5.setRating(4.6f);
        c5.setOpenHours("08:00 - 19:00");
        c5.setDistance(2.8);
        clinics.add(c5);

        return clinics;
    }

    // Dental Tips
    public static List<String> getDentalTips() {
        List<String> tips = new ArrayList<>();
        tips.add("Sikat gigi minimal 2 kali sehari, pagi dan malam sebelum tidur");
        tips.add("Gunakan pasta gigi berfluoride untuk melindungi email gigi");
        tips.add("Ganti sikat gigi setiap 3-4 bulan sekali");
        tips.add("Gunakan benang gigi untuk membersihkan sela-sela gigi");
        tips.add("Batasi konsumsi makanan dan minuman manis");
        tips.add("Kunjungi dokter gigi minimal 6 bulan sekali");
        tips.add("Minum air putih setelah makan untuk membersihkan sisa makanan");
        tips.add("Hindari merokok untuk kesehatan gigi dan mulut");
        return tips;
    }

    // Educational Content
    public static List<String> getEducationalContent() {
        List<String> content = new ArrayList<>();
        content.add("Cara Menyikat Gigi yang Benar:\n1. Posisikan sikat 45° ke gusi\n2. Sikat dengan gerakan memutar\n3. Sikat semua permukaan gigi\n4. Sikat lidah untuk menghilangkan bakteri");
        content.add("Manfaat Flossing:\n- Membersihkan 40% permukaan gigi\n- Mencegah gigi berlubang\n- Mencegah penyakit gusi\n- Mencegah bau mulut");
        content.add("Makanan Sehat untuk Gigi:\n- Keju (kaya kalsium)\n- Apel (membersihkan gigi)\n- Wortel (merangsang air liur)\n- Susu (menguatkan email)");
        return content;
    }
}