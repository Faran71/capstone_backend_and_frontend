import { useState } from "react";
import NavBar from "./NavBar";
import "./OneProductPage.css"


const OneProductPage = ({currentProduct, order, setOrder, products, currentCustomer, setCurrentCustomer}) => {

    const [tempQuantity, setTempQuantity] = useState("");

    const handleFormSubmit = (event) => {
        event.preventDefault();
        if(tempQuantity!=="" && currentProduct.availableQuantity !== 0){
            let tempOrder = {
                product: currentProduct,
                quantitySold: tempQuantity,
            }
            setOrder([...order,tempOrder]);
        }
    }
    
    return(
        <div>
            <NavBar order={order} 
            products={products}
            setOrder={setOrder}
            currentCustomer={currentCustomer}
            setCurrentCustomer={setCurrentCustomer}
            />
            <div className="oneproduct">
                <div>
                    <h2>{currentProduct.name}</h2>
                    <img src={currentProduct.imageURL} />
                    <p>Price: £{currentProduct.price}</p>
                    <form onSubmit={handleFormSubmit}>
                        <input type="number" 
                        min={1}
                        name="quantity"
                        placeholder="Quantity"
                        value={tempQuantity}
                        onChange={(e) => setTempQuantity(e.target.value)}
                        />

                        <button type="submit">Buy</button>
                    </form>
                </div>
                <div>
                    <p>{currentProduct.description}</p>
                </div>
            </div>
            
        </div>
    )
}

export default OneProductPage;