
import axios from 'axios';


export default class Api {
      
            
      static async saveCart(cart) {

            return await axios.post("http://api-game-store.herokuapp.com/games/", cart)
                  .then(async (resp) => {
                        return await resp.data;
                  })
                  .catch(async (err) => {
                        return false;
                  });        
      }


      static async updateCart(cartId, product) {

            return await axios.put(`http://api-game-store.herokuapp.com/games/${cartId}`, product)
            
                  .then(async (resp) => {
                        return await resp.data;
                  })
                  .catch(async (err) => {
                        return false;
                  });        
      }


      static async replaceProducts(cartId, products) {
            return await axios.put(`http://api-game-store.herokuapp.com/games/replaceProducts/${cartId}`, products)
                  
                  .then(async (resp) => {
                        return await resp.data;
                  })
                  .catch(async (err) => {
                        return false;
                  });    
      }


      static async getProductsByOrder(cartId, order) {
            return await axios.get(`http://api-game-store.herokuapp.com/games/${order}/${cartId}`)
                  
                  .then(async (resp) => {
                        return await resp.data;
                  })
                  .catch(async (err) => {
                        return false;
                  });    
      }


      static async cartsEmpty() {
            return await axios.get("http://api-game-store.herokuapp.com/games/cartsEmpty")
                  
                  .then(async (resp) => {
                        return await resp.data;
                  })
                  .catch(async (err) => {
                        return false;
                  });    
      }

      
      static async saveUser(user) {
            return await axios.post("http://api-game-store.herokuapp.com/usuario", user)
                  
                  .then(async (resp) => {
                        return await resp.data;
                  })
                  .catch(async (err) => {
                        return await err.data;
                  });    
      }

      
      static async getCEP(cep) {
          
            return await axios.get(`https://viacep.com.br/ws/${cep}/json/`)
                  .then(async (resp) => {
                        return await resp.data;
                  })
                  .catch(async (err) => {
                        return await err;
                  });        
        }

}