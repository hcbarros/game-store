
import '../assets/css/main.css';
import loader from '../assets/images/loader.gif';
import delete_icon from '../assets/images/delete.png';
import React, { useState, useEffect } from 'react';
import $ from 'jquery';
import Api from '../api/api';
import {Redirect} from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { setCart }  from '../actions/actions';
import { initialCart } from '../data/data';
import Header from '../components/header';
import { jogos } from '../data/data';


export default function Cart() {

    const dispatch = useDispatch();
    const [init, setInit]  = useState(true);
    const [loading, setLoading]  = useState(false);
    const [redirect, setRedirect]  = useState(false);
    const cart = useSelector(state => state.cart);


    const deletar = async (name) => {

         setLoading(true);   
         const products = deleteProducts(name);
         const resp = await Api.replaceProducts(cart.cart.id, products);
         setLoading(false);

         if(typeof resp.products !== 'undefined') dispatch(setCart(resp));   
         else alert("Um erro ocorreu ao excluir um jogo do carrinho!");       
    }


    const deleteProducts = (name) => {
        return cart.cart.products.filter(p => p.name !== name);
    }

    const filtrar = () => {
        const result = [];
        let array = [];        
        cart.cart.products.map(p => {
            if(array.indexOf(p.name) < 0) {
                array.push(p.name);
                result.push(p);
            }
        });
        return result;
    }

    const getProducts = (name) => {
        return cart.cart.products.filter(p => p.name == name);
    }

    const getImage = (image) => {
        const images = jogos.filter(j => j.image == image);
        return images[0].png;
    }

    const blindEffect = () => {
        $(".order-option").toggle( "blind" );
    }

    const orderBy = async (order) => {
        setLoading(true);
        const resp = await Api.getProductsByOrder(cart.cart.id, order);
        if(typeof resp.products !== 'undefined') dispatch(setCart(resp));
        else alert("Um erro ocorreu ao ordenar os produtos!");    
        setLoading(false);
    }

    useEffect(async () => { 
        $(".order-option").hide(); 
    },[init, loading]);


    return (
        <div className="main">
            
            <Header main={false} local="/" linkText="Voltar" />

            {redirect && <Redirect to="/endereco" />}


            <div className="block-select">
                <div className="select-option" onClick={() => blindEffect()}>  
                    <div className="order" >Ordenar por:
                        <div className="arrow-down-option"></div>
                    </div>
                    <div className="new-option order-option"
                        onClick={()=> orderBy('orderByPrice')}>Preço</div>
                    <div className="low-price order-option"
                        onClick={()=> orderBy('orderByScore')}>Score</div>
                    <div className="high-price order-option"
                        onClick={()=> orderBy('orderByName')}>Nome</div>
                </div>
            </div>


            {loading && <div className="loading"><img src={loader} 
                alt="imagem gif carregando" /></div>}

            
            {!loading && 

            <div className="cart">

                <table className="table-cart">
                    
                    <caption>{cart.cart.total > 0 ? "Carrinho de compras" :
                                     "O carrinho está vazio!"}</caption>
                  
                        {filtrar().map(jogo => 
                            <tr>
                                <td >
                                    <img className="img-jogo" src={getImage(jogo.image)} 
                                            alt="Imagem do jogo" /></td>
                                <td>
                                    <div className="jogo-info"><b>Nome:</b> {jogo.name}</div>
                                    <div className="jogo-info"><b>Preço:</b> {jogo.price}</div>
                                    <div className="jogo-info"><b>Score:</b> {jogo.score}</div>
                                </td>
                                <td className="td-quantia">
                                    <img src={delete_icon} alt="imagem lixeira" 
                                            onClick={() => deletar(jogo.name)} />
                                    <div ><b>Quantia:</b> {getProducts(jogo.name).length}</div>
                                </td>
                                <td className="td-delete">
                                    <img src={delete_icon} alt="imagem lixeira" 
                                         onClick={() => deletar(jogo.name)} />
                                </td>
                            </tr>
                        )}
                    
                </table>


                {cart.cart.total > 0 && <div className="divisor"></div>}            

                {cart.cart.total > 0 &&            

                <div className="valores-container">        
                    <table className="valores">
                        <caption>Valores</caption>
                        <tr>
                            <td><b>Frete:</b></td>
                            <td>{cart.cart.frete}</td>    
                        </tr>   
                        <tr>
                            <td><b>Subtotal:</b></td>
                            <td>{cart.cart.subTotal}</td>    
                        </tr>   
                        <tr>
                            <td><b>Total:</b></td>
                            <td>{cart.cart.total}</td>    
                        </tr>                        
                    </table>   
                    <button onClick={() => setRedirect(true)} className="btn-confirma">Confirmar</button>
                </div>}            

            </div>}

        </div>
    );
}

