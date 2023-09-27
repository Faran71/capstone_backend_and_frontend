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
            <CategoriesBox setProducts={setProducts} fetchProductsCategory={fetchProductsCategory}/>
        </div>
    )
}

export default LandingPage;