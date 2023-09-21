import { BrowserRouter, Route, Routes } from "react-router-dom";
import LandingPage from "../Components/LandingPage";
import ProductsPage from "../Components/ProductsPage";
import OneProductPage from "../Components/OneProductPage";
import LogInPage from "../Components/LogInPage"
import OrderHistoryPage from "../Components/OrderHistoryPage"
import { useEffect, useState } from "react";

const Container = () => {

    const [products, setProducts] = useState({});
    const [order, setOrder] = useState({});
    const [customerDetails, setCustomerDetails] = useState({});
    const [allOrders, setAllOrders] = useState({});
    const [category, setCategory] = useState({});
    const [currentProduct, setCurrentProduct] = useState({});

    const fetchProducts = async () => {
        const response = await fetch("http://localhost:8080/products");
        const data = await response.json()
        setProducts(data);
    }

    useEffect(() => {
        fetchProducts();
    },[])

    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LandingPage />} key={1} />
                    <Route path="/Products" element={<ProductsPage 
                    products={products} 
                    order={order}
                    setOrder={setOrder}
                    category={category}
                    setCategory={setCategory}
                    currentProduct={currentProduct}
                    setCurrentProduct={setCurrentProduct}
                    />} key={2} />
                    <Route path="/OneProduct" element={<OneProductPage currentProduct={currentProduct}/>} key={3} />
                    <Route path="/LogIn" element={<LogInPage />} key={4} />
                    <Route path="/OrderHistory" element={<OrderHistoryPage />} key={5} />

                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default Container;