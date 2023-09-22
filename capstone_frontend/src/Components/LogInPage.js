import { useState } from "react";
import "./LogInPage.css"
import { useNavigate } from "react-router-dom";

const LogInPage = ({customerDetails, currentCustomer, setCurrentCustomer}) => {
    const navigate = useNavigate();

    const [tempEmail, setTempEmail] = useState("")
    const [tempPassword, setTempPassword] = useState("")

    const handleFormSubmit = (event) => {
        event.preventDefault();
        customerDetails.map((customer) => {
            if(customer.email === tempEmail && customer.password === tempPassword){
                setCurrentCustomer(customer);
                navigate("/OrderHistory")
            }

        })
    }

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
            </form>
        </div>
    )
}

export default LogInPage;