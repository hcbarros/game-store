

import {combineReducers} from 'redux'
import { jogos } from '../data/data';



export const CART = 'cart';
export const ENDERECO = 'endereco';
export const USUARIO = 'usuario';

const cart = (state = {cart: {}}, action) => {
    return action.type === CART ? 
          { ...state, cart: action.payload } : state;            
}

const endereco = (state = {endereco: {}}, action) => {
    return action.type === ENDERECO ? 
          { ...state, endereco: action.payload } : state;            
}

const usuario = (state = {usuario: {}}, action) => {
    return action.type === USUARIO ? 
          { ...state, usuario: action.payload } : state;            
}



const reducer = combineReducers({
    cart,
    endereco,
    usuario
});


export default reducer;
