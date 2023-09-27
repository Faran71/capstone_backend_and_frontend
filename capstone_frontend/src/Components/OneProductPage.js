import { useState } from "react";
import NavBar from "./NavBar";
import "./OneProductPage.css"


const OneProductPage = ({currentProduct, order, setOrder,originalProducts, setProducts, setOriginalProducts, products, currentCustomer, setCurrentCustomer}) => {

    const [tempQuantity, setTempQuantity] = useState("");

    const [soldOut, setSoldOut] = useState(true)
    const [limited, setLimited] = useState(true)

    const handleFormSubmit = (event) => {
        event.preventDefault();
        if(tempQuantity!=="" && (currentProduct.availableQuantity-tempQuantity) >= 0){
            let tempOrder = {
                product: currentProduct,
                quantitySold: tempQuantity,
            }
            setOrder([...order,tempOrder]);
        } else if(currentProduct.availableQuantity === 0) {
            setSoldOut(false)
        } else {
            setLimited(false);
        }
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
            <div className="oneproduct">
                <div className="left">
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
                        <p hidden={soldOut}>Sold Out !</p>
                        <p hidden={limited}>Only {currentProduct.availableQuantity} avaliable</p>
                    </form>
                </div>
                <div className="right">
                    <p>{currentProduct.description}</p>
                </div>
            </div>
            
        </div>
    )
}

export default OneProductPage;