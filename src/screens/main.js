
import '../assets/css/main.css';
import loader from '../assets/images/loader.gif';
import React, { useState, useEffect } from 'react';
import Api from '../api/api';
import {Redirect} from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { setCart }  from '../actions/actions';
import { initialCart } from '../data/data';
import Header from '../components/header';
import { jogos } from '../data/data';


export default function Main() {

    const dispatch = useDispatch();
    const [init, setInit]  = useState(true);
    const [loading, setLoading]  = useState(true);
    const [redirect, setRedirect]  = useState(false);
    const cart = useSelector(state => state.cart);


    const adicionar = async (jogo) => {

         let temp = {name: jogo.name, price: jogo.price, 
                     score: jogo.score, image: jogo.image}   
         
         const resp = await Api.updateCart(cart.cart.id, temp);
         if(typeof resp.products !== 'undefined') dispatch(setCart(resp));   
         else alert("Um erro ocorreu ao inserir o jogo ao carrinho!");       
         
    }

    useEffect(async () => {

        const list = await Api.cartsEmpty();
        if(typeof cart.cart.id === 'undefined') {   
            if(Array.isArray(list) && list.length > 0) {
                dispatch(setCart(list[0]));    
            }
            else {
                const resp = await Api.saveCart(initialCart);
                dispatch(setCart(resp));
            }
        }
        setLoading(false);
    },[init]);


    return (
        <div className="main">
            
            <Header main={true} local="/cart" />

            <div className="app">


                {loading && <div className="loading"><img src={loader} 
                alt="imagem gif carregando" /></div>}

                {!loading && 
                
                <table>
                    <caption>Lista de jogos</caption>
                  
                        {jogos.map((jogo, index) => 
                            <tr key={index}>
                                <td >   
                                    <img className="img-jogo" src={jogo.png} 
                                            alt="Imagem do jogo" /></td>
                                <td>
                                    <div className="jogo-info"><b>Nome:</b> {jogo.name}</div>
                                    <div className="jogo-info"><b>Preço:</b> {jogo.price}</div>
                                    <div className="jogo-info"><b>Score:</b> {jogo.score}</div>
                                </td>
                                <td ><a href="#" 
                                        onClick={() => adicionar(jogo)}
                                        >comprar</a>
                                </td>
                            </tr>
                        )}
                    
                </table>}


            </div>

        </div>
    );
}

