package db.objects;

public class Category {
    private int categoryID;
    private String categoryName;
    private String description;

    public Category(int categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }
    
    public Category(String[] fields) {
        categoryID = Integer.parseInt(fields[0]);
        categoryName = fields[1];
        description = fields[2];
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryID=" + categoryID + ", categoryName=" + categoryName + ", description=" + description + '}';
    }
    
    
}
