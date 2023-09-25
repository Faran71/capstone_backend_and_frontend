import NavBar from "./NavBar";
import ProductDisplay from "./ProductDisplay";
import "./ProductsPage"
import { useNavigate } from "react-router-dom";

const ProductsPage = ({products, order, category, currentProduct, setOrder, setCategory, setCurrentProduct}) => {
    const navigate = useNavigate();

    const displayProducts = products.map((product) => {
        return <div onClick={() => {setCurrentProduct(product); navigate("/OneProduct");}}><ProductDisplay product={product} /></div>;
    })
    return(
        <div>
            <NavBar order={order} products={products}/>
            <div className="display">
                {displayProducts}
            </div>
        </div>
    )
}

export default ProductsPage;