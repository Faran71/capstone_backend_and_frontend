import NavBar from "./NavBar";
import ProductDisplay from "./ProductDisplay";
import "./ProductsPage"
import { useNavigate } from "react-router-dom";

const ProductsPage = ({products, order, category,  setOrder, setCategory,filterProducts,setFilterProducts,setCurrentProduct, currentCustomer, setCurrentCustomer}) => {
    const navigate = useNavigate();

    const displayProducts = products.map((product) => {
        return <div onClick={() => {setCurrentProduct(product); navigate("/OneProduct");}}><ProductDisplay product={product} /></div>;
    })
    return(
        <div>
            <NavBar order={order} 
            products={products}
            setOrder={setOrder}
            currentCustomer={currentCustomer}
            setCurrentCustomer={setCurrentCustomer}
            setFilterProducts={setFilterProducts}
            />
            <div className="display">
                {displayProducts}
            </div>
        </div>
    )
}

export default ProductsPage;