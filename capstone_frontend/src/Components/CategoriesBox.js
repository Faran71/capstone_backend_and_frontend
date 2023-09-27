import { useState } from "react";
import "./CategoriesBox.css"
import { Link, useNavigate } from "react-router-dom";

const CategoriesBox = ({setProducts, fetchProductsCategory}) => {
    const navigate = useNavigate()

    // const fetchProducts = async (category) => {
    //     const response = await fetch(`http://localhost:8080/products/category=${category}`);
    //     const data = await response.json()
    //     setProducts(data);
    // }

    return(
        <div className="categories">
            <div className="clothes" onClick={() => {
                fetchProductsCategory("Clothes")
                navigate("/Products")
            }}>
                <h2>Clothes</h2>
            </div>
            <div className="electronics" onClick={() => {
                fetchProductsCategory("Electronics")
                navigate("/Products")
            }}>
                <h2>Electronics</h2>
            </div>
            <div className="home" onClick={() => {
                fetchProductsCategory("Home")
                navigate("/Products")
            }}>
                <h2>Home</h2>
            </div>
            <div className="books" onClick={() => {
                fetchProductsCategory("Books")
                navigate("/Products")
            }}>
                <h2>Books</h2>
            </div>
            <div className="cosmetics" onClick={() => {
                fetchProductsCategory("Cosmetics")
                navigate("/Products")
            }}>
                <h2>Cosmetics</h2>
            </div>
            <div className="jewellery" onClick={() => {
                fetchProductsCategory("Jewellery")
                navigate("/Products")
            }}>
                <h2>Jewellery</h2>
            </div>

        </div>
    )
}

export default CategoriesBox;