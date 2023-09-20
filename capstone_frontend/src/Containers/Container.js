import { BrowserRouter, Route, Routes } from "react-router-dom";
import LandingPage from "../Components/LandingPage";
import ProductsPage from "../Components/ProductsPage";
import OneProductPage from "../Components/OneProductPage";
import LogInPage from "../Components/LogInPage"
import OrderHistoryPage from "../Components/OrderHistoryPage"

const Container = () => {




    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LandingPage />} key={1} />
                    <Route path="/Products" element={<ProductsPage />} key={2} />
                    <Route path="/OneProduct" element={<OneProductPage />} key={3} />
                    <Route path="/LogIn" element={<LogInPage />} key={4} />
                    <Route path="/OrderHistory" element={<OrderHistoryPage />} key={5} />

                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default Container;