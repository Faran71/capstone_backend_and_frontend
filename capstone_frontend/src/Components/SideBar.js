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
            <button  className="btn">Home</button>
            <button  className="btn">Fact</button>
            <button  className="btn">Quote</button>
            <button  className="btn">Age Guesser</button>
            <button onClick={toggleSidebar} className="btn">Toggle Sidebar</button>
        </div>

        <button onClick={toggleSidebar} className="sidebar-toggle">
            Toggle Sidebar
        </button>
    </div>
  );
};
export default SideBar;
