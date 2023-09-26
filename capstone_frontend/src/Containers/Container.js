import { BrowserRouter, Route, Routes } from "react-router-dom";
import LandingPage from "../Components/LandingPage";
import ProductsPage from "../Components/ProductsPage";
import OneProductPage from "../Components/OneProductPage";
import LogInPage from "../Components/LogInPage"
import OrderHistoryPage from "../Components/OrderHistoryPage"
import { useEffect, useState } from "react";

const Container = () => {

    const [products, setProducts] = useState([]);
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
                    setCurrentCustomer={setCurrentCustomer}
                    />} key={1} />
                    <Route path="/Products" element={<ProductsPage 
                    products={products} 
                    order={order}
                    setOrder={setOrder}
                    category={category}
                    setCategory={setCategory}
                    currentProduct={currentProduct}
                    setCurrentProduct={setCurrentProduct}
                    currentCustomer={currentCustomer}
                    setCurrentCustomer={setCurrentCustomer}
                    />} key={2} />
                    <Route path="/OneProduct" element={<OneProductPage 
                    currentProduct={currentProduct}
                    order={order}
                    setOrder={setOrder}
                    products={products}
                    currentCustomer={currentCustomer}
                    setCurrentCustomer={setCurrentCustomer}
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
                    allOrders={allOrders}
                    currentCustomer={currentCustomer}
                    setCurrentCustomer={setCurrentCustomer}/>} key={5} />

                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default Container;