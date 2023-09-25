import { useNavigate  } from "react-router-dom";
import "./NavBar.css"
import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { useEffect, useState } from "react";

const NavBar = ({order}) => {
    const navigate = useNavigate();

    const [modalProducts, setModalProducts] = useState([]);
    const [open, setOpen] = useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 600,
        bgcolor: 'background.paper',
        boxShadow: 24,
        p: 4, 
      };

      
    
    useEffect(() => {
        const displayOrders = order.map((item) => {
            return(
                <div>
                    {/* <img src={item.product.imageURL}/> */}
                    <p>{item.product.name} - {item.quantitySold}</p>
                </div>
            )
        })
        setModalProducts(displayOrders);
    },[order])
    
      

    return(
        <div className="nav-bar">
            <button onClick={() => navigate("/")}>Logo</button>
            <button onClick={() => navigate("/Products")}>All Products</button>
            <button onClick={() => navigate("/LogIn")}>Order History</button>
            <button variant= "contained" onClick={handleOpen}>
                <img src="https://e7.pngegg.com/pngimages/833/426/png-clipart-shopping-cart-icon-shopping-cart-black-design.png" className="shopping-cart"/>
            </button>
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    <p>Order Summary</p>
                    {modalProducts}
                    <button onClick={() => navigate("/LogIn")}>Check out</button>
                </Box>

            </Modal>
        </div>
    )
}

export default NavBar;