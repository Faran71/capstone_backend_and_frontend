import { BrowserRouter, Route, Routes } from "react-router-dom";
import LandingPage from "../Components/LandingPage";
import ProductsPage from "../Components/ProductsPage";
import OneProductPage from "../Components/OneProductPage";
import LogInPage from "../Components/LogInPage"
import OrderHistoryPage from "../Components/OrderHistoryPage"
import { useEffect, useState } from "react";
import { filledInputClasses } from "@mui/material";

const Container = () => {

    const [products, setProducts] = useState([]);
    const [originalProducts,setOriginalProducts] = useState([])
    const [order, setOrder] = useState([]);
    const [customerDetails, setCustomerDetails] = useState({});
    const [currentCustomer, setCurrentCustomer] = useState(null);
    const [allOrders, setAllOrders] = useState({});
    const [category, setCategory] = useState({});
    const [currentProduct, setCurrentProduct] = useState({});

    const fetchProducts = async () => {
        const response = await fetch("http://localhost:8080/products");
        const data = await response.json()
        setProducts(data);
        setOriginalProducts(data);
    }

    const fetchCustomers = async () => {
        const response = await fetch("http://localhost:8080/customers");
        const data = await response.json()
        setCustomerDetails(data);
    }
    const fetchOrders = async () => {
        const response = await fetch("http://localhost:8080/productsOrders");
        const data = await response.json()
        setAllOrders(data);
    }

    const fetchProductsCategory = async (category) => {
        const response = await fetch(`http://localhost:8080/products/category=${category}`);
        const data = await response.json()
        setProducts(data);
    }


    useEffect(() => {
        fetchProducts();
        fetchCustomers();
        fetchOrders();
    },[])

    useEffect(() => {
        fetchOrders();
    },[allOrders])


    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LandingPage 
                    order={order}
                    products={products}
                    setOrder={setOrder}
                    currentCustomer={currentCustomer}
                    originalProducts={originalProducts}
                    setOriginalProducts={setOriginalProducts}
                    setCurrentCustomer={setCurrentCustomer}
                    setProducts={setProducts}
                    fetchProductsCategory={fetchProductsCategory}
                    
                    />} key={1} />
                    <Route path="/Products" element={<ProductsPage 
                    products={products} 
                    setProducts={setProducts}
                    order={order}
                    setOrder={setOrder}
                    category={category}
                    setCategory={setCategory}
                    currentProduct={currentProduct}
                    setCurrentProduct={setCurrentProduct}
                    currentCustomer={currentCustomer}
                    setCurrentCustomer={setCurrentCustomer}
                    originalProducts={originalProducts}
                    setOriginalProducts={setOriginalProducts}
                    fetchProductsCategory={fetchProductsCategory}
                    />} key={2} />
                    <Route path="/OneProduct" element={<OneProductPage 
                    currentProduct={currentProduct}
                    order={order}
                    setOrder={setOrder}
                    products={products}
                    setProducts={setProducts}
                    currentCustomer={currentCustomer}
                    setCurrentCustomer={setCurrentCustomer}
                    originalProducts={originalProducts}
                    setOriginalProducts={setOriginalProducts}
                    />} key={3}
                    />
                    <Route path="/LogIn" element={<LogInPage 
                    customerDetails={customerDetails}
                    setCustomerDetails={setCustomerDetails}
                    currentCustomer={currentCustomer}
                    setCurrentCustomer={setCurrentCustomer}
                    fetchCustomers={fetchCustomers}/>} key={4} />
                    <Route path="/OrderHistory" element={<OrderHistoryPage 
                    order={order} 
                    setOrder={setOrder}
                    products={products}
                    setProducts={setProducts}
                    allOrders={allOrders}
                    currentCustomer={currentCustomer}
                    originalProducts={originalProducts}
                    setOriginalProducts={setOriginalProducts}
                    setCurrentCustomer={setCurrentCustomer}/>} key={5} />

                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default Container;