import { useNavigate } from "react-router-dom";

const NavBar = () => {
    const navigate = useNavigate();

    return(
        <div>
            <button onClick={() => navigate("/")}>Logo</button>
            <button onClick={() => navigate("/Products")}>All Products</button>
            <button onClick={() => navigate("/LogIn")}>Order History</button>
            <button >Basket</button>
        </div>
    )
}

export default NavBar;