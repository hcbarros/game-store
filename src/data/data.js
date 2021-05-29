
import image1 from '../assets/images/super-mario-odyssey.png';
import image2 from '../assets/images/call-of-duty-infinite-warfare.png';
import image3 from '../assets/images/the-witcher-iii-wild-hunt.png';
import image4 from '../assets/images/call-of-duty-wwii.png';
import image5 from '../assets/images/mortal-kombat-xl.png';
import image6 from '../assets/images/shards-of-darkness.png';
import image7 from '../assets/images/terra-media-sombras-de-mordor.png';
import image8 from '../assets/images/fifa-18.png';
import image9 from '../assets/images/horizon-zero-dawn.png';
                                     


export const initialCart = {    
                                frete: 0,
                                subTotal: 0,
                                total: 0,
                                products: []
                            }


export const jogos = [

            {   
                name: "Super Mario Odyssey",
                price: 197.88,
                score: 100,
                image: "super-mario-odyssey.png",
                png: image1
            },
            {
                name: "Call Of Duty Infinite Warfare",
                price: 49.99,
                score: 80,
                image: "call-of-duty-infinite-warfare.png",
                png: image2
            },
            {
                name: "The Witcher III Wild Hunt",
                price: 119.5,
                score: 250,
                image: "the-witcher-iii-wild-hunt.png",
                png: image3
            },
            {
                name: "Call Of Duty WWII",
                price: 249.99,
                score: 205,
                image: "call-of-duty-wwii.png",
                png: image4
            },
            {
                name: "Mortal Kombat XL",
                price: 69.99,
                score: 150,
                image: "mortal-kombat-xl.png",
                png: image5
            },
            {
                name: "Shards of Darkness",
                price: 71.94,
                score: 400,
                image: "shards-of-darkness.png",
                png: image6    
            },
            {
                name: "Terra Média: Sombras de Mordor",
                price: 79.99,
                score: 50,
                image: "terra-media-sombras-de-mordor.png",
                png: image7    
            },
            {
                name: "FIFA 18",
                price: 195.39,
                score: 325,
                image: "fifa-18.png",
                png: image8
            },
            {
                name: "Horizon Zero Dawn",
                price: 115.8,
                score: 290,
                image: "horizon-zero-dawn.png",
                png: image9
            }

]