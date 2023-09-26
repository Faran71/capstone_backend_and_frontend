import { useState } from "react";
import "./CategoriesBox.css"
import { Link, useNavigate } from "react-router-dom";

const CategoriesBox = ({setProducts}) => {
    const navigate = useNavigate()

    const fetchProducts = async (category) => {
        const response = await fetch(`http://localhost:8080/products/${category}`);
        const data = await response.json()
        setProducts(data);
    }

    return(
        <div className="categories">
            <div className="clothes" onClick={() => {
                fetchProducts("Clothes")
                navigate("/products")
            }}>
                <h2>Clothes</h2>
            </div>
            <div className="electronics" onClick={() => {
                fetchProducts("Electronics")
                navigate("/products")
            }}>
                <h2>Electronics</h2>
            </div>
            <div className="home" onClick={() => {
                fetchProducts("Home")
                navigate("/products")
            }}>
                <h2>Home</h2>
            </div>
            <div className="books" onClick={() => {
                fetchProducts("Books")
                navigate("/products")
            }}>
                <h2>Books</h2>
            </div>
            <div className="cosmetics" onClick={() => {
                fetchProducts("Cosmetics")
                navigate("/products")
            }}>
                <h2>Cosmetics</h2>
            </div>
            <div className="jewellery" onClick={() => {
                fetchProducts("Jewellery")
                navigate("/products")
            }}>
                <h2>Jewellery</h2>
            </div>

        </div>
    )
}

export default CategoriesBox;