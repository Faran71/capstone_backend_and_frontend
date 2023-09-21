import NavBar from "./NavBar";

const OneProductPage = ({currentProduct}) => {

    return(
        <div>
            <NavBar />
            <div>
                <h2>{currentProduct.name}</h2>
                <img src={currentProduct.imageUrl} />
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
        </div>
    )
}

export default OneProductPage;