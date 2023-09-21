import { useNavigate } from "react-router-dom";
import "./NavBar.css"
import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';

const NavBar = () => {
    const navigate = useNavigate();

    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    return(
        <div className="nav-bar">
            <button onClick={() => navigate("/")}>Logo</button>
            <button onClick={() => navigate("/Products")}>All Products</button>
            <button onClick={() => navigate("/LogIn")}>Order History</button>
            <Button id="modal-button" variant= "contained" onClick={handleOpen}>Basket</Button>
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box >
                <Typography id="modal-modal-title" variant="h6" component="h2">
                    Who is?
                </Typography>
                {/* <Typography id="petmodal-image">
                    <img src={`pet_images/pet_${pet.species}3.gif`} />
                </Typography>
                <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                {displayMessage()}
                </Typography> */}
                </Box>
            </Modal>
        </div>
    )
}

export default NavBar;