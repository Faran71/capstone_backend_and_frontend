import { useState } from "react";
import NavBar from "./NavBar";
import "./OneProductPage.css"
import { useNavigate } from "react-router-dom";


const OneProductPage = ({currentProduct, order, setOrder,originalProducts, setProducts, setOriginalProducts, products, currentCustomer, setCurrentCustomer}) => {
    const navigate = useNavigate();

    const [tempQuantity, setTempQuantity] = useState("");

    const [soldOut, setSoldOut] = useState(true)
    const [limited, setLimited] = useState(true)

    const [name, setName] = useState("");

    const [hideReviewMessage, setHideReviewMessage] = useState(true)


    const [ review, setReview] = useState("")

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
    const postReview = async (name, currentProduct, review) => {
        let reviewInfo = {
            name: name,
            reviewContent: review,
            productId: currentProduct.id
        }
        const newOrderResponse = await fetch(`http://localhost:8080/reviews`,{
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body:JSON.stringify(reviewInfo)
        })
    }



    const handleReview = (event) => {
        event.preventDefault();
        if(currentCustomer){
            // setName(currentCustomer.name)
            postReview(currentCustomer.name, currentProduct, review);
            setReview("")
        } else {
            setHideReviewMessage(false)
            setReview("")
        }
        
    }
    
    const pastReviews = currentProduct.reviews.map((item) => {
        return(
            <div className="individual-review">
                <p>Name: {item.name}</p>
                <p>Comment: {item.reviewContent}</p>
            </div>
        )
    })


    
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
                    <p>Rating: {"⭐".repeat(currentProduct.rating)}</p>
                    <div>
                        <h3>Write a review</h3>
                        <p hidden={hideReviewMessage} style={{color:"red" }}>Please Log In first.</p>
                        <div className="review-input">
                            <form onSubmit={handleReview}>
                                <input type="text" 
                                name="review"
                                placeholder="Write Here..."
                                value={review}
                                onChange={(e) => setReview(e.target.value)}
                                />
                                <button type="submit"><img src="./kite.png"/></button>
                            </form>
                        </div>
                        <div >
                            <h3>Our Customers views:</h3>
                            <div >
                                {currentProduct.reviews.length === 0 ? <p>No Reviews Yet...</p>: <div className="old-reviews">{pastReviews}</div>}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    )
}

export default OneProductPage;