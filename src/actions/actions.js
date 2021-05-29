
import * as reduce from '../reducers/reducer';


export const setCart = (cart) => {
    return {
        type: reduce.CART,
        payload: cart
    }
}

export const setUsuario = (usuario) => {
    return {
        type: reduce.USUARIO,
        payload: usuario
    }
}

export const setEndereco = (endereco) => {
    return {
        type: reduce.ENDERECO,
        payload: endereco
    }
}
