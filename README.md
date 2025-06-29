# 📦 E-Commerce Warehouse Console Application

This is a **Java console-based CRUD application** that simulates a simple inventory management system for an e-commerce warehouse.

It allows users to:

- Add new products
- Update existing products
- Delete products
- Search products by price
- View all products
- Calculate total inventory value

---

## 🛠️ Technologies Used

- Java 8 or above
- Java Collections (`ArrayList`)
- Stream API
- Lambda Expressions
- IntelliJ IDEA (or any other Java IDE)

---

## 📁 Project Structure
```
src/
├── Product.java
├── WarehouseManager.java
└── MainApp.java
```

## 🔧 Features

- ✅ Create product entries (ID, name, price, quantity)
- ✅ Read/view all existing products
- ✅ Update product by ID (with confirmation)
- ✅ Delete product by ID (with confirmation)
- ✅ Prevent duplicate product IDs
- ✅ Search products under a given max price
- ✅ Handle invalid inputs gracefully
- ✅ Calculate total inventory value using Stream API

---

```
Welcome to Warehouse Inventory Menu
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Price
6. Calculate Inventory Value
7. Exit

Enter your choice: 1
Enter ID: 101
Enter Name: Mouse
Enter Price: 499.99
Enter Quantity: 10
✅ Product added successfully.
```
