package edu.upvictoria.poo.Lib.Repositories;

public class DoctorRepository extends UserRepository {
    public static void main(String[] args) {
        var test = new DoctorRepository("src/main/resources/main.db");
        try {
            var arr = test.getUsers("DOCTOR");
            for (var item : arr) {
                System.out.println(item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public DoctorRepository(String path) {
        super(path);
    }

}
