import React from "react";
import { useNavigate } from "react-router-dom";
import "./SideBar.css"

const SideBar = ({isOpen, toggleSidebar}) => {
  const navigate = useNavigate();

  const sidebarClass = isOpen ? "sidebar open" : "sidebar";
  return (
    <div className={sidebarClass}>
        <div className="slidebar-content">
            <h3>Category</h3>
            <div className="category-filter">
                <button  className="btn">Clothes</button>
                <button  className="btn">Electronics</button>
                <button  className="btn">Home</button>
                <button  className="btn">Books</button>
                <button  className="btn">Cosmetics</button>
                <button  className="btn">Jewellery</button>
            </div>
            
        </div>

        <button onClick={toggleSidebar} className="sidebar-toggle" >
            <img src="./sidebar.png" className="sidebar-img"/>
        </button>
    </div>
  );
};
export default SideBar;
