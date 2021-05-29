import './index.css';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import Main from './screens/main';
import Cart from './screens/cart';
import Endereco from './screens/endereco';
import reducer from './reducers/reducer';

import reportWebVitals from './reportWebVitals';


const store = createStore(reducer);

ReactDOM.render(
  <React.StrictMode>
     <Provider store={store}>
         <BrowserRouter>
            <Switch>
                  <Route path="/" exact={true} component={Main} />
                  <Route path="/cart" component={Cart} />
                  <Route path="/endereco" component={Endereco} />
            </Switch>
         </BrowserRouter>   
     </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);



reportWebVitals();
