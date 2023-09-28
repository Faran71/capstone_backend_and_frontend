import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./SideBar.css"
import { useScroll } from "framer-motion";
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';
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

const [value, setValue] = React.useState([20, 37]);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  function valuetext(value) {
    return `${value}°C`;
  }

// const [number, setNumber] = useState(0)





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
                
                {/* <input value={start} step="1" min={0} max={100} type="range" onInput={onStartChange} style={{width: "100%"}} />
                <input value={end} step="1" min={start} max={100} type="range" onInput={onEndChange} style={{width: "100%"}} /> */}
                {/* {VidTrim()} */}
                <div>
                    <h3>Price Range</h3>
                    <div>
                        <Box sx={{ width: 200 }}>
                        <Slider
                            getAriaLabel={() => 'Temperature range'}
                            value={value}
                            min={0}
                            max={1201}
                            onChange={handleChange}
                            valueLabelDisplay="auto"
                            getAriaValueText={valuetext}
                        />
                        </Box>
                    </div>
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
