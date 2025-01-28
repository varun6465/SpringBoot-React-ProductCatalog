import { useEffect, useState } from 'react';
import './App.css';
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState(null);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");




  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => setProducts(data))
      .catch(error => {
        console.error('Error fetching products:', error);
        setError(error.message);
      });
      fetch('http://localhost:8080/api/categories')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => setCategories(data))
      .catch(error => {
        console.error('Error fetching categories:', error);
        setError(error.message);
      });
  }, []);

  const handleSearchChange = (event) =>{
    setSearchTerm(event.target.value);
  };

  const handleSortChange = (event)=>{
    setSortOrder(event.target.value);
  }
  const handleCategorySelect = (categoryId) =>{
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  }

  const filteredProducts = products
  .filter(product => {
    return (
      (selectedCategory ? product.category.id === selectedCategory : true) &&
      product.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
  })
  .sort((a, b) => {
    if (sortOrder === "asc") { // Fix here: use sortOrder instead of SortOrder
      return a.price - b.price;
    } else {
      return b.price - a.price;
    }
  });


  return (
    <div className="container">
      <h1 className='my-4'>Product catalog</h1>

      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-m-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>

        </div>
        <div className='col-md-5 col-sm-12 mb-2'>
          <input type='text' className='form-control' 
          placeholder='search for products'
          onChange={handleSearchChange} />
        </div>
        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value="asc">Sort By Price : Low to High</option>
            <option value="desc">Sort By Price : High to Low</option>

          </select>

        </div>
      </div>

  {filteredProducts.length ? (
    <ProductList products={filteredProducts} />
  ) : (
    <p>No Products Found</p>
  )}
</div>
  );
}

export default App;