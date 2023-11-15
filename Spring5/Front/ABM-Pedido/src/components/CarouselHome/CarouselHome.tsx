import { Carousel } from "react-bootstrap";

export const CarouselHome = () => {
    return (
        <Carousel>

            {/* Item 1 */}
            <Carousel.Item>
                    <img className='d-block w-100' src="src/assets/images/HaloName.jpg" alt="HaloName" />
                <Carousel.Caption>
                    <h3>First slide label</h3>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
            </Carousel.Item>

            {/* Item 2 */}
            <Carousel.Item>
                    <img className='d-block w-100' src="src/assets/images/HaloInfinite.jpeg" alt="HaloInfinite" />
                <Carousel.Caption>
                    <h3>Second slide label</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </Carousel.Caption>
            </Carousel.Item>

            {/* Item 3 */}
            <Carousel.Item>
                    <img className='d-block w-100' src="src/assets/images/John.jpg" alt="John" />
                <Carousel.Caption>
                    <h3>Third slide label</h3>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                </Carousel.Caption>
            </Carousel.Item>

        </Carousel>
    )
}