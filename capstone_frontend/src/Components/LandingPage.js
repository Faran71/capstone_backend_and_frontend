import CategoriesBox from "./CategoriesBox";
import NavBar from "./NavBar";
import "./LandingPage.css";
import Carousel from "./Carousel";
import images from "../images";



const LandingPage = ({order, products,setProducts, setOrder,originalProducts, fetchProductsCategory, setOriginalProducts, currentCustomer, setCurrentCustomer}) => {
 

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
            <Carousel className="carousel" images={images} />
            <div className="categoriesBox">
                <CategoriesBox setProducts={setProducts} fetchProductsCategory={fetchProductsCategory}/>
            </div>

            <footer className="footer">
                <div className="footer-column">
                    <h3>Help & Information</h3>
                </div>
                <div className="footer-column">
                    <h3>About</h3>
                </div>
                <div className="footer-column">
                    <h3>More from Rainforest Retail</h3>
                </div>
            </footer>
        </div>
    )
}

export default LandingPage;