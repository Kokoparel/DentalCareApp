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
        dentists.add(d1);

        Dentist d2 = new Dentist("D002", "Dr. Putri Alisya Zhafirah", "Bedah Mulut", 4.9f, "dentist_2");
        d2.setEducation("Universitas Sriwijaya");
        d2.setExperience("12 tahun");
        d2.setClinicName("Dental Care Center");
        dentists.add(d2);

        Dentist d3 = new Dentist("D003", "Dr. Hakan Ilyasa", "Dokter Gigi Umum", 4.7f, "dentist_3");
        d3.setEducation("Universitas Sriwijaya");
        d3.setExperience("8 tahun");
        d3.setClinicName("Happy Teeth Clinic");
        dentists.add(d3);

        Dentist d4 = new Dentist("D004", "Dr. Azka Hukma Tsabitah", "Periodonti", 4.9f, "dentist_4");
        d4.setEducation("Universitas Sriwijaya");
        d4.setExperience("15 tahun");
        d4.setClinicName("Elite Dental Care");
        dentists.add(d4);

        Dentist d5 = new Dentist("D005", "Dr. Thalia Dyah Zaneta", "Endodonti", 4.6f, "dentist_5");
        d5.setEducation("Universitas Sriwijaya");
        d5.setExperience("7 tahun");
        d5.setClinicName("Bright Smile Clinic");
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

        products.add(new Product("P001", "Pasta Gigi Whitening Pro",
                "Pasta Gigi", 45000, 4.7f, "toothpaste_1"));

        products.add(new Product("P002", "Sikat Gigi Elektrik SmartBrush",
                "Sikat Gigi", 350000, 4.9f, "toothbrush_1"));

        products.add(new Product("P003", "Benang Gigi Mint Fresh",
                "Benang Gigi", 25000, 4.5f, "floss_1"));

        products.add(new Product("P004", "Mouthwash Antibakteri 500ml",
                "Obat Kumur", 55000, 4.6f, "mouthwash_1"));

        products.add(new Product("P005", "Pasta Gigi Anak Rasa Strawberry",
                "Pasta Gigi", 30000, 4.8f, "toothpaste_2"));

        products.add(new Product("P006", "Sikat Gigi Bamboo Eco-Friendly",
                "Sikat Gigi", 40000, 4.7f, "toothbrush_2"));

        products.add(new Product("P007", "Tongue Cleaner Stainless",
                "Pembersih Lidah", 20000, 4.4f, "tongue_cleaner"));

        products.add(new Product("P008", "Dental Floss Picks 50pcs",
                "Benang Gigi", 35000, 4.6f, "floss_2"));

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