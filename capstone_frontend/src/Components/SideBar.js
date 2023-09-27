import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./SideBar.css"
import { useScroll } from "framer-motion";
// import fetchProductsCategory from "../Containers/Container.js"

const SideBar = ({isOpen, toggleSidebar, setProducts}) => {
  const navigate = useNavigate();

const fetchProductsCategory = async (category) => {
    const response = await fetch(`http://localhost:8080/products/category=${category}`);
    const data = await response.json()
    setProducts(data);
}
const fetchProductsRating = async (rating) => {
    const response = await fetch(`http://localhost:8080/products/rating=${rating}`);
    const data = await response.json()
    setProducts(data);
}

const [number, setNumber] = useState(0)

  const sidebarClass = isOpen ? "sidebar open" : "sidebar";
  return (
    <div className={sidebarClass}>
        <div className="slidebar-content">
            <div className="category">
                <h3>Category</h3>
                <div className="category-filter">
                    <button onClick={() =>{fetchProductsCategory("Clothes")
                navigate("/Products")}}  className="btn">Clothes</button>
                    <button onClick={() =>{fetchProductsCategory("Electronics")
                navigate("/Products")}} className="btn">Electronics</button>
                    <button onClick={() =>{fetchProductsCategory("Home")
                navigate("/Products")}} className="btn">Home</button>
                    <button onClick={() =>{fetchProductsCategory("Books")
                navigate("/Products")}} className="btn">Books</button>
                    <button onClick={() =>{fetchProductsCategory("Cosmetics")
                navigate("/Products")}} className="btn">Cosmetics</button>
                    <button onClick={() =>{fetchProductsCategory("Jewellery")
                navigate("/Products")}} className="btn">Jewellery</button>
                </div>
            </div>
            <div className="price">
                <h3>Rating</h3>
                <div className="price-btn">
                    <button onClick={() =>{fetchProductsRating(1)
                    navigate("/Products")}}  className="btn1">1</button>
                    <button onClick={() =>{fetchProductsRating(2)
                    navigate("/Products")}}  className="btn1">2</button>
                    <button onClick={() =>{fetchProductsRating(3)
                    navigate("/Products")}}  className="btn1">3</button>
                    <button onClick={() =>{fetchProductsRating(4)
                    navigate("/Products")}}  className="btn1">4</button>
                    <button onClick={() =>{fetchProductsRating(5)
                    navigate("/Products")}}  className="btn1">5</button>
                </div>
                
            </div>

            
        </div>

        <button onClick={toggleSidebar} className="sidebar-toggle" >
            <img src="./sidebar.png" className="sidebar-img"/>
        </button>
    </div>
  );
};
export default SideBar;
