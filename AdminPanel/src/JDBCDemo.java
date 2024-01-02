import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {
    static Scanner scanner = new Scanner(System.in);
    static String url="jdbc:mysql://localhost:3306/jdbcdemo";
    static String username="root";
    static String password="";
    public static void main(String[] args){
        System.out.println("---WELCOME TO THE ADMIN PANEL---\n\n");
        System.out.println(" 1. Product Management");
        System.out.println(" 2. User Management");
        int option=scanner.nextInt();
        switch (option){
            case 1:
            displayProductMenu();
        }
    }

    private static void displayProductMenu() {
        System.out.println("---PRODUCT MENU---");
        System.out.println("1. Display products");
        System.out.println("2. Add products");
        System.out.println("3. Delete products");
        int option=scanner.nextInt();
        switch (option){
            case 1:
                displayAllProducts();
            case 2:
                addProducts();
        }

    }

    private static void addProducts() {
        System.out.println("Enter the product name:");
        String productName = scanner.next();

        System.out.println("Enter the product quantity:");
        int productQuantity = scanner.nextInt();

        System.out.println("Enter the product price:");
        double productPrice = scanner.nextDouble();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            String insertQuery = "INSERT INTO producttable (name, quantity, price, date) VALUES (?, ?, ?, CURRENT_DATE)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, productQuantity);
            preparedStatement.setDouble(3, productPrice);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product added successfully!");

                // Retrieve the auto-generated ID
                var generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println("Generated ID: " + generatedId);
                }
            } else {
                System.out.println("Failed to add product.");
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    private static void displayAllProducts() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from student");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));

            }
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
