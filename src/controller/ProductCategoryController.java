package controller;

import db.objects.Category;
import java.util.ArrayList;
import model.CategoriesModel;
import model.ProductsModel;

public class ProductCategoryController {
    public static String getCategoryNameByID(int id) {
        CategoriesModel categoriesModel = new CategoriesModel();
        try {
            return CategoriesModel.takeObject(categoriesModel.selectWithCondition("CategoryID = " + id)).get(0).getCategoryName();
        } catch (Exception e) {
        }
        return "";
    }
    
    public static int getNumProductBelong(int categoryID) {
        ProductsModel productsModel = new ProductsModel();
        try {
            return Integer.parseInt(productsModel.selectTop("COUNT(*)", 1, "WHERE CategoryID = " + categoryID).get(0)[0]);
        } catch (Exception e) {
        }
        return 0;
    }
    
    public static ArrayList<Category> getCategories(String name) {
        CategoriesModel categoriesModel = new CategoriesModel();
        return CategoriesModel.takeObject(categoriesModel.selectWithCondition("CategoryName LIKE '%" +  name + "%'"));
    }
    
    public static Category getCategoryByID(int id) {
        CategoriesModel categoriesModel = new CategoriesModel();
        try {
            return CategoriesModel.takeObject(categoriesModel.selectWithCondition("CategoryID = " + id)).get(0);
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public static boolean addOneProduct(int categoryID, String productName, int price, int discount, String unitPerQuantity, String description) {
        ProductsModel productsModel = new ProductsModel();
        return productsModel.insertOne(String.format(
                "%d, '%s', %d, '%s', %f, %d, '%s'",
                categoryID,
                productName,
                price,
                description,
                discount/100F,
                0,
                unitPerQuantity
        ));
    }
    
    public static boolean editProduct(int productID, int categoryID, String productName, int price, int discount, String unitPerQuantity, String description) {
        ProductsModel productsModel = new ProductsModel();
        return productsModel.update(
                String.format(
                        "CategoryID = %d, ProductName = '%s', Price = %d, Discount = %f, UnitPerQuantity = '%s', Description = '%s'",
                        categoryID,
                        productName,
                        price,
                        discount/100F,
                        unitPerQuantity,
                        description
                ), 
                "ProductID = " + productID
        );
    }
    
    public static boolean addOneCategory(String name, String description) {
        CategoriesModel categoriesModel = new CategoriesModel();
        return categoriesModel.insertOne(String.format(
                "'%s', '%s'",
                name,
                description
        ));
    }
    
    public static boolean editCategory(String name, String description, int id) {
        CategoriesModel categoriesModel = new CategoriesModel();
        return categoriesModel.update(
                String.format(
                        "CategoryName = '%s', Description = '%s'",
                        name,
                        description
                ), 
                "CategoryID = " + id
        );
    }
}
