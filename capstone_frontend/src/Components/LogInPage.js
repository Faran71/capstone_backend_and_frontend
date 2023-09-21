import { useState } from "react";
import "./LogInPage.css"

const LogInPage = () => {

    const [tempUsername, setTempUsername] = useState("")
    const [tempPassword, setTempPassword] = useState("")
    return(
        <div className="log-in">
            <form className="log-in-form">
                <input type="text" 
                name="tempUsername"
                placeholder="Username"
                value={tempUsername}
                onChange={(e) => setTempUsername(e.target.value)}
                />
                <input type="password" 
                name="tempPassword"
                placeholder="Password"
                value={tempPassword}
                onChange={(e) => setTempPassword(e.target.value)}
                />
                <button>Sign In</button>
            </form>
        </div>
    )
}

export default LogInPage;