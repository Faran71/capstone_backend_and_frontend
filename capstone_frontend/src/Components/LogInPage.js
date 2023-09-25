import { useState } from "react";
import "./LogInPage.css"
import { useNavigate } from "react-router-dom";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { paperClasses } from "@mui/material";

const LogInPage = ({customerDetails, setCustomerDetails, currentCustomer, setCurrentCustomer}) => {
    const navigate = useNavigate();

    const [tempEmail, setTempEmail] = useState("")
    const [tempPassword, setTempPassword] = useState("")

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [address, setAddress] = useState("");
    const [password, setPassword] = useState("");
    const [registrationData, setRegistrationData] = useState({});

    const handleFormSubmit = (event) => {
        event.preventDefault();
        customerDetails.map((customer) => {
            if(customer.email === tempEmail && customer.password === tempPassword){
                setCurrentCustomer(customer);
                navigate("/OrderHistory")
            }
        })
    }


    const postCustomer = async (registrationData) => {
        const newOrderResponse = await fetch(`http://localhost:8080/customers`,{
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body:JSON.stringify(registrationData)
        })
        const newCustomers = await newOrderResponse.json();
        setCustomerDetails(newCustomers);
    }


    const [open, setOpen] = useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    const handleRegistrationFormSubmit = (event) => {
        event.preventDefault();
        setRegistrationData({
            name: name,
            email: email,
            address: address,
            password: password
        })
        handleClose();
        postCustomer(registrationData);
    }

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

    return(
        <div className="log-in">
            <form className="log-in-form" onSubmit={handleFormSubmit}>
                <input type="text" 
                name="tempEmail"
                placeholder="Email"
                value={tempEmail}
                onChange={(e) => setTempEmail(e.target.value)}
                />
                <input type="password" 
                name="tempPassword"
                placeholder="Password"
                value={tempPassword}
                onChange={(e) => setTempPassword(e.target.value)}
                />
                <button type="submit">Sign In</button>
                <button variant= "contained" onClick={handleOpen}>Register</button>
            </form>
            
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    <p>Oheheheh</p>
                    <form onSubmit={handleRegistrationFormSubmit} className="registration">
                        <input type="text" 
                        name="name"
                        placeholder="Name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        />
                        <input type="text" 
                        name="email"
                        placeholder="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        />
                        <input type="text" 
                        name="address"
                        placeholder="Address"
                        value={address}
                        onChange={(e) => setAddress(e.target.value)}
                        />
                        <input type="text" 
                        name="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        />
                        <button type="submit">Register</button>

                    </form>
                    
                </Box>

            </Modal>
        </div>
    )
}

export default LogInPage;