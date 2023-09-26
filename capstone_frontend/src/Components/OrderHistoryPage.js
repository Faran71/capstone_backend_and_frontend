import { useEffect, useState } from "react";
import NavBar from "./NavBar";
import { useScroll } from "framer-motion";
import "./OrderHistoryPage.css";

const OrderHistoryPage = ({order, setOrder, products,originalProducts, setOriginalProducts, setProducts, allOrders,currentCustomer, setCurrentCustomer}) => {

    const [isClicked, setIsClicked] = useState(false);
    const displayOrders = order.map((item) => {
        return(
            <div className="modalproduct">
                    <img src={item.product.imageURL}/>
                    <p>{item.product.name} - {item.quantitySold}</p>
                    <p> Total = £{item.quantitySold*item.product.price}</p>
            </div>
        )
    })


    const putOrder = async () => {
        const newOrderResponse = await fetch(`http://localhost:8080/orders/createOrder/${currentCustomer.id}`,{
            method: "POST",
            headers: {"Content-Type": "application/json"},
        })
        const newOrder = await newOrderResponse.json();

        order.forEach(async (item) => {
            const response = await fetch(`http://localhost:8080/productsOrders/${item.product.id}/${newOrder.id}/${item.quantitySold}`,{
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            })
        })
        
    }

    const handleSubmit = () => {
        putOrder();
        setOrder([]);

    }

    return(
        <div>
            <NavBar order={order} 
            products={products}
            setOrder={setOrder}
            currentCustomer={currentCustomer}
            setCurrentCustomer={setCurrentCustomer}
            originalProducts={originalProducts}
            setOriginalProducts={setOriginalProducts}
            setProducts={setProducts}
            />
            <div>
                <h1>Order:</h1>
                {displayOrders}
                <button onClick={handleSubmit}>Buy</button>
            </div>
            
        </div>
    )
}

export default OrderHistoryPage;