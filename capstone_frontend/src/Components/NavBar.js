import { useNavigate  } from "react-router-dom";
import "./NavBar.css"
import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { useEffect, useState } from "react";

const NavBar = ({products,order, setOrder, originalProducts, setOriginalProducts,currentCustomer, setCurrentCustomer ,setProducts}) => {
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

    const deleteOrder = (e) => {
        setOrder(temp => {
            return temp.filter(country => country!== e);
        })
    }
    
    useEffect(() => {
        const displayOrders = order.map((item) => {
            return(
                <div className="modalproduct">
                    <img src={item.product.imageURL}/>
                    <p>{item.product.name} - {item.quantitySold}</p>
                    <button onClick={() => deleteOrder(item)}><img src ="https://www.freeiconspng.com/uploads/delete-x-square-button-png-3.png"/></button>
                </div>
            )
        })
        setModalProducts(displayOrders);
    },[order])
    
      const ifLoggedIn = () => {
        if(currentCustomer){
            return(
                <div>
                    <button className="btn4" onClick={() => navigate("/OrderHistory")}>Hello {currentCustomer.name}</button>
                    <button className="btn4" onClick={() => setCurrentCustomer(null)}>LogOut</button>
                </div>
                 )
            
        } else {
            return <button className="btn3" onClick={() => navigate("/LogIn")}>Log In / Register</button>
        }
      }

      const fullProducts = () => {
        setProducts(originalProducts)
      }
      

    return(
        <div className="nav-bar">
            <button className='btn1' onClick={() => navigate("/")}>
                <span>Rainforest Retail</span>
                <img src="./leaf.png"></img></button>
            <button className='btn2' onClick={() => {
                {fullProducts()}
                navigate("/Products")
            }}>All Products</button>
            
            {ifLoggedIn()}

            <button className="btn5" variant= "contained" onClick={handleOpen}>
                <img src="./cart.png" className="shopping-cart"/>
            </button>
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    <p>Order Summary</p>
                    <div className="modal">
                    {modalProducts}
                    </div>
                    <button onClick={() => {
                        if(currentCustomer){
                            navigate("/OrderHistory")
                        } else {
                            navigate("/LogIn")
                        }
                    }}>Check out</button>
                </Box>

            </Modal>
        </div>
    )
}

export default NavBar;