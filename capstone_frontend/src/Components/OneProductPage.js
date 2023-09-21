import NavBar from "./NavBar";
import "./OneProductPage.css"

const OneProductPage = ({currentProduct}) => {

    
    return(
        <div>
            <NavBar />
            <div className="oneproduct">
                <div>
                    <h2>{currentProduct.name}</h2>
                    <img src={currentProduct.imageURL} />
                    <p>Price: £{currentProduct.price}</p>
                    <form>
                        <input type="number" 
                        name="quantity"
                        placeholder="Quantity"
                        // value={}
                        // onChange={}
                        />

                        <button>Buy</button>
                        
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