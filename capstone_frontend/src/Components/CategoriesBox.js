import { useState } from "react";
import "./CategoriesBox.css"
import { Link, useNavigate } from "react-router-dom";

const CategoriesBox = () => {
    const navigate = useNavigate()

    return(
        <div className="categories">
            <div className="clothes" onClick={() => navigate("/products")}>
                <h2>Clothes</h2>
            </div>
            <div className="electronics" onClick={() => navigate("/products")}>
                <h2>Electronics</h2>
            </div>
            <div className="home" onClick={() => navigate("/products")}>
                <h2>Home</h2>
            </div>
            <div className="books" onClick={() => navigate("/products")}>
                <h2>Books</h2>
            </div>
            <div className="cosmetics" onClick={() => navigate("/products")}>
                <h2>Cosmetics</h2>
            </div>
            <div className="jewellery" onClick={() => navigate("/products")}>
                <h2>Jewellery</h2>
            </div>

        </div>
    )
}

export default CategoriesBox;