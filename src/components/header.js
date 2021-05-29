
import '../assets/css/main.css';
import React, { useState } from 'react';
import {Redirect} from 'react-router-dom';
import { useSelector } from 'react-redux';
import logo from '../assets/images/game-store2.png';
import cart_icon from '../assets/images/cart-icon.svg';


export default function Header(props) {

    const [redirect, setRedirect] = useState(false);
    const cart = useSelector(state => state.cart);

    return (
        <div>

            {redirect && <Redirect to={props.local} />}

            <header >
               <img src={logo} alt="logo"/>
               <div className="block-cart">
                  
                  {props.main && <div><img className="click-header" 
                            onClick={() => setRedirect(true)} 
                            src={cart_icon} alt="Cart image"/></div>}
                  
                  {!props.main && <div><a className="click-header" 
                    onClick={() => setRedirect(true)} 
                    href="#">{props.linkText}</a></div>}
                  
                  {props.main && <div className="h-cart"><a>{cart.cart.products ? 
                        cart.cart.products.length : 0}</a></div>}
                        
               </div>   
            </header>

            <div className="line-header"></div>
        </div>
    );
}

