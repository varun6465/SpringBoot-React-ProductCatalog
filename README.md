# Product Catalog App

A **full-stack product catalog application** built with **Spring Boot** and **React.js**. This application provides a simple interface to display products, filter by categories, search, and sort products by price. It's designed as a dynamic e-commerce catalog with data pre-seeded using a Spring Boot `DataSeeder` component.

---

## Features

- **Backend:** Spring Boot RESTful API to manage products and categories.
- **Frontend:** React.js for an interactive and responsive UI.
- **Filtering:** Filter products by categories.
- **Search:** Search products by name.
- **Sorting:** Sort products by price (Low to High or High to Low).
- **Data Seeder:** Automatically seeds sample product and category data into the database.

---

## Tech Stack

### Backend:
- **Spring Boot**
- **JPA (Hibernate)** for ORM
- **MySQL** as the database

### Frontend:
- **React.js**
- **Bootstrap 5** for styling

---

## Installation and Setup

### Prerequisites
1. **Java 17+**
2. **Node.js** and **npm**
3. **MySQL**
4. **Maven**

### Steps to Run the Application

#### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Product-Catalog-App.git
   cd Product-Catalog-App
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/product-catalog
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```
3. Run the backend application:
   ```bash
   ./mvnw spring-boot:run
   ```

#### Frontend Setup
1. Navigate to the `frontend` directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the React development server:
   ```bash
   npm start
   ```

### Access the Application
- Open your browser and navigate to:
  ```
  http://localhost:3000
  ```

---

## API Endpoints

### Products
- `GET /api/products`: Fetch all products.
- `GET /api/products/category/{categoryId}`: Fetch products by category ID.

### Categories
- `GET /api/categories`: Fetch all categories.

---

## Sample Data
The `DataSeeder` component seeds the following categories and products:

### Categories:
1. **Electronics**
2. **Clothing**
3. **Home and Kitchen**

### Products:
- **Phone** (Category: Electronics)
- **Laptop** (Category: Electronics)
- **Jacket** (Category: Clothing)
- **Mixer** (Category: Home and Kitchen)

---

## Future Enhancements
1. **User Authentication:** Add login and signup functionality.
2. **Cart Functionality:** Allow users to add products to a cart.
3. **Pagination:** Handle large datasets efficiently.
4. **Admin Panel:** Allow admins to manage products and categories.

---

## Contributing
Contributions are welcome! Feel free to open issues or submit pull requests.

---

## License
This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## Contact
For any queries, reach out at:
- **Email:** [varunkrishnarupani.5180@gmail.com](mailto:varunkrishnarupani.5180@gmail.com)
- **LinkedIn:** [linkedin.com/in/varunrupani6465](https://linkedin.com/in/varunrupani6465)
- **GitHub:** [github.com/varun6465](https://github.com/varun6465)
