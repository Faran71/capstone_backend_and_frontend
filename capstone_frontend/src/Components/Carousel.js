import "./Carousel.css";
import {motion} from "framer-motion"
import { useRef, useEffect, useState } from "react";
import images from "../images";

 
const Carousel = ({images}) => {

  const [width, setWidth] = useState(0);
  const carousel = useRef();
  const intervalRef = useRef(null);

  useEffect(() => {
    setWidth(carousel.current.scrollWidth - carousel.current.offsetWidth);
    return () => clearInterval(intervalRef.current);
  }, []);

  return (
      <motion.div ref={carousel} className="carousel" whileTap={{cursor: "grabbing"}}>
        <motion.div 
        drag="x" 
        dragConstraints={{right:0, left: -width}} 
        className="inner-carousel"
        >
          {images.map(image => {
            return(
              <motion.div className="item" key={image}>
                <img src={image} alt="" />
              </motion.div>
            )
          }
            )}
        </motion.div>
      </motion.div>
    )
} 

export default Carousel;